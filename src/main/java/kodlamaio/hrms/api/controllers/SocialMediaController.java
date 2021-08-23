package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.SocialMedia;
@RestController
@RequestMapping("/api/socialMedia")
public class SocialMediaController {
	private SocialMediaService socialMediaService;
	@Autowired
	public SocialMediaController(SocialMediaService socialMediaService) {
		super();
		this.socialMediaService = socialMediaService;
	}
	@GetMapping("/getAll")
	public DataResult<List<SocialMedia>> getAll() {
		// TODO Auto-generated method stub
		return this.socialMediaService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody SocialMedia socialMedia) {
		// TODO Auto-generated method stub
		return this.socialMediaService.add(socialMedia);
	}
	
}
