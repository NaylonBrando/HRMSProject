package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.business.abtracts.BaseService;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.entities.concrates.JobSeekerCVWebSite;

public interface JobSeekerCVWebSiteService extends BaseService<JobSeekerCVWebSite, Integer> {
	DataResult<List<JobSeekerCVWebSite>> getAllByJobSeekerCV_Id(int jobSeekerCVId);
}
