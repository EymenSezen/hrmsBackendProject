package kodlamaio.hrms.api.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;

@RestController
@RequestMapping("/api/images")
public class ImageController {
	private ImageService imageService;
	@Autowired
	public ImageController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	@PostMapping("/add")
	public Result add(@RequestPart MultipartFile multipartFile, int jobSeekerId) {
		return this.imageService.add(multipartFile, jobSeekerId);
		// TODO Auto-generated method stub
	
	}

	@GetMapping("/delete")
	public Result delete(int id) throws IOException {
		// TODO Auto-generated method stub
		return this.imageService.delete(id);
	}

	@GetMapping("/getByJobSeekerId")
	public DataResult<Image> getByJobSeekerId(int jobSeekerId) {
		// TODO Auto-generated method stub
		return this.imageService.getByJobSeekerId(jobSeekerId);
	}

	@GetMapping("/getAll")
	public DataResult<Image> getAll() {
		// TODO Auto-generated method stub
		return this.imageService.getAll();
	}
	
}
