package kodlamaio.hrms.core.business.abtracts;

import kodlamaio.hrms.core.ultilities.results.Result;

public interface EmailService {
	Result send(String to, String title, String body);
}
