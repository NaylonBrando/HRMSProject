package kodlamaio.hrms.business.concrates;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.ErrorResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.core.ultilities.results.SuccessDataResult;
import kodlamaio.hrms.core.ultilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concrates.JobPosition;

@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(jobTitleDao.findAll());
	}

	@Override
	public Result add(JobPosition jobTitle) {
		
		if(jobTitleDao.getByName(jobTitle.getName())!=null) {
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
	public DataResult<JobPosition> getByName(String name) {
		return new SuccessDataResult<JobPosition>(jobTitleDao.getByName(name));
	}

}
