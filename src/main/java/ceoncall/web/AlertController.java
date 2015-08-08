package ceoncall.web;

import ceoncall.domain.TeamMember;
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

    @RequestMapping(value="/alert", method= RequestMethod.POST)
    public ResponseEntity<String> alert(@RequestBody String alert) {

        return new ResponseEntity<String>(alert, HttpStatus.OK);

    }
}
