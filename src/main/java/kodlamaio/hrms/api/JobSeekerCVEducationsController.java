package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerCVEducationService;
import kodlamaio.hrms.core.business.abtracts.BaseController;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.entities.concrates.JobSeekerCVEducation;

@RestController
@RequestMapping("/api/jobseekers/cvs/educations")
public class JobSeekerCVEducationsController
		extends BaseController<JobSeekerCVEducationService, JobSeekerCVEducation, Integer> {
	private final JobSeekerCVEducationService jobSeekerCVEducationService;

	@Autowired
	public JobSeekerCVEducationsController(final JobSeekerCVEducationService jobSeekerCVEducationService) {
		super(jobSeekerCVEducationService);
		this.jobSeekerCVEducationService = jobSeekerCVEducationService;
	}

	@GetMapping("/byjobseekercvid")
	public ResponseEntity<DataResult<List<JobSeekerCVEducation>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<JobSeekerCVEducation>> result = jobSeekerCVEducationService
				.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/byjobseekercvidorderbygraduationdate")
	public ResponseEntity<DataResult<List<JobSeekerCVEducation>>> getAllByJobSeekerCV_IdOrderByGraduationDate(
			@RequestParam final int jobSeekerCVId, @RequestParam final Direction direction) {
		final DataResult<List<JobSeekerCVEducation>> result = jobSeekerCVEducationService
				.getAllByJobSeekerCV_IdOrderByGraduationDate(jobSeekerCVId, direction);

		return ResponseEntity.ok(result);
	}
}