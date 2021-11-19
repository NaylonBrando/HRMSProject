package kodlamaio.hrms.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.entities.concrate.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User getByEmail(String email);
	
	User getById(int id);

}
