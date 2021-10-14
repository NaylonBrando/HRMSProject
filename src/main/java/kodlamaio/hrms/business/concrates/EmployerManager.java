package kodlamaio.hrms.business.concrates;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.business.BusinessRules;
import kodlamaio.hrms.core.ultilities.StringExtensions;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.ErrorResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.core.ultilities.results.SuccessDataResult;
import kodlamaio.hrms.core.ultilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concrates.Employer;
import kodlamaio.hrms.entities.concrates.JobSeeker;

@Service
public class EmployerManager implements EmployerService {

	EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public Result add(Employer employer) {

		Result result = BusinessRules.Run(checkEmployerFieldsIsNullOrEmpty(employer),
				checkIfCompanyEmailAdressExits(employer.getCompanyEmail()),
				checkIfTaxNumberExits(employer.getTaxNumber()));

		if (!result.isSuccess()) {
			return result;
		}
		employerDao.save(employer);

		return new SuccessResult("İş veren hesabı oluşturuldu");
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

	private Result checkIfCompanyEmailAdressExits(String email) {

		if (employerDao.getByCompanyEmail(email) != null) {

			return new ErrorResult("Bu e-posta adresi siteye zaten kayıtli.");

		} else {
			return new SuccessResult();
		}

	}

	private Result checkEmployerFieldsIsNullOrEmpty(Employer employer) {
		if (StringExtensions.isNullOrEmpty(employer.getCompanyEmail(), employer.getCompanyName(),
				employer.getCompanyWebsite(), employer.getTaxNumber(), String.valueOf(employer.getTelephoneNumber()))) {
			return new ErrorResult("Bazı alan veya alanlar boş.");

		} else {
			return new SuccessResult();
		}

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

}
