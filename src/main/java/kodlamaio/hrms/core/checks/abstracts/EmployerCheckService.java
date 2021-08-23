package kodlamaio.hrms.core.checks.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerCheckService {

	Result check(Employer employer);
}
