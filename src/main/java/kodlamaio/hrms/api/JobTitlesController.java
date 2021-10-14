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

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.entities.concrates.JobPosition;

@RestController
@RequestMapping("api/jobtitles")
public class JobTitlesController {

	private JobTitleService jobTitleService;

	@Autowired
	public JobTitlesController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}

	@GetMapping("getall")
	public DataResult<List<JobPosition>> getAll() {
		var result = jobTitleService.getAll();

		if (result.isSuccess()) {
			return result;
		}

		else {
			return null;
		}

	}

	@GetMapping("getbyid/{id}")
	public DataResult<Optional<JobPosition>> getById(@PathVariable int id) {
		return jobTitleService.getById(id);

	}

	@GetMapping("getbyname")
	public DataResult<JobPosition> getByName(@RequestParam String name) {
		return jobTitleService.getByName(name);

	}

	@PostMapping("/add")
	public Result add(@RequestBody JobPosition jobTitle) {
		return this.jobTitleService.add(jobTitle);
	}

	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable int id) {
		return this.jobTitleService.delete(id);
	}

}
