package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();
	Result add(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getAllByIsActiveTrue();
	DataResult<List<JobAdvertisement>> getAllByIsActiveTrueOrderByCreatedTimeDesc();
	DataResult<List<JobAdvertisement>> getAllByIsActiveTrueOrderByCreatedTimeAsc();
	Result getAllByEmployer_IdAndIsActiveTrue (int companyName);
	Result getAllByEmployer_CompanyNameAndIsActiveTrue (String companyName);  


}
