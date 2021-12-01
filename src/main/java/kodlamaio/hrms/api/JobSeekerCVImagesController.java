package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.JobSeekerCVImageService;
import kodlamaio.hrms.core.business.abtracts.BaseController;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.entities.concrates.JobSeekerCVImage;
import kodlamaio.hrms.entities.concrates.JobSeekerCV;

@RestController
@RequestMapping("/api/jobseekers/cvs/images")
public class JobSeekerCVImagesController extends BaseController<JobSeekerCVImageService, JobSeekerCVImage, Integer> {
	private final JobSeekerCVImageService jobSeekerCVImageService;

	@Autowired
	public JobSeekerCVImagesController(final JobSeekerCVImageService jobSeekerCVImageService) {
		super(jobSeekerCVImageService);
		this.jobSeekerCVImageService = jobSeekerCVImageService;
	}

	@PostMapping("/addandsave")
	public ResponseEntity<Result> addAndSave(@RequestParam final int jobSeekerCVId,
			@RequestBody final MultipartFile file) {
		final Result result = jobSeekerCVImageService.addAndSave(
				JobSeekerCVImage.builder().jobSeekerCV(JobSeekerCV.builder().id(jobSeekerCVId).build()).build(), file);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/byjobseekercvid")
	public ResponseEntity<DataResult<List<JobSeekerCVImage>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<JobSeekerCVImage>> result = jobSeekerCVImageService.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}
}