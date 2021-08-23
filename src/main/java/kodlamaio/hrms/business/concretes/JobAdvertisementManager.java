package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	private JobAdvertisementDao jobAdvDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvDao) {
		super();
		this.jobAdvDao = jobAdvDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		// TODO Auto-generated method stub
		this.jobAdvDao.save(jobAdvertisement);
		return new SuccessResult("İş İlanı Eklendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActiveTrue() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvDao.getAllByIsActiveTrue(),"Data Listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActiveTrueOrderByCreatedTimeDesc() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvDao.getAllByIsActiveTrueOrderByCreatedTimeDesc(),"Data Listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActiveTrueOrderByCreatedTimeAsc() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvDao.getAllByIsActiveTrueOrderByCreatedTimeAsc(),"Data Listelendi.");
	}

	@Override
	public Result getAllByEmployer_IdAndIsActiveTrue(int employerId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvDao.getAllByEmployer_IdAndIsActiveTrue(employerId),"Data Listelendi.");
	}

	@Override
	public Result getAllByEmployer_CompanyNameAndIsActiveTrue(String companyName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult(this.jobAdvDao.getAllByEmployer_CompanyNameAndIsActiveTrue(companyName),"Data Listelendi");
	}
	
	

}
