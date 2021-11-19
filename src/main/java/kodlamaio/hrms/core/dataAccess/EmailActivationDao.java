package kodlamaio.hrms.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.entities.concrate.EmailActivation;

public interface EmailActivationDao extends JpaRepository<EmailActivation, Integer> {
	EmailActivation getByEmailAndActivationCode(String email, String activationCode);
}
