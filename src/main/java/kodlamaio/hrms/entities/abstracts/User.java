package kodlamaio.hrms.entities.abstracts;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy=InheritanceType.JOINED)

public abstract class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email")
    private String email;
	
	@Column(name="password")
    private String password;
	
	@Column(name="passwordrepeat")
	private String passwordRepeat;
	

}
