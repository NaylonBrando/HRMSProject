package kodlamaio.hrms.core.adapters.abtracts;

import kodlamaio.hrms.core.ultilities.results.Result;

public interface EmailVerifyService {

	Result Verify(String verifyCode);
}
