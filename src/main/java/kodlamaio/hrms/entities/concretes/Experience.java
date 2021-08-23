package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="experiences")
@AllArgsConstructor
@NoArgsConstructor
public class Experience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="work_place")
	private String workPlace;
	
	@Column(name="first_time")
	private LocalDate firstTime;
	
	@Column(name="last_time")
	private String lastTime;
	
	@ManyToOne()
	@JoinColumn(name="job_position_id",referencedColumnName="position_id")
	private JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name="job_seeker_id",referencedColumnName="user_id")
	private JobSeeker jobSeeker;
	
	
}
