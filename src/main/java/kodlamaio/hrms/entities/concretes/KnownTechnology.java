package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name="known_technologies")
@NoArgsConstructor
@AllArgsConstructor
public class KnownTechnology {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="technology_level")
	private int technologyLevel;
	@JoinColumn(name="tech_id")
	@ManyToOne
	private Technology technology;
	@JoinColumn(name="job_seeker_id")
	@ManyToOne
	private JobSeeker jobSeeker;
}
