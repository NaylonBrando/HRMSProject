package kodlamaio.hrms.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerCVExperienceService;
import kodlamaio.hrms.core.business.abtracts.BaseManager;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCVExperienceDao;
import kodlamaio.hrms.entities.concrates.JobSeekerCVExperience;

@Service
public class JobSeekerCVExperienceManager extends BaseManager<JobSeekerCVExperienceDao, JobSeekerCVExperience, Integer>
		implements JobSeekerCVExperienceService {
	private final JobSeekerCVExperienceDao jobSeekerCVExperienceDao;

	@Autowired
	public JobSeekerCVExperienceManager(final JobSeekerCVExperienceDao jobSeekerCVExperienceDao) {
		super(jobSeekerCVExperienceDao, "Job seeker CV experience");
		this.jobSeekerCVExperienceDao = jobSeekerCVExperienceDao;
	}

	@Override
	public DataResult<List<JobSeekerCVExperience>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<JobSeekerCVExperience> jobSeekerCVExperiences = jobSeekerCVExperienceDao
				.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerCVExperiences);
	}

	@Override
	public DataResult<List<JobSeekerCVExperience>> getAllByJobSeekerCV_IdOrderByQuitDate(final int jobSeekerCVId,
			final Direction direction) {
		final List<JobSeekerCVExperience> jobSeekerEducations = direction.isAscending()
				? jobSeekerCVExperienceDao.findAllByJobSeekerCV_IdOrderByQuitDate(jobSeekerCVId)
				: jobSeekerCVExperienceDao.findAllByJobSeekerCV_IdOrderByQuitDateDesc(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerEducations);
	}

}