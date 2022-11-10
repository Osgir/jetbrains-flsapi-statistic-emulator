package FLSStatisticEmulator.service;

import FLSStatisticEmulator.entity.LogStringError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static FLSStatisticEmulator.config.AppSettings.listUsers;

public class LogFileGenerator {

    private static final Logger logger = LoggerFactory.getLogger(LogFileGenerator.class);
    private static final String appSettingsConfigFilepath = "license-server-stdout.log";

    @Scheduled(cron = "0 0/5 * * * *")
    protected void makeFile() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LogStringError st : listUsers ) {
            stringBuilder.append(genStr(st));
        }
        try (FileWriter fileWriter = new FileWriter(appSettingsConfigFilepath, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(stringBuilder);
            printWriter.flush();

        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    private StringBuilder genStr(LogStringError st) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(st.getDateTime());
        stringBuilder.append("] WARN  a:173 - Tickets obtaining prohibited for ObtainTicketRequest[buildDate='', buildNumber='', clientVersion='', edition='', hostName='");
        stringBuilder.append(st.getHostName());
        stringBuilder.append("', ip='', machineId='', productCode='', productFamilyId='");
        stringBuilder.append(st.getProductFamilyId());
        stringBuilder.append("', salt='', secure='', userName='");
        stringBuilder.append(st.getUserName());
        stringBuilder.append("', version='', versionNumber=''].");
        return stringBuilder;
    }
}
