package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.TechnologyDao;
import kodlamaio.hrms.entities.concretes.Technology;
@Service
public class TechnologyManager implements TechnologyService{
	private TechnologyDao technologyDao;
	@Autowired
	public TechnologyManager(TechnologyDao technologyDao) {
		super();
		this.technologyDao = technologyDao;
	}

	@Override
	public DataResult<List<Technology>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Technology>>(this.technologyDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result add(Technology technology) {
		// TODO Auto-generated method stub
		this.technologyDao.save(technology);
		return new SuccessResult("Data Eklendi");
	}

}
