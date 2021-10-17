package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concrates.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	@Query("From JobAdvertisement where isActive=true")
	List<JobAdvertisement> getAllByIsActiveTrue();
	
	@Query("From JobAdvertisement where isActive=true Order By postDate DESC")
	List<JobAdvertisement> getAllByIsActiveTrueDESC();
	
	@Query("From JobAdvertisement where isActive=true Order By postDate ASC")
	List<JobAdvertisement> getAllByIsActiveTrueASC();

	@Query("From JobAdvertisement where employer.id=:employerId and isActive=true")
	List<JobAdvertisement> getByEmployerByIsActiveTrue(int employerId);

	@Query("From JobAdvertisement where employer.id=:employerId and isActive=true Order By postDate DESC")
	List<JobAdvertisement> getByEmployerByIsActiveTrueDESC(int employerId);
	
	@Query("From JobAdvertisement where employer.id=:employerId and isActive=true Order By postDate DESC")
	List<JobAdvertisement> getByEmployerByIsActiveTrueASC(int employerId);

}
