package ceoncall.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ceoncall.domain.Department;
import ceoncall.domain.TeamMember;
import ceoncall.service.DepartmentService;
import ceoncall.service.ScheduleService;

@RestController
public class DepartmentController
{
	final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>()
	{
		@Override
		protected DateFormat initialValue()
		{
			return new SimpleDateFormat("yyyy-MM-dd mm:hh:ss");
		}
	};

	@Autowired
	private DepartmentService departmentsService;

	@Autowired
	private ScheduleService scheduleService;

	@RequestMapping("/departments")
	public List<Department> getAll()
	{
		return departmentsService.findAll();
	}

	@RequestMapping(value = "/department/{id}/oncall", method = RequestMethod.GET)
	public ResponseEntity<List<TeamMember>> getOnCall(@PathVariable int id, @RequestParam String startDate, @RequestParam String endDate)
	{
		DateFormat df = this.df.get();
		Date startDateDate;
		Date endDateDate;
		try
		{
			startDateDate = df.parse(startDate);
			endDateDate = df.parse(endDate);
		}
		catch (ParseException e)
		{
			return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
		}
		return new ResponseEntity<List<TeamMember>>(scheduleService.getOnCall(id, startDateDate, endDateDate), HttpStatus.OK);
	}

	@RequestMapping("/department/name")
	public List<String> getAllNames()
	{

		List<String> names = new ArrayList<>();

		for (Department d : departmentsService.findAll())
		{
			names.add(d.getName());
		}

		return names;

	}

}
