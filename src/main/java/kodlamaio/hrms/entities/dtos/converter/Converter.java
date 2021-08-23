package kodlamaio.hrms.entities.dtos.converter;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.JobSeekerCvDto;
@Component
public class Converter {
public JobSeekerCvDto convertToCv(JobSeeker from) {
		
		return new JobSeekerCvDto(from.getId(),
				from.getKnownLanguages(),
				from.getKnownTechnologies(),
				from.getImage(),
				from.getSocialMedias(),
				from.getSchools(),
				from.getExperiences(),
				from.getCoverLetters());
	}
//from.get job position ayrı olarak eklemediğim için covert etmedim
}
