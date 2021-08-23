package kodlamaio.hrms.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;

public interface ImageService {
	Result add(MultipartFile multipartFile, int jobSeekerId);
	Result delete(int id) throws IOException;
	DataResult<Image> getByJobSeekerId (int jobSeekerId);
	DataResult<Image> getAll();
}
