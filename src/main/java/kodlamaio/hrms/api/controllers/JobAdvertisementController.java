package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertiments")
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvService) {
		super();
		this.jobAdvService = jobAdvService;
	}

	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {

		return this.jobAdvService.add(jobAdvertisement);

	}

	@GetMapping("/getAllByIsActiveTrue")
	public DataResult<List<JobAdvertisement>> getAllByIsActiveTrue() {
		// TODO Auto-generated method stub
		return this.jobAdvService.getAllByIsActiveTrue();
	}

	@GetMapping("/getAllByIsActiveTrueOrderByCreatedTimeDesc")
	public DataResult<List<JobAdvertisement>> getAllByIsActiveTrueOrderByCreatedTimeDesc() {
		// TODO Auto-generated method stub
		return this.jobAdvService.getAllByIsActiveTrueOrderByCreatedTimeDesc();
	}

	@GetMapping("/getAllByIsActiveTrueOrderByCreatedTimeAsc")
	public DataResult<List<JobAdvertisement>> getAllByIsActiveTrueOrderByCreatedTimeAsc() {
		// TODO Auto-generated method stub
		return this.jobAdvService.getAllByIsActiveTrueOrderByCreatedTimeAsc();
	}

	@GetMapping("/getByEmployerId")
	public Result getAllByEmployer_IdAndIsActivatedTrue(int employerId) {
		// TODO Auto-generated method stub
		return this.jobAdvService.getAllByEmployer_IdAndIsActiveTrue(employerId);
	}
	@GetMapping("/getByCompanyName")
	public Result getAllByEmployer_CompanyNameAndIsActiveTrue (String companyName) {
		 return this.jobAdvService.getAllByEmployer_CompanyNameAndIsActiveTrue(companyName);
	} 

}
