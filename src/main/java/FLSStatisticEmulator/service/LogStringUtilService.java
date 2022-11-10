package FLSStatisticEmulator.service;

import FLSStatisticEmulator.entity.LogStringError;
import FLSStatisticEmulator.entity.LogStringUtil;
import org.springframework.stereotype.Service;

import static FLSStatisticEmulator.config.AppSettings.listUsers;

@Service
public class LogStringUtilService {

    public String getLogListString() {
        LogStringUtil logStringUtil = new LogStringUtil();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (LogStringError st : listUsers) {
            sb.append(logStringUtil.generateString(st.getUserId(), st.getLicense(), st.getProduct()));
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
