package ceoncall.web;

import ceoncall.domain.TeamMember;
import ceoncall.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AlertController {

    @Autowired
    AlertService alertService;

    @RequestMapping(value="/alert", method= RequestMethod.POST)
    public ResponseEntity alert(@RequestBody String alert) {

        alertService.email(alert);

        alertService.sendSMS(alert);

        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping(value="/oncall", method= RequestMethod.GET)
    public ResponseEntity<List<TeamMember>> oncall() {

        return new ResponseEntity(alertService.oncall(), HttpStatus.OK);

    }


}
