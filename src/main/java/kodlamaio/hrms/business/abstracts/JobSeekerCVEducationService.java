package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import kodlamaio.hrms.core.business.abtracts.BaseService;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.entities.concrates.JobSeekerCVEducation;

public interface JobSeekerCVEducationService extends BaseService<JobSeekerCVEducation, Integer> {
	DataResult<List<JobSeekerCVEducation>> getAllByJobSeekerCV_Id(int jobSeekerCVId);

	DataResult<List<JobSeekerCVEducation>> getAllByJobSeekerCV_IdOrderByGraduationDate(int jobSeekerCVId,
			Direction direction);

}
