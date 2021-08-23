package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.KnownLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.KnownLanguage;
@RestController
@RequestMapping("/api/knownLanguages")
public class KnownLanguageController {
	private KnownLanguageService knownLanguageService;
	@Autowired
	public KnownLanguageController(KnownLanguageService knownLanguageService) {
		super();
		this.knownLanguageService = knownLanguageService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<KnownLanguage>> getAll() {
		// TODO Auto-generated method stub
		return this.knownLanguageService.getAll();
			
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody KnownLanguage knownLanguage) {
		// TODO Auto-generated method stub
		return this.knownLanguageService.add(knownLanguage);
	}
	
}
