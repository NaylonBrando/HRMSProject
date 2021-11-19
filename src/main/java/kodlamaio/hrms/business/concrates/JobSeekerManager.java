package kodlamaio.hrms.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.adapters.abtracts.TurkishCitizenIdenityCheckService;
import kodlamaio.hrms.core.adapters.concrates.MernisServiceAdapter;
import kodlamaio.hrms.core.business.BusinessRules;
import kodlamaio.hrms.core.business.abtracts.EmailActivationService;
import kodlamaio.hrms.core.dtos.EmailActivationForVerifyDto;
import kodlamaio.hrms.core.entities.concrate.TurkishCitizen;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.ErrorResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.core.ultilities.results.SuccessDataResult;
import kodlamaio.hrms.core.ultilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concrates.JobSeeker;
import kodlamaio.hrms.entities.concrates.dtos.JobSeekerRegisterDto;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private TurkishCitizenIdenityCheckService turkishCitizenIdenityCheckService;
	private EmailActivationService emailActivationService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,
			TurkishCitizenIdenityCheckService turkishCitizenIdenityCheckService,
			EmailActivationService emailActivationService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.turkishCitizenIdenityCheckService = turkishCitizenIdenityCheckService;
		this.emailActivationService = emailActivationService;

	}

	@Override
	public Result add(JobSeekerRegisterDto jobSeekerRegisterDto) {

		TurkishCitizen turkishCitizen = new TurkishCitizen();
		turkishCitizen.setFirstName(jobSeekerRegisterDto.getFirstName());
		turkishCitizen.setLastName(jobSeekerRegisterDto.getLastName());
		turkishCitizen.setDateOfBirth(jobSeekerRegisterDto.getBirthDate().getYear());
		turkishCitizen.setNationalityId(jobSeekerRegisterDto.getIdentificationNumber());

		Result result = BusinessRules.Run(
				passwordAndPassowrdRepeatCompare(jobSeekerRegisterDto.getPassword(),
						jobSeekerRegisterDto.getRepeatPassword()),
				checkIfEmailAdressExits(jobSeekerRegisterDto.getEmail()),
				checkIfİdenityNumberExits(jobSeekerRegisterDto.getIdentificationNumber()),
				checkRealPerson(turkishCitizen));

		if (!result.isSuccess()) {
			return result;
		}

		JobSeeker jobSeeker = new JobSeeker();
		jobSeeker.setFirstName(jobSeekerRegisterDto.getFirstName());
		jobSeeker.setLastName(jobSeekerRegisterDto.getLastName());
		jobSeeker.setIdentificationNumber(jobSeekerRegisterDto.getIdentificationNumber());
		jobSeeker.setEmail(jobSeekerRegisterDto.getEmail());
		jobSeeker.setBirthDate(jobSeekerRegisterDto.getBirthDate());
		jobSeeker.setPassword(jobSeekerRegisterDto.getPassword());
		jobSeeker.setActivated(false);

		jobSeekerDao.save(jobSeeker);
		// UserId, jobseeker vt'ye kaydedildikten sonra geliyor ilginc sekilde :)
		emailActivationService.createAndSendActivationCodeByMail(jobSeeker);
		return new SuccessResult("İş arayan hesabı olusturuldu. Epostanıza gelen doğrulama kodunu onaylayınız.");
	}

	@Override
	public Result deleteById(int id) {
		if (jobSeekerDao.getById(id) == null) {
			return new ErrorResult("Böyle bir is arayan bulunamadi.");
		}
		jobSeekerDao.deleteById(id);
		return new SuccessResult("Basariyla silindi.");
	}

	@Override
	public Result update(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		return null;
	}

	public Result verifyAccount(EmailActivationForVerifyDto emailActivationForVerifyDto) {
		Result result = emailActivationService.verify(emailActivationForVerifyDto);
		if (result.isSuccess() == true) {
			JobSeeker jobSeeker = jobSeekerDao.getByEmail(emailActivationForVerifyDto.getEmail());
			jobSeeker.setActivated(true);
			jobSeekerDao.save(jobSeeker);

			return result;
		}
		return result;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll());
	}

	@Override
	public DataResult<JobSeeker> getById(int id) {
		return new SuccessDataResult<JobSeeker>(jobSeekerDao.getById(id));
	}

	@Override
	public DataResult<JobSeeker> getByIdentificationNumber(String idenifacationNumber) {
		return new SuccessDataResult<JobSeeker>(jobSeekerDao.getByIdentificationNumber(idenifacationNumber));
	}

	@Override
	public DataResult<JobSeeker> getByEmail(String email) {
		return new SuccessDataResult<JobSeeker>(jobSeekerDao.getByEmail(email));
	}

	private Result passwordAndPassowrdRepeatCompare(String password, String passwordRepeat) {

		if (password.equals(passwordRepeat) == false) {

			return new ErrorResult("Sifreler uyusmadi.");

		} else {
			return new SuccessResult();
		}

	}

	private Result checkIfEmailAdressExits(String email) {

		if (jobSeekerDao.getByEmail(email) != null) {

			return new ErrorResult("Bu e-posta adresi siteye zaten kayıtli.");

		} else {
			return new SuccessResult();
		}

	}

	private Result checkIfİdenityNumberExits(String idenityNumber) {

		if (jobSeekerDao.getByIdentificationNumber(idenityNumber) != null) {

			return new ErrorResult("Bu kimlik numarası siteye zaten kayitli.");

		} else {
			return new SuccessResult();
		}

	}

	private Result checkRealPerson(TurkishCitizen turkishCitizen) {

		return turkishCitizenIdenityCheckService.checkCitizenIdenityInformation(turkishCitizen);

	}

}

// fake static mernis verication service
