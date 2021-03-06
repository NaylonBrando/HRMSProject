package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concrates.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {
	Language getByName(String name);
}
