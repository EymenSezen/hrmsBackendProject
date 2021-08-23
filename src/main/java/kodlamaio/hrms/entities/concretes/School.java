package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="schools")
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class School {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="schoolName")
	private String schoolName;
	
	@Column(name="schoolDepartment")
	private String schoolDepartment;
	
	@NotNull
	@Column(name="first_year")
	private @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate firstYear;
	
	
	@Column(name="last_year")
	private  String lastYear;
	
	@ManyToOne()
	@JoinColumn(name = "job_seeker_id",referencedColumnName="user_id")
	private JobSeeker jobSeeker;
}
