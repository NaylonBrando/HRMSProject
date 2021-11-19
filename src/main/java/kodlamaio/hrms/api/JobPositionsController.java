package kodlamaio.hrms.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.entities.concrates.JobPosition;

@RestController
@RequestMapping("api/jobtitles")
public class JobPositionsController {

	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionsController(JobPositionService jobTitleService) {
		super();
		this.jobPositionService = jobTitleService;
	}

	@GetMapping("getall")
	public DataResult<List<JobPosition>> getAll() {
		return jobPositionService.getAll();
	}

	@GetMapping("/getbyid")
	public DataResult<Optional<JobPosition>> getById(@RequestParam int id) {
		return jobPositionService.getById(id);

	}

	@GetMapping("getbypositionname")
	public DataResult<JobPosition> getByPositionName(@RequestParam String name) {
		return jobPositionService.getByPositionName(name);

	}

	@PostMapping("/add")
	public Result add(@RequestBody JobPosition jobTitle) {
		return this.jobPositionService.add(jobTitle);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody int id) {
		return this.jobPositionService.delete(id);
	}

}
