package kodlamaio.hrms.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.JobSeekerCvDto;
@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekerController {

	private JobSeekerService jsService;
	
	@Autowired
	public JobSeekerController(JobSeekerService jsService) {
		super();
		this.jsService = jsService;
	}
	@GetMapping("/getAll")
	public DataResult<List<JobSeeker>> getAll()
	{
		return this.jsService.getAll();
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeeker jobSeeker)
	{
		return this.jsService.add(jobSeeker);
	}
	
	@GetMapping("/getAllCv")
	public DataResult<JobSeekerCvDto> getAllCv() {
		// TODO Auto-generated method stub
		return this.jsService.getAllCv();
	}
	@GetMapping("/getAllCvByJobSeekerId")
	public DataResult<JobSeekerCvDto> getAllCvByJobSeekerId(int jobSeekerId)
	{return this.jsService.getAllCvByJobSeekerId(jobSeekerId);}
}
