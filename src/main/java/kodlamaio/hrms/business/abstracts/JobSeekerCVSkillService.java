package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.business.abtracts.BaseService;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.entities.concrates.JobSeekerCVSkill;

public interface JobSeekerCVSkillService extends BaseService<JobSeekerCVSkill, Integer> {
	DataResult<List<JobSeekerCVSkill>> getAllByJobSeekerCV_Id(int jobSeekerCVId);
}
