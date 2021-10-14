package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.entities.concrates.SystemEmployee;

public interface SystemEmployeeService {

	Result add(SystemEmployee systemEmployee);

	Result delete(SystemEmployee systemEmployee);

	Result update(SystemEmployee systemEmployee);

	DataResult<List<SystemEmployee>> getAll();

	DataResult<Optional<SystemEmployee>> getById(int id);

}
