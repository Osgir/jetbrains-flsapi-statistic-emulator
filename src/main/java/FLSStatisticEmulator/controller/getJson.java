package FLSStatisticEmulator.controller;

import FLSStatisticEmulator.service.LogStringUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class getJson {

    @Autowired
    LogStringUtilService logStringUtilService;

    @RequestMapping(value = "/tickets-report.json", method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public String ticketsReport() {
        return logStringUtilService.getLogListString();
    }

}
