package kodlamaio.hrms.core.checks.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.MailService;
import kodlamaio.hrms.core.abstracts.PersonalMailService;
import kodlamaio.hrms.core.checks.abstracts.EmployerCheckService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerCheckManager implements EmployerCheckService {
	UserDao userDao;
	EmployerDao employerDao;
	MailService mailService;
	PersonalMailService personalMailService;
	@Autowired
	public EmployerCheckManager(UserDao userDao, MailService mailService,
			PersonalMailService personalMailService,EmployerDao employerDao) {
		super();
		this.userDao = userDao;
		this.mailService = mailService;
		this.personalMailService = personalMailService;
		this.employerDao=employerDao;
	}

	@Override
	public Result check(Employer employer) {
		// TODO Auto-generated method stub
		if (employer.getCompanyName().isEmpty() || employer.getEmail().isEmpty() || employer.getPassword().isEmpty()
				|| employer.getPasswordRepeat().isEmpty() || employer.getPhoneNumber().isEmpty()
				|| employer.getWebSite().isEmpty()) {
			return new ErrorResult("Tüm Bilgilerinizi Doldurunuz.");
		} 
		else if (!employer.getWebSite().contains(employer.getEmail().split("@")[0])&&!employer.getEmail().contains(employer.getWebSite().split(".")[0])) {
			return new ErrorResult("Mailiniz Web Sitesi Domainine Sahip Değil.");
		}
		else if(userDao.existsByEmail(employer.getEmail()))
		{
			return new ErrorResult("Bu Email Kullanılıyor Lütfen Değiştiriniz.");
		}
		else if(!employer.getPassword().equals(employer.getPasswordRepeat()))
		{
			return new ErrorResult("Parolalar Eşleşmiyor.");
		}
		//fake service
		else if(!mailService.isVerification(employer))
		{
			return new ErrorResult("Kullanıcı Doğrulanamadı");
		}
		else if(employerDao.existsByPhoneNumber(employer.getPhoneNumber()))
		{
			return new ErrorResult("Bu Telefon Numarası Kullanılıyor.");
		}
		else
		{
			this.mailService.sendMail(employer);
			this.mailService.verificationMail(employer);
			this.personalMailService.personalVerificationMail(employer);
			System.out.println("Bütün Bilgiler Doğrulandı");
			return new SuccessResult("Bütün Bilgiler Doğrulandı.");
		}
		
		
	}

}
