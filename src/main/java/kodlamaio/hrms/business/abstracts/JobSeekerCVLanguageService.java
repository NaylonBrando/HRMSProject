package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.business.abtracts.BaseService;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.entities.concrates.JobSeekerCVLanguage;

public interface JobSeekerCVLanguageService extends BaseService<JobSeekerCVLanguage, Integer> {
	DataResult<List<JobSeekerCVLanguage>> getAllByJobSeekerCV_Id(int jobSeekerCVId);
}
