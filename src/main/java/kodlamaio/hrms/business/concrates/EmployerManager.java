package kodlamaio.hrms.business.concrates;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.business.BusinessRules;
import kodlamaio.hrms.core.business.abtracts.EmailActivationService;
import kodlamaio.hrms.core.dtos.EmailActivationForVerifyDto;
import kodlamaio.hrms.core.ultilities.StringExtensions;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.ErrorResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.core.ultilities.results.SuccessDataResult;
import kodlamaio.hrms.core.ultilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concrates.Employer;
import kodlamaio.hrms.entities.concrates.JobSeeker;
import kodlamaio.hrms.entities.concrates.dtos.EmployerUserRegisterDto;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmailActivationService emailActivationService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailActivationService emailActivationService) {
		super();
		this.employerDao = employerDao;
		this.emailActivationService = emailActivationService;
	}

	@Override
	public Result add(EmployerUserRegisterDto employerUserRegisterDto) {

		Result result = BusinessRules.Run(
				compareEmailAndWebsite(employerUserRegisterDto.getCompanyWebsite(),
						employerUserRegisterDto.getCompanyEmail()),
				checkIfCompanyEmailAdressExits(employerUserRegisterDto.getCompanyEmail()),
				checkIfTaxNumberExits(employerUserRegisterDto.getTaxNumber()));

		if (!result.isSuccess()) {
			return result;
		}
		Employer employer = new Employer();
		employer.setCompanyName(employerUserRegisterDto.getCompanyName());
		employer.setCompanyWebsite(employerUserRegisterDto.getCompanyWebsite());
		employer.setEmail(employerUserRegisterDto.getCompanyEmail());
		employer.setTaxNumber(employerUserRegisterDto.getTaxNumber());
		employer.setTelephoneNumber(employerUserRegisterDto.getTelephoneNumber());
		employer.setPassword(employerUserRegisterDto.getPassword());
		employer.setActivated(false);

		employerDao.save(employer);

		emailActivationService.createAndSendActivationCodeByMail(employer);

		return new SuccessResult("İş veren hesabı oluşturuldu. Epostanıza gelen doğrulama kodunu onaylayınız.");
	}

	@Override
	public Result verifyAccount(EmailActivationForVerifyDto emailActivationForVerifyDto) {
		Result result = emailActivationService.verify(emailActivationForVerifyDto);
		if (result.isSuccess() == true) {
			Employer employer = employerDao.getByEmail(emailActivationForVerifyDto.getEmail());
			employer.setActivated(true);
			employerDao.save(employer);

			return result;
		}
		return result;
	}

	@Override
	public Result delete(Employer jobSeeker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(Employer employer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll());
	}

	@Override
	public DataResult<Optional<Employer>> getById(int id) {
		return new SuccessDataResult<Optional<Employer>>(employerDao.findById(id));
	}

	private Result checkIfTaxNumberExits(String idenityNumber) {

		if (employerDao.getByTaxNumber(idenityNumber) != null) {

			return new ErrorResult("Bu vergi numarasi siteye zaten kayitli.");

		} else {
			return new SuccessResult();
		}

	}

	private Result checkIfCompanyEmailAdressExits(String email) {

		if (employerDao.getByEmail(email) != null) {

			return new ErrorResult("Bu e-posta adresi siteye zaten kayıtli.");

		} else {
			return new SuccessResult();
		}

	}

	private Result compareEmailAndWebsite(String companyWebsite, String companyEmail) {
		// password.equals(passwordAgain)

		String email = companyEmail.substring(companyEmail.indexOf('@') + 1);
		String website = companyWebsite.substring(4);
		if (!email.contains(website)) {
			return new ErrorResult("Şirketin mail ve eposta adresi uyumsuz.");
		} else {
			return new SuccessResult();
		}
	}

	private Result checkEmployerFieldsIsNullOrEmpty(Employer employer) {
		if (StringExtensions.isNullOrEmpty(employer.getEmail(), employer.getCompanyName(), employer.getCompanyWebsite(),
				employer.getTaxNumber(), String.valueOf(employer.getTelephoneNumber()))) {
			return new ErrorResult("Bazı alan veya alanlar boş.");

		} else {
			return new SuccessResult();
		}

	}

}
