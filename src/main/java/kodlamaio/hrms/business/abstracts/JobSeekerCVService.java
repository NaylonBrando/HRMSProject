package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.business.abtracts.BaseService;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.entities.concrates.JobSeekerCV;

public interface JobSeekerCVService extends BaseService<JobSeekerCV, Integer> {
	DataResult<JobSeekerCV> getByJobSeeker_Id(int jobSeekerId);
}
