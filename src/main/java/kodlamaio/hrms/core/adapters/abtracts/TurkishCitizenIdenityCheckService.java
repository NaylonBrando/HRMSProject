package kodlamaio.hrms.core.adapters.abtracts;

import kodlamaio.hrms.core.entities.concrate.TurkishCitizen;
import kodlamaio.hrms.core.ultilities.results.Result;

public interface TurkishCitizenIdenityCheckService {

	Result checkCitizenIdenityInformation(TurkishCitizen turkishCitizen);
}
