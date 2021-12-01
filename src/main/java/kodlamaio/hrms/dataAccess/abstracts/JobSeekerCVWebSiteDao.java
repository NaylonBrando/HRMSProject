package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concrates.JobSeekerCVWebSite;

public interface JobSeekerCVWebSiteDao extends JpaRepository<JobSeekerCVWebSite, Integer> {
	List<JobSeekerCVWebSite> findAllByJobSeekerCV_Id(int jobSeekerCVId);
}