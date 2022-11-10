package FLSStatisticEmulator.entity;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogStringError {

    @Getter
    @Setter
    private String dateTime;

    @Getter
    @Setter
    private String productFamilyId;

    @Getter
    @Setter
    private String userName;

    @Getter
    @Setter
    private String hostName;
    @Getter
    @Setter
    private ProductUtilization productUtilization;

    public LogStringError(String productFamilyId, String userName, String hostName, ProductUtilization productUtilization) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        this.dateTime = sdf.format(new Date());
        this.productFamilyId = productFamilyId;
        this.userName = userName;
        this.hostName = hostName;
        this.productUtilization = productUtilization;
    }

    public String getUserId() {
        return this.userName + "@" + this.hostName;
    }

    public String getLicense() {
        return this.productUtilization.getLicense();
    }

    public String getProduct() {
        return this.productUtilization.getProduct()+ ":" +this.productUtilization.getVersion();
    }

}
