package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.KnownTechnology;

public interface KnownTechnologyService {
	DataResult<List<KnownTechnology>> getAll();
	Result add(KnownTechnology knownTechnology);
}
