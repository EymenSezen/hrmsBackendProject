package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.*;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="employer_id", referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})

public class Employer extends User{
		//@Id
		//@GeneratedValue(strategy=GenerationType.IDENTITY)
		//@Column(name="id")
		//private int id;
		
		@Column(name="company_name")
		private String companyName;
		
		@Column(name="website")
		private String webSite;

		@Column(name="phone_number")
		private String phoneNumber;
		@JsonIgnore
		@OneToMany(mappedBy="employer")
		private List<JobAdvertisement> jobAdvertisements;
		 
}
