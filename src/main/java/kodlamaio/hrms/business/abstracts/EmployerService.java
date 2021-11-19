package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.dtos.EmailActivationForVerifyDto;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.entities.concrates.Employer;
import kodlamaio.hrms.entities.concrates.dtos.EmployerUserRegisterDto;

public interface EmployerService {

	Result add(EmployerUserRegisterDto employerUserRegisterDto);

	Result delete(Employer jobSeeker);

	Result update(Employer employer);

	Result verifyAccount(EmailActivationForVerifyDto emailActivationForVerifyDto);

	DataResult<List<Employer>> getAll();

	DataResult<Optional<Employer>> getById(int id);

}
