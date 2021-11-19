package kodlamaio.hrms.core.business.concrates;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.business.abtracts.EmailService;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.core.ultilities.results.SuccessResult;

@Service
public class EmailManager implements EmailService {

	@Override
	public Result send(String to, String title, String body) {
		return new SuccessResult("Aktivasyon kodu" + to + " adresine yollandi!");
	}

}
