package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.entities.concrates.Employer;

public interface EmployerService {

	Result add(Employer employer);

	Result delete(Employer jobSeeker);

	Result update(Employer employer);

	DataResult<List<Employer>> getAll();

	DataResult<Optional<Employer>> getById(int id);

}
