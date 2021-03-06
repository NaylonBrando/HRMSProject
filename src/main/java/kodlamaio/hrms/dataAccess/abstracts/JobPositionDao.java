package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concrates.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
	
	JobPosition getByPositionName(String name);

}
