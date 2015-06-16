package ceoncall.web;

import ceoncall.domain.Department;
import ceoncall.domain.Team;
import ceoncall.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentsService;

    @RequestMapping("/departments")
    public List<Department> getAll()
    {
        return departmentsService.findAll();
    }

}
