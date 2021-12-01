package kodlamaio.hrms.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerCVWebSiteService;
import kodlamaio.hrms.core.business.abtracts.BaseManager;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCVWebSiteDao;
import kodlamaio.hrms.entities.concrates.JobSeekerCVWebSite;

@Service
public class JobSeekerCVWebSiteManager extends BaseManager<JobSeekerCVWebSiteDao, JobSeekerCVWebSite, Integer>
		implements JobSeekerCVWebSiteService {
	private final JobSeekerCVWebSiteDao jobSeekerCVWebSiteDao;

	@Autowired
	public JobSeekerCVWebSiteManager(final JobSeekerCVWebSiteDao jobSeekerCVWebSiteDao) {
		super(jobSeekerCVWebSiteDao, "Job seeker CV website");
		this.jobSeekerCVWebSiteDao = jobSeekerCVWebSiteDao;
	}

	@Override
	public DataResult<List<JobSeekerCVWebSite>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<JobSeekerCVWebSite> jobSeekerCVWebSites = jobSeekerCVWebSiteDao
				.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerCVWebSites);
	}

}
