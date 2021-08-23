package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.checks.abstracts.JobSeekerCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.JobSeekerCvDto;
import kodlamaio.hrms.entities.dtos.converter.Converter;
@Service
public class JobSeekerManager implements JobSeekerService{
	private JobSeekerDao jsDao;
	private JobSeekerCheckService jscService;
	private Converter converter;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jsDao,JobSeekerCheckService jscService,Converter converter) {
		super();
		this.jsDao = jsDao;
		this.jscService=jscService;
		this.converter=converter;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobSeeker>>(this.jsDao.findAll(),"İş Arayanlar Listelendi.");
	}
	
	@Override
	public Result add(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		
		if(!jscService.check(jobSeeker).isSuccess())
		{
		
			return this.jscService.check(jobSeeker);//hep kontrol ettiriyoruz  iş kurallarına ve sonrasında ekliyoruz
			
		}
		this.jsDao.save(jobSeeker);
		return new SuccessResult("İş Arayan Eklendi.");
	}

	@Override
	public DataResult<JobSeeker> getById(int jobSeekerId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult(this.jsDao.getById(jobSeekerId));
	}

	@Override
	public DataResult<JobSeekerCvDto> getAllCv() {
		// TODO Auto-generated method stub
		return new SuccessDataResult(this.jsDao.findAll()
				.stream()
				.map(converter::convertToCv)
				.collect(Collectors.toList()),"Data Listelendi");	}

	@Override
	public DataResult<JobSeekerCvDto> getAllCvByJobSeekerId(int jobSeekerId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult(this.jsDao.findById(jobSeekerId)
				.stream()
				.map(converter::convertToCv)
				.collect(Collectors.toList()),"Kişi Listelendi");
	}

	
	 

}
