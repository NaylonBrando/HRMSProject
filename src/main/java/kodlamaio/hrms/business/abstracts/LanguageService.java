package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.business.abtracts.BaseService;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.entities.concrates.Language;

public interface LanguageService extends BaseService<Language, Integer> {

	DataResult<Language> getByName(String name);

}
