package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.dtos.EmailActivationForVerifyDto;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.entities.concrates.JobSeeker;
import kodlamaio.hrms.entities.concrates.dtos.JobSeekerRegisterDto;

public interface JobSeekerService {

	Result add(JobSeekerRegisterDto jobSeekerRegisterDto);

	Result deleteById(int id);

	Result update(JobSeeker jobSeeker);

	Result verifyAccount(EmailActivationForVerifyDto emailActivationForVerifyDto);

	DataResult<List<JobSeeker>> getAll();

	DataResult<JobSeeker> getById(int id);

	DataResult<JobSeeker> getByIdentificationNumber(String idenifacationNumber);

	DataResult<JobSeeker> getByEmail(String email);

}
