package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.KnownTechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.KnownTechnology;

@RestController
@RequestMapping("/api/knownTechnologies")
public class KnownTechnologyController {
	private KnownTechnologyService knownTechnologyService;
	@Autowired
	public KnownTechnologyController(KnownTechnologyService knownTechnologyService) {
		super();
		this.knownTechnologyService = knownTechnologyService;
	}
	@GetMapping("/getAll")
	public DataResult<List<KnownTechnology>> getAll() {
		// TODO Auto-generated method stub
		return this.knownTechnologyService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody KnownTechnology knownTechnology) {
		// TODO Auto-generated method stub
		
		return this.knownTechnologyService.add(knownTechnology);
	}
	
}
