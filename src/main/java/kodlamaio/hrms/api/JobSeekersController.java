package kodlamaio.hrms.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.dtos.EmailActivationForVerifyDto;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.ErrorDataResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.entities.concrates.JobSeeker;
import kodlamaio.hrms.entities.concrates.dtos.JobSeekerRegisterDto;

@RestController
@RequestMapping("api/jobseekers")
public class JobSeekersController {

	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}

	@PostMapping("/register")
	public ResponseEntity<?> add(@Valid @RequestBody JobSeekerRegisterDto jobSeekerUserRegisterDto) {
		return ResponseEntity.ok(this.jobSeekerService.add(jobSeekerUserRegisterDto));
	}

	@PostMapping("/verifyAccount")
	public ResponseEntity<?> verifyAccount(@Valid @RequestBody EmailActivationForVerifyDto emailActivationForVerifyDto) {
		return ResponseEntity.ok(this.jobSeekerService.verifyAccount(emailActivationForVerifyDto));
	}

	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll() {

		return jobSeekerService.getAll();
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {

		Map<String, String> validationErrors = new HashMap<String, String>();

		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors);

		return errors;
	}

}
