package kodlamaio.hrms.core.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.MailService;
import kodlamaio.hrms.entities.abstracts.User;
@Service
public class MailManager implements MailService {

	@Override
	public void sendMail(User user) {
		System.out.println(user.getEmail()+" doğrulama mailidir.");
	}

	@Override
	public void verificationMail(User user) {
		// TODO Auto-generated method stub
		System.out.println(user.getEmail()+" doğrulandı");
	}

	@Override
	public boolean isVerification(User user) {
		// TODO Auto-generated method stub
		return true;
	}

}
