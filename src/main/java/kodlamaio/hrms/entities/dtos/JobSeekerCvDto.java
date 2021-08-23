package kodlamaio.hrms.entities.dtos;

import java.util.List;

import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.KnownLanguage;
import kodlamaio.hrms.entities.concretes.KnownTechnology;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.concretes.SocialMedia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
//@AllArgsConstructor
public class JobSeekerCvDto {
	
	
	public JobSeekerCvDto(int jobSeekerId, List<KnownLanguage> knownLanguages, List<KnownTechnology> knownTechnologies,
			Image image, List<SocialMedia> socialMedias, List<School> schools, List<Experience> experiences,
			List<CoverLetter> coverLetters) {
		super();
		this.jobSeekerId = jobSeekerId;
		this.knownLanguages = knownLanguages;
		this.knownTechnologies = knownTechnologies;
		this.image = image;
		this.socialMedias = socialMedias;
		this.schools = schools;
		this.experiences = experiences;
		this.coverLetters = coverLetters;
	}
	private int jobSeekerId;
	private List<KnownLanguage> knownLanguages;
	private List<KnownTechnology> knownTechnologies;
	//private JobPosition jobPosition;
	private Image image;
	private List<SocialMedia> socialMedias;
	private List<School> schools;
	private List<Experience> experiences;
	private List<CoverLetter> coverLetters;
}
