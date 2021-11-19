package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.concrates.JobAdvertisementManager;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.entities.concrates.JobAdvertisement;

@RestController
@RequestMapping("api/jobAdvertisements")
public class JobAdvertisementsController {

	private JobAdvertisementManager jobAdvertisementManager;

	public JobAdvertisementsController(JobAdvertisementManager jobAdvertisementManager) {
		super();
		this.jobAdvertisementManager = jobAdvertisementManager;
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return jobAdvertisementManager.add(jobAdvertisement);
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return jobAdvertisementManager.delete(id);
	}

	@PostMapping("/setToActiveTrue")
	public Result setToActiveTrue(@RequestParam int id) {
		return jobAdvertisementManager.setToActiveTrue(id);
	}

	@PostMapping("/setToActiveFalse")
	public Result setToActiveFalse(@RequestParam int id) {
		return jobAdvertisementManager.setToActiveFalse(id);
	}

	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll() {

		return jobAdvertisementManager.getAll();
	}

	@GetMapping("/getAllByIsActiveTrue")
	public DataResult<List<JobAdvertisement>> getAllByIsActiveTrue() {

		return jobAdvertisementManager.getAllByIsActiveTrue();
	}

	@GetMapping("/getAllByIsActiveTrueDESC")
	public DataResult<List<JobAdvertisement>> getAllByIsActiveTrueDESC() {

		return jobAdvertisementManager.getAllByIsActiveTrueDESC();
	}

	@GetMapping("/getAllByIsActiveTrueASC")
	public DataResult<List<JobAdvertisement>> getAllByIsActiveTrueASC() {

		return jobAdvertisementManager.getAllByIsActiveTrueASC();
	}

	@GetMapping("/getByEmployerByIsActiveTrue")
	public DataResult<List<JobAdvertisement>> getByEmployerByIsActiveTrue(@RequestParam int employerId) {

		return jobAdvertisementManager.getByEmployerByIsActiveTrue(employerId);
	}

	@GetMapping("/getByEmployerByIsActiveTrueDESC")
	public DataResult<List<JobAdvertisement>> getByEmployerByIsActiveTrueDESC(@RequestParam int employerId) {

		return jobAdvertisementManager.getByEmployerByIsActiveTrueDESC(employerId);
	}

	@GetMapping("/getByEmployerByIsActiveTrueASC")
	public DataResult<List<JobAdvertisement>> getByEmployerByIsActiveTrueASC(@RequestParam int employerId) {

		return jobAdvertisementManager.getByEmployerByIsActiveTrueASC(employerId);
	}

}
