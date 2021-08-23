package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.entities.abstracts.User;

public interface MailService {
     
	void sendMail(User user);
	void verificationMail(User user);
	boolean isVerification(User user);
}
