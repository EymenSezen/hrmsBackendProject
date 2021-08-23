package kodlamaio.hrms.core.checks.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

//import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerCheckService {

	Result check(JobSeeker jobSeeker);
}
