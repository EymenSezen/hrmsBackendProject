package kodlamaio.hrms.core.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.PersonalMailService;
import kodlamaio.hrms.entities.abstracts.User;
@Service
public class PersonalMailManager implements PersonalMailService {

	@Override
	public void personalVerificationMail(User user) {
		// TODO Auto-generated method stub
		System.out.println(user.getEmail()+ "hrms personeli tarafından doğrulandı");
	
	}

	
}
