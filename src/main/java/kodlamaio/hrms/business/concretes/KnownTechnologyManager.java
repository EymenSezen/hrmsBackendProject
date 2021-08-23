package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import kodlamaio.hrms.business.abstracts.KnownTechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.KnownTechnologyDao;
import kodlamaio.hrms.entities.concretes.KnownTechnology;
@Service
public class KnownTechnologyManager implements KnownTechnologyService{
	private KnownTechnologyDao knownTechnologyDao;
	@Autowired
	public KnownTechnologyManager(KnownTechnologyDao knownTechnologyDao) {
		super();
		this.knownTechnologyDao = knownTechnologyDao;
	}

	@Override
	public DataResult<List<KnownTechnology>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult(this.knownTechnologyDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result add(@RequestBody KnownTechnology knownTechnology) {
		// TODO Auto-generated method stub
		this.knownTechnologyDao.save(knownTechnology);
		return new SuccessResult("Data eklendi");
	}
	
}
