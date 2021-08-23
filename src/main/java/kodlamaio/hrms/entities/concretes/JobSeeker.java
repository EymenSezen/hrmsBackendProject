package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="job_seekers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="user_id", referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
public class JobSeeker extends User {
	//@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="user_id")
	//private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="id_no")
	private String idNo;
	
	
	@Column(name="birthdate_year")
	private int bdayyear;
	
	@JsonIgnore
	@OneToMany(mappedBy="jobSeeker")
	private List<School> schools;	
	
	@JsonIgnore
	@OneToMany(mappedBy="jobSeeker")
	private List<CoverLetter> coverLetters;
	
	@JsonIgnore
	@OneToMany(mappedBy="jobSeeker")
	private List<Experience> experiences;
	
	@JsonIgnore
	@OneToMany(mappedBy="jobSeeker")
	List<KnownLanguage> knownLanguages;
	
	@JsonIgnore
	@OneToMany(mappedBy="jobSeeker")
	List<KnownTechnology> knownTechnologies;
	
	@JsonIgnore
	@OneToMany(mappedBy="jobSeeker")
	List<SocialMedia> socialMedias;
	
	@JsonIgnore
	@OneToOne(mappedBy="jobSeeker")
	private Image image;
	
}
