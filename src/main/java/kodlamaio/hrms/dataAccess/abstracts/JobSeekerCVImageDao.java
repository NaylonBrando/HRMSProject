package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concrates.JobSeekerCVImage;

public interface JobSeekerCVImageDao extends JpaRepository<JobSeekerCVImage, Integer> {
	List<JobSeekerCVImage> findAllByJobSeekerCV_Id(int jobSeekerCVId);
}
