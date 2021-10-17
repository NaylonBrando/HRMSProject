package kodlamaio.hrms.business.concrates;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.ErrorResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.core.ultilities.results.SuccessDataResult;
import kodlamaio.hrms.core.ultilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concrates.JobAdvertisement;
import kodlamaio.hrms.entities.concrates.JobPosition;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İlan olusturuldu");
	}

	@Override
	public Result delete(int id) {
		this.jobAdvertisementDao.deleteById(id);
		return new SuccessResult("İlanı silindi");
	}

	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İlanı güncellendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll());
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		return new SuccessDataResult<JobAdvertisement>(jobAdvertisementDao.getById(id));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getAllByIsActiveTrue());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActiveTrueDESC() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getAllByIsActiveTrueDESC());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActiveTrueASC() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getAllByIsActiveTrueASC());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployerByIsActiveTrue(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				jobAdvertisementDao.getByEmployerByIsActiveTrue(employerId));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployerByIsActiveTrueDESC(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				jobAdvertisementDao.getByEmployerByIsActiveTrueDESC(employerId));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployerByIsActiveTrueASC(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				jobAdvertisementDao.getByEmployerByIsActiveTrueASC(employerId));
	}

	@Override
	public Result setToActiveTrue(int id) {
		if (getById(id) == null) {
			return new ErrorResult("Böyle bir iş ilanı bulunmamaktadır");
		}
		if (getById(id).getData().isActive() == true) {
			return new ErrorResult("İş ilanı zaten açık");
		}

		JobAdvertisement jobAdvertisement = getById(id).getData();
		jobAdvertisement.setActive(true);
		update(jobAdvertisement);
		return new SuccessResult("İş ilanı başarılı bir şekilde açıldı");
	}

	@Override
	public Result setToActiveFalse(int id) {
		if (getById(id) == null) {
			return new ErrorResult("Böyle bir iş ilanı bulunmamaktadır");
		}
		if (getById(id).getData().isActive() == false) {
			return new ErrorResult("İş ilanı zaten kapalı");
		}

		JobAdvertisement jobAdvertisement = getById(id).getData();
		jobAdvertisement.setActive(false);
		update(jobAdvertisement);
		return new SuccessResult("İş ilanı başarılı bir şekilde kapatıldı");
	}



}
