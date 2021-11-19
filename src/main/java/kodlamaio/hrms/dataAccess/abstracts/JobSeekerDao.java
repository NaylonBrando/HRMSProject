package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concrates.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

	JobSeeker getByIdentificationNumber(String idenifacationNumber);
	
	JobSeeker getByEmail(String email);
	
	JobSeeker getById(int id);

}
