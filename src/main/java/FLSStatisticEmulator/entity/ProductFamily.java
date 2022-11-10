package FLSStatisticEmulator.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProductFamily {

    protected static ArrayList<String> productFamilyList = new ArrayList<>(
            List.of("342e66b2-956c-4384-81da-f50365b990e9",
                    "c9e1fa2c-9f19-4ad7-935c-481ca0c2d23c",
                    "5931f436-2506-415e-a0a9-27f50d7f62bf",
                    "e8d15448-eecd-440e-bbe9-1e5f754d781b",
                    "0d85f2cc-b84f-44c7-b319-93997d080ac9",
                    "49c202d4-ac56-452b-bb84-735056242fb3",
                    "6ca374ac-f547-4984-be94-adb3e47b580c",
                    "94ed896e-599e-4e2c-8724-204935e593ff",
                    "cfc7082d-ae43-4978-a2a2-46feb1679405"));

    public static String getRandomProduct(){
        int randomNum = ThreadLocalRandom.current().nextInt(0, productFamilyList.size());
        return productFamilyList.get(randomNum);
    }




}
