package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerCVWebSiteService;
import kodlamaio.hrms.core.business.abtracts.BaseController;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.entities.concrates.JobSeekerCVWebSite;

@RestController
@RequestMapping("/api/jobseekers/cvs/websites")
public class JobSeekerCVWebSitesController
		extends BaseController<JobSeekerCVWebSiteService, JobSeekerCVWebSite, Integer> {
	private final JobSeekerCVWebSiteService jobSeekerCVWebSiteService;

	@Autowired
	public JobSeekerCVWebSitesController(final JobSeekerCVWebSiteService jobSeekerCVWebSiteService) {
		super(jobSeekerCVWebSiteService);
		this.jobSeekerCVWebSiteService = jobSeekerCVWebSiteService;
	}

	@GetMapping("/byjobseekercvid")
	public ResponseEntity<DataResult<List<JobSeekerCVWebSite>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<JobSeekerCVWebSite>> result = jobSeekerCVWebSiteService
				.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}
}