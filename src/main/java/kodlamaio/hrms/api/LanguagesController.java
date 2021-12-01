package kodlamaio.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.business.abtracts.BaseController;
import kodlamaio.hrms.entities.concrates.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController extends BaseController<LanguageService, Language, Integer> {

	@Autowired
	public LanguagesController(final LanguageService languageService) {
		super(languageService);
	}
}