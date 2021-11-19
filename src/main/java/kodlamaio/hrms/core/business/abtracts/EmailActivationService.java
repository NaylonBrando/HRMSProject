package kodlamaio.hrms.core.business.abtracts;

import kodlamaio.hrms.core.dtos.EmailActivationForVerifyDto;
import kodlamaio.hrms.core.entities.concrate.User;
import kodlamaio.hrms.core.ultilities.results.Result;

public interface EmailActivationService {
	Result createAndSendActivationCodeByMail(User user);

	Result verify(EmailActivationForVerifyDto emailActivationForVerifyDto);
}
