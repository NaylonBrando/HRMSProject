package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.entities.concrates.JobPosition;

public interface JobTitleService {

	Result add(JobPosition jobTitle);

	Result delete(int id);

	Result update(JobPosition jobTitle);

	DataResult<List<JobPosition>> getAll();

	DataResult<Optional<JobPosition>> getById(int id);
	
	DataResult<JobPosition> getByName(String name);

}
