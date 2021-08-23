package kodlamaio.hrms.entities.concretes;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="cover_letters")
@AllArgsConstructor
@NoArgsConstructor
public class CoverLetter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	
	@ManyToOne()
	@JoinColumn(name="job_seeker_id",referencedColumnName="user_id")
	private JobSeeker jobSeeker;
}
