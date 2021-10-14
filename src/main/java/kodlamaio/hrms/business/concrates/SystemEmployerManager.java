package kodlamaio.hrms.business.concrates;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemEmployeeService;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.SystemEmployeeDao;
import kodlamaio.hrms.entities.concrates.SystemEmployee;

@Service
public class SystemEmployerManager implements SystemEmployeeService {
	
	SystemEmployeeDao systemEmployeeDao;

	@Autowired
	public SystemEmployerManager(SystemEmployeeDao systemEmployeeDao) {
		super();
		this.systemEmployeeDao = systemEmployeeDao;
	}

	@Override
	public Result add(SystemEmployee systemEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(SystemEmployee systemEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(SystemEmployee systemEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<SystemEmployee>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<Optional<SystemEmployee>> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
