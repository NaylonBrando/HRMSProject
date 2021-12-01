package kodlamaio.hrms.business.concrates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerCVService;
import kodlamaio.hrms.core.business.abtracts.BaseManager;
import kodlamaio.hrms.core.business.constants.Messages;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.ErrorDataResult;
import kodlamaio.hrms.core.ultilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCVDao;
import kodlamaio.hrms.entities.concrates.JobSeekerCV;
import java.util.Optional;

@Service
public class JobSeekerCVManager extends BaseManager<JobSeekerCVDao, JobSeekerCV, Integer>
		implements JobSeekerCVService {
	private final JobSeekerCVDao jobSeekerCVDao;

	@Autowired
	public JobSeekerCVManager(final JobSeekerCVDao jobSeekerCVDao) {
		super(jobSeekerCVDao, "Job seeker CV");
		this.jobSeekerCVDao = jobSeekerCVDao;
	}

	@Override
	public DataResult<JobSeekerCV> getByJobSeeker_Id(final int jobSeekerId) {
		final Optional<JobSeekerCV> jobSeekerCV = jobSeekerCVDao.findByJobSeeker_Id(jobSeekerId);

		if (jobSeekerCV.isEmpty())
			return new ErrorDataResult<>(Messages.notFound("Job seeker"));

		return new SuccessDataResult<>(jobSeekerCV.get());
	}

}
