package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.School;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {
	private SchoolService schoolService;
	@Autowired
	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	@GetMapping("/getAll")
	public DataResult<List<School>> getAll() {
		// TODO Auto-generated method stub
		return this.schoolService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody School school) {
		// TODO Auto-generated method stub
		return this.schoolService.add(school);
	}
	@GetMapping("/getAllByJobSeekerIdOrderByLastYearDesc")
	public DataResult<List<School>> getAllByJobSeekerIdOrderByLastYearDesc( int id) {
		// TODO Auto-generated method stub
		return this.schoolService.getAllByJobSeekerIdOrderByLastYearDesc(id);
	}
	
	
}
