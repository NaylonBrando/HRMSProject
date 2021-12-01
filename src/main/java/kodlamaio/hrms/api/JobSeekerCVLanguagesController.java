package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerCVLanguageService;
import kodlamaio.hrms.core.business.abtracts.BaseController;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.entities.concrates.JobSeekerCVLanguage;

@RestController
@RequestMapping("/api/jobseekers/cvs/languages")
public class JobSeekerCVLanguagesController
		extends BaseController<JobSeekerCVLanguageService, JobSeekerCVLanguage, Integer> {
	private final JobSeekerCVLanguageService jobSeekerCVLanguageService;

	@Autowired
	public JobSeekerCVLanguagesController(final JobSeekerCVLanguageService jobSeekerCVLanguageService) {
		super(jobSeekerCVLanguageService);
		this.jobSeekerCVLanguageService = jobSeekerCVLanguageService;
	}

	@GetMapping("/byjobseekercvid")
	public ResponseEntity<DataResult<List<JobSeekerCVLanguage>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<JobSeekerCVLanguage>> result = jobSeekerCVLanguageService
				.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}

}