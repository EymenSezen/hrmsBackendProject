package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface MernisService {
boolean isRealPerson(JobSeeker jobSeeker);
}
