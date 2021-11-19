package kodlamaio.hrms.core.adapters.concrates;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abtracts.TurkishCitizenIdenityCheckService;
import kodlamaio.hrms.core.entities.concrate.TurkishCitizen;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.core.ultilities.results.SuccessResult;

@Service
public class MernisServiceAdapter implements TurkishCitizenIdenityCheckService {

	// KPSPublicSoapProxy bagimliligi var

	@Override
	public Result checkCitizenIdenityInformation(TurkishCitizen turkishCitizen) {
		return new SuccessResult();
	}
}
