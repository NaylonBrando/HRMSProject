package kodlamaio.hrms.business.concrates;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.adapters.FakeMernisServiceAdapter;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.business.BusinessRules;
import kodlamaio.hrms.core.ultilities.StringExtensions;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.ErrorResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.core.ultilities.results.SuccessDataResult;
import kodlamaio.hrms.core.ultilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concrates.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	JobSeekerDao jobSeekerDao;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {

		// Bunu BusinessRules'a refactor et

		Result result = BusinessRules.Run(checkJobSeekerFieldsIsNullOrEmpty(jobSeeker),
				checkIfEmailAdressExits(jobSeeker.getEmail()),
				checkIfİdenityNumberExits(jobSeeker.getIdentificationNumber()), checkRealPerson(jobSeeker));

		if (!result.isSuccess()) {
			return result;
		}
		jobSeekerDao.save(jobSeeker);
		return new SuccessResult("İş arayan hesabı olusturuldu.");
	}

	@Override
	public Result delete(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll());
	}

	@Override
	public DataResult<Optional<JobSeeker>> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Result checkIfEmailAdressExits(String email) {

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

	private Result checkRealPerson(JobSeeker jobseeker) {

		FakeMernisServiceAdapter fakeServiceAdapter = new FakeMernisServiceAdapter();

		if (!fakeServiceAdapter.checkRealPerson(jobseeker)) {
			return new ErrorResult("Kimlik bilgileri hatalı");
		}

		return new SuccessResult();

	}

	private Result checkJobSeekerFieldsIsNullOrEmpty(JobSeeker jobseeker) {
		if (StringExtensions.isNullOrEmpty(jobseeker.getEmail(), jobseeker.getFirstName(), jobseeker.getLastName(),
				jobseeker.getIdentificationNumber(), 
				String.valueOf(jobseeker.getBirthDate().getYear()))) {
			return new ErrorResult("Bazı alan veya alanlar boş.");

		}
		else {
			return new SuccessResult();
		}

	}

}

// fake static mernis verication service
