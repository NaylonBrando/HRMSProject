package kodlamaio.hrms.core.business;

import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.core.ultilities.results.SuccessResult;

public class BusinessRules {

	public static Result Run(Result... rules) {
		for (Result rule : rules) {
			if (!rule.isSuccess())
				return rule;
		}
		
		return new SuccessResult();
	}

}
