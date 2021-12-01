package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import kodlamaio.hrms.core.business.abtracts.BaseService;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.entities.concrates.JobSeekerCVExperience;

public interface JobSeekerCVExperienceService extends BaseService<JobSeekerCVExperience, Integer> {
	DataResult<List<JobSeekerCVExperience>> getAllByJobSeekerCV_Id(int jobSeekerCVId);

	DataResult<List<JobSeekerCVExperience>> getAllByJobSeekerCV_IdOrderByQuitDate(int jobSeekerCVId,
			Direction direction);
}
