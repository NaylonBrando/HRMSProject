package kodlamaio.hrms.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerCVEducationService;
import kodlamaio.hrms.core.business.abtracts.BaseManager;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCVEducationDao;
import kodlamaio.hrms.entities.concrates.JobSeekerCVEducation;

@Service
public class JobSeekerCVEducationManager extends BaseManager<JobSeekerCVEducationDao, JobSeekerCVEducation, Integer>
		implements JobSeekerCVEducationService {
	private final JobSeekerCVEducationDao jobSeekerCVEducationDao;

	@Autowired
	public JobSeekerCVEducationManager(final JobSeekerCVEducationDao jobSeekerCVEducationDao) {
		super(jobSeekerCVEducationDao, "Job seeker CV education");
		this.jobSeekerCVEducationDao = jobSeekerCVEducationDao;
	}

	@Override
	public DataResult<List<JobSeekerCVEducation>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<JobSeekerCVEducation> jobSeekerCVEducations = jobSeekerCVEducationDao
				.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerCVEducations);
	}

	@Override
	public DataResult<List<JobSeekerCVEducation>> getAllByJobSeekerCV_IdOrderByGraduationDate(final int jobSeekerCVId,
			final Direction direction) {
		final List<JobSeekerCVEducation> jobSeekerCVEducations = direction.isAscending()
				? jobSeekerCVEducationDao.findAllByJobSeekerCV_IdOrderByGraduationDate(jobSeekerCVId)
				: jobSeekerCVEducationDao.findAllByJobSeekerCV_IdOrderByGraduationDateDesc(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerCVEducations);
	}

}
