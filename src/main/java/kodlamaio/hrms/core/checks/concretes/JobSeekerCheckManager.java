package kodlamaio.hrms.core.checks.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.MailService;
import kodlamaio.hrms.core.abstracts.MernisService;
import kodlamaio.hrms.core.checks.abstracts.JobSeekerCheckService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
@Service
public class JobSeekerCheckManager implements JobSeekerCheckService {

	
	UserDao userDao;//email kontrolu için
	JobSeekerDao jobSeekerDao;//tc no kontrolü için
	MernisService mernisService;
	MailService mailService;
	@Autowired
	public JobSeekerCheckManager(UserDao userDao, JobSeekerDao jobSeekerDao, MernisService mernisService,
			MailService mailService) {
		super();
		this.userDao = userDao;
		this.jobSeekerDao = jobSeekerDao;
		this.mernisService = mernisService;
		this.mailService = mailService;
	}

	@Override
	public Result check(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		if(jobSeeker.getEmail().isEmpty()||jobSeeker.getName().isEmpty()||jobSeeker.getSurname().isEmpty()
				||jobSeeker.getPassword().isEmpty()||jobSeeker.getPasswordRepeat().isEmpty()||
				String.valueOf(jobSeeker.getBdayyear()).isEmpty()) {
				return new ErrorResult("Tüm Bilgilerinizi Doldurunuz.");
		}
		else if(!mernisService.isRealPerson(jobSeeker))
		{
			return new ErrorResult("Bu Bilgilere Ait Biri Bulunamadı.");
		}
		//email varMi?
		else if(userDao.existsByEmail(jobSeeker.getEmail()))
		{
			return new ErrorResult("Bu Email Kullanılıyor Lütfen Değiştiriniz.");
		}
		else if(jobSeekerDao.existsByIdNo(jobSeeker.getIdNo()))
		{
			return new ErrorResult("Bu Kimlik Numarası Kullanılıyor.");
		}
		else if(!jobSeeker.getPassword().equals(jobSeeker.getPasswordRepeat()))
		{
				return new ErrorResult("Parolalar Eşleşmiyor.");
		}
		else if(!mailService.isVerification(jobSeeker))
		{
			return new ErrorResult("Kullanıcı Doğrulanamadı.");
		}
		else
		{
			this.mailService.sendMail(jobSeeker);
			this.mailService.verificationMail(jobSeeker);
			System.out.println("Bütün Bilgileriniz Doğrulanmıştır.");
			return new SuccessResult("Bütün Bilgilerininiz Doğrulandı.");
		}
			
		
		
	}

}
