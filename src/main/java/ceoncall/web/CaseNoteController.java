package ceoncall.web;

import ceoncall.domain.CaseNote;
import ceoncall.service.CaseNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CaseNoteController {

    @Autowired
    private CaseNoteService caseNoteService;

    @RequestMapping(value="/casenote/{schedule_id}", method= RequestMethod.GET)
    public List<CaseNote> get(@PathVariable("schedule_id") int id)
    {
        return caseNoteService.findByScheduleId(id);
    }

    @RequestMapping(value="/casenote", method=RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody CaseNote c)
    {
        caseNoteService.save(c);

        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
