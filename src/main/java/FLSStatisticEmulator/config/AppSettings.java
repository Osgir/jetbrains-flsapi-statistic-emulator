package FLSStatisticEmulator.config;

import FLSStatisticEmulator.entity.LogStringError;
import FLSStatisticEmulator.entity.ProductFamily;
import FLSStatisticEmulator.entity.ProductUtilization;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import static FLSStatisticEmulator.service.NameGenerator.generateName;


@Configuration
public class AppSettings {

    public static ArrayList<LogStringError> listUsers = new ArrayList<>();
    public static Integer totalUsers;

    @Bean
    public static void loadSettings() {
        if (AppSettings.load()) {
            totalUsers = AppSettings.getInt("totalUsers", 10);
            listUsers = collectUsers();
        }

    }

    public AppSettings() {
        fHashMap = new HashMap<>();
    }

    private final HashMap<String, Object> fHashMap;
    private static final AppSettings SINGLETON;

    static {
        SINGLETON = new AppSettings();
    }

    public static ArrayList<LogStringError> collectUsers() {
        ArrayList<LogStringError> logStringErrors = new ArrayList<>();
        int bb = 1;
        if (totalUsers != null) bb = totalUsers;
        for (int i = 0; i < bb; i++) {
            logStringErrors.add(new LogStringError(ProductFamily.getRandomProduct()
                    , "userName" + generateName()
                    , "hostname" + generateName()
                    , ProductUtilization.getRandomProduct()));
        }
        return logStringErrors;
    }


    public static int getInt(String key, int deflt) {
        Object obj = SINGLETON.fHashMap.get(key);
        if (obj == null) {
            return deflt;
        } else {
            return Integer.parseInt((String) obj);
        }
    }

    public static void put(String key, Object data) {

        if (data == null) {
            throw new IllegalArgumentException();
        } else {
            SINGLETON.fHashMap.put(key, data);
        }
    }


    public static boolean load() {
        try {
            File file = new File("settings.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            if (doc == null) {
                throw new NullPointerException();
            }
            NodeList propertiesNL = doc.getDocumentElement().getChildNodes();
            for (int i = 0; (i < propertiesNL.getLength()); i++) {
                if (propertiesNL.item(i).getNodeName().equals("properties")) {
                    NodeList propertyList = propertiesNL.item(i).getChildNodes();
                    for (int j = 0; j < propertyList.getLength(); j++) {
                        NamedNodeMap attributes = propertyList.item(j).getAttributes();
                        if (attributes != null) {
                            Node n = attributes.getNamedItem("key");
                            NodeList childs = propertyList.item(j).getChildNodes();
                            if (childs != null) {
                                for (int k = 0; k < childs.getLength(); k++) {
                                    if (childs.item(k).getNodeType() == Node.TEXT_NODE) {
                                        put(n.getNodeValue(), childs.item(k).getNodeValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
