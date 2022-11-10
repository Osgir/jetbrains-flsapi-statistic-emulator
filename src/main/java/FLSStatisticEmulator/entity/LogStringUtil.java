package FLSStatisticEmulator.entity;

import lombok.Getter;
import lombok.Setter;

public class LogStringUtil {

    @Getter
    @Setter
    private String userId;

    @Getter
    @Setter
    private String license;

    @Getter
    @Setter
    private String product;

    public LogStringUtil() {
    }

    public LogStringUtil(String user, String host, String license, String product, String version) {
        this.userId = user + "@" + host;
        this.license = license;
        this.product = product + ":" + version;
    }

    public String generateString(String userid, String license, String product) {
        return "{" +
                "\"ticketId\": \"testtid\"," +
                "\"userId\": \"" + userid + "\"," +
                "\"clientId\": \"d001a808-1d3f-4a05-8318-7053180059b7\"," +
                "\"ip\": \"127.0.0.1\"," +
                "\"license\": \"" + license + "\"," +
                "\"product\": \"" + product + "\"," +
                "\"issued\": \"2018-03-27T18:22:46.689+0300\"," +
                "\"last_seen\": \"2018-03-27T18:42:54.249+0300\""+
                "},";
    }
}
