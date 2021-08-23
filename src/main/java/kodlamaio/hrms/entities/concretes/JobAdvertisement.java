package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_advertisements")
@AllArgsConstructor
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_adv_id")
	private int jobAdvId;

	@Column(name = "job_description")
	private String jobDescription;

	@Column(name = "minimum_salary")
	private float minSalary;

	@Column(name = "maximum_salary")
	private float maxSalary;

	@Column(name = "number_of_open_positions")
	private int numOfOpenPositions;

	@Column(name = "create_time")
	//@JsonIgnore
	private  LocalDate createdTime;
	
	@Column(name = "latest_apply_time")
	//@JsonIgnore
	private LocalDate lastTime;

	@Column(name = "is_active")
	//@JsonIgnore
	private boolean isActive = true;

	@ManyToOne()
	@JoinColumn(name = "city_id",referencedColumnName="city_id")
	private City city;

	@ManyToOne()
	@JoinColumn(name = "position_id",referencedColumnName="position_id")
	private JobPosition jobPosition;

	@ManyToOne()
	@JoinColumn(name = "employer_id",referencedColumnName="employer_id")
	private Employer employer;
	
	
	public JobAdvertisement()
	{
		this.createdTime=LocalDate.now();
	}

}
