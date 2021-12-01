package kodlamaio.hrms.business.concrates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.business.abtracts.BaseManager;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concrates.Language;

@Service
public class LanguageManager extends BaseManager<LanguageDao, Language, Integer> implements LanguageService {

	private final LanguageDao languageDao;

	@Autowired
	public LanguageManager(final LanguageDao languageDao) {
		super(languageDao, "language");
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<Language> getByName(String name) {
		return new SuccessDataResult<Language>(languageDao.getByName(name));
	}

}
