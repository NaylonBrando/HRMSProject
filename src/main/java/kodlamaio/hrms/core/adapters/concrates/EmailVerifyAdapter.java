package kodlamaio.hrms.core.adapters.concrates;

import kodlamaio.hrms.core.adapters.abtracts.EmailVerifyService;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.core.ultilities.results.SuccessResult;

public class EmailVerifyAdapter implements EmailVerifyService {

	@Override
	public Result Verify(String verifyCode) {
		return new SuccessResult();
	}

}
