package kodlamaio.hrms.business.concretes;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.abstracts.CloudService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entities.concretes.Image;
@Service
public class ImageManager implements ImageService{
	JobSeekerService jobSeekerService;
	ImageDao imageDao;  //sorgular var
	CloudService cloudService;
	
	
	@Autowired
	public ImageManager(JobSeekerService jobSeekerService, ImageDao imageDao,
			CloudService cloudService) {
		super();
		this.jobSeekerService = jobSeekerService;
		this.imageDao = imageDao;
		this.cloudService = cloudService;
	}

	@Override
	public Result add(MultipartFile multipartFile, int jobSeekerId) {
		// TODO Auto-generated method stub
		var result=this.cloudService.upload(multipartFile);
		if(!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		var jobSeeker = this.jobSeekerService.getById(jobSeekerId).getData();
		Image image = new Image();
		image.setJobSeeker(jobSeeker);
		image.setImageUrl(result.getData().get("url"));
		image.setPublicId(result.getData().get("public_id"));
		this.imageDao.save(image);
		return new SuccessResult("Fotoğraf eklendi");
	}

	@Override
	public Result delete(int id) throws IOException {
		// TODO Auto-generated method stub
		var publicId = this.imageDao.findById(id).get().getPublicId();
		var result = this.cloudService.delete(publicId);
		this.imageDao.deleteById(id);
        return new SuccessResult("Fotoğraf silindi");
	}

	@Override
	public DataResult<Image> getByJobSeekerId(int jobSeekerId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult(this.imageDao.getByJobSeekerId(jobSeekerId));
	}

	@Override
	public DataResult<Image> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult(this.imageDao.findAll(),"Data Listelendi");
	}

}
