package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.checks.abstracts.EmployerCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
@Service
public class EmployerManager implements EmployerService{
    private EmployerDao employerDao;
    private EmployerCheckService employerCheckService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,EmployerCheckService employerCheckService) {
		super();
		this.employerDao = employerDao;
		this.employerCheckService=employerCheckService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş Verenler Listelendi.");
	}

	@Override
	public Result add(Employer employer) {
		// TODO Auto-generated method stub
		if(!this.employerCheckService.check(employer).isSuccess())
		{
		return employerCheckService.check(employer);
		}
		this.employerDao.save(employer);
		return new SuccessResult("İş Veren Eklendi.");
		
	}

}
