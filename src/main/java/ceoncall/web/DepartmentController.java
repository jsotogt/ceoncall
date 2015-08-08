package ceoncall.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ceoncall.domain.Department;
import ceoncall.service.DepartmentService;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentsService;

    @RequestMapping("/departments")
    public List<Department> getAll()
    {
        return departmentsService.findAll();
    }

    @RequestMapping("/department/name")
    public List<String> getAllNames() {

        List<String> names = new ArrayList<>();

        for(Department d : departmentsService.findAll()) {
            names.add(d.getName());
        }

        return names;

    }

}
