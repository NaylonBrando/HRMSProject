package kodlamaio.hrms.business.concrates;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.ErrorResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.core.ultilities.results.SuccessDataResult;
import kodlamaio.hrms.core.ultilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concrates.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobTitleDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(jobTitleDao.findAll());
	}

	@Override
	public Result add(JobPosition jobTitle) {
		
		if(jobTitleDao.getByPositionName(jobTitle.getPositionName())!=null) {
			return new ErrorResult("Böyle bir is pozisyonu zaten var.");
		}
		
		jobTitleDao.save(jobTitle);
		return new SuccessResult("İs pozisyonu eklendi.");
	}

	@Override
	public Result delete(int id) {
		jobTitleDao.deleteById(id);
		return new SuccessResult("İs pozisyonu silindi.");
	}

	@Override
	public DataResult<Optional<JobPosition>> getById(int id) {
		return new SuccessDataResult<Optional<JobPosition>>(jobTitleDao.findById(id));
	}

	@Override
	public Result update(JobPosition jobTitle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<JobPosition> getByPositionName(String name) {
		return new SuccessDataResult<JobPosition>(jobTitleDao.getByPositionName(name));
	}

}
