package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.entities.concrate.User;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.Result;

public interface UserService {

	Result add(User user);

	Result delete(User user);

	Result update(User user);

	DataResult<List<User>> getAll();

	DataResult<Optional<User>> getById(int id);

}
