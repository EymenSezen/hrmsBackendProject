package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class PositionManager implements PositionService {
	
	private PositionDao pdao;
	
	@Autowired
	public PositionManager(PositionDao pdao) {
		super();
		this.pdao = pdao;
	}


	@Override
	public DataResult<List<JobPosition>> findAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobPosition>>(this.pdao.findAll(),"Pozisyonlar Listelendi.");
	}

	
	@Override
	public Result add(JobPosition jobPositions) {
		// TODO Auto-generated method stub
		this.pdao.save(jobPositions);
		return new SuccessResult("Pozisyon eklendi.");
	}

	
	
}
