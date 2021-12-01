package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerCVExperienceService;
import kodlamaio.hrms.core.business.abtracts.BaseController;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.entities.concrates.JobSeekerCVExperience;

@RestController
@RequestMapping("/api/jobseekers/cvs/experiences")
public class JobSeekerCVExperiencesController
		extends BaseController<JobSeekerCVExperienceService, JobSeekerCVExperience, Integer> {
	private final JobSeekerCVExperienceService jobSeekerCVExperienceService;

	@Autowired
	public JobSeekerCVExperiencesController(final JobSeekerCVExperienceService jobSeekerCVExperienceService) {
		super(jobSeekerCVExperienceService);
		this.jobSeekerCVExperienceService = jobSeekerCVExperienceService;
	}

	@GetMapping("/byjobseekercvid")
	public ResponseEntity<DataResult<List<JobSeekerCVExperience>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<JobSeekerCVExperience>> result = jobSeekerCVExperienceService
				.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/byjobseekercvidorderbyquitdate")
	public ResponseEntity<DataResult<List<JobSeekerCVExperience>>> getAllByJobSeekerCV_IdOrderByQuitDate(
			@RequestParam final int jobSeekerCVId, @RequestParam final Direction direction) {
		final DataResult<List<JobSeekerCVExperience>> result = jobSeekerCVExperienceService
				.getAllByJobSeekerCV_IdOrderByQuitDate(jobSeekerCVId, direction);

		return ResponseEntity.ok(result);
	}

}
