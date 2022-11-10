package FLSStatisticEmulator.entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProductUtilization {

    @Getter
    private final String license;
    @Getter
    private final String product;
    @Getter
    private final String version;


    protected static ArrayList<ProductUtilization> productUtilizationList = new ArrayList<>(
            List.of(
                    new ProductUtilization("AppCode Toolbox", "AC", "2021.3"),
                    new ProductUtilization("CLion Toolbox", "CL", "2021.3"),
                    new ProductUtilization("DataGrip Toolbox", "DB", "2021.3"),
                    new ProductUtilization("DataSpell Toolbox", "DS", "2021.3"),
                    new ProductUtilization("dotCover Toolbox", "DC", "2021.3"),
                    new ProductUtilization("dotUltimate Toolbox", "DM", "2021.3"),
                    new ProductUtilization("dotUltimate Toolbox", "DPN", "2021.3"),
                    new ProductUtilization("dotUltimate Toolbox", "DUL", "2021.3"),
                    new ProductUtilization("GoLand Toolbox", "GO", "2021.3"),
                    new ProductUtilization("IntelliJ IDEA Ultimate Toolbox", "II", "2021.3"),
                    new ProductUtilization("PhpStorm Toolbox", "PS", "2021.3"),
                    new ProductUtilization("PyCharm Toolbox", "PC", "2021.3"),
                    new ProductUtilization("ReSharper Toolbox", "RSC", "2021.3"),
                    new ProductUtilization("dotUltimate Toolbox", "RD", "2021.3"),
                    new ProductUtilization("ReSharper C++ Toolbox", "RC", "2021.3"),
                    new ProductUtilization("ReSharper Ultimate + Rider Toolbox", "RRR", "2021.3"),
                    new ProductUtilization("Rider Toolbox", "RD", "2021.3"),
                    new ProductUtilization("RubyMine Toolbox", "RM", "2021.3"),
                    new ProductUtilization("WebStorm Toolbox", "WS", "2021.3"),
                    new ProductUtilization("CLion 2020.1", "Cl", "2020.1"),
                    new ProductUtilization("ReSharper 2019.3", "RC", "2019.3"),
                    new ProductUtilization("PyCharm 2019.3", "PC", "2019.3"),
                    new ProductUtilization("IntelliJ IDEA Ultimate 2020.3", "II", "2020.3"),
                    new ProductUtilization("CLion 2020.3", "CL", "2020.3"),
                    new ProductUtilization("PyCharm 2020.3", "PC", "2020.3"),
                    new ProductUtilization("DataGrip 2020.3", "DB", "2020.3"),
                    new ProductUtilization("DataGrip 2019.3", "DB", "2019.3"),
                    new ProductUtilization("WebStorm 2019.3", "WS", "2019.3"),
                    new ProductUtilization("IntelliJ IDEA Ultimate 2019.3", "II", "2019.3"),
                    new ProductUtilization("WebStorm 2020.3", "WS", "2020.3")
            ));

    public ProductUtilization(String license, String product, String version) {
        this.license = license;
        this.product = product;
        this.version = version;
    }

    public static ProductUtilization getRandomProduct() {
        return productUtilizationList.get(
                ThreadLocalRandom.current().nextInt(0, productUtilizationList.size())
        );
    }

}

