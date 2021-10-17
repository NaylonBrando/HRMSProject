package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.entities.concrates.JobAdvertisement;

public interface JobAdvertisementService {

	Result add(JobAdvertisement jobAdvertisement);

	Result delete(int id);

	Result update(JobAdvertisement jobAdvertisement);
	
	Result setToActiveTrue(int id);
	
	Result setToActiveFalse(int id);

	DataResult<List<JobAdvertisement>> getAll();

	DataResult<JobAdvertisement> getById(int id);

	DataResult<List<JobAdvertisement>> getAllByIsActiveTrue();
	
	DataResult<List<JobAdvertisement>> getAllByIsActiveTrueDESC();
	
	DataResult<List<JobAdvertisement>> getAllByIsActiveTrueASC();

	DataResult<List<JobAdvertisement>> getByEmployerByIsActiveTrue(int employerId);

	DataResult<List<JobAdvertisement>> getByEmployerByIsActiveTrueDESC(int employerId);
	
	DataResult<List<JobAdvertisement>> getByEmployerByIsActiveTrueASC(int employerId);
	
	

}
