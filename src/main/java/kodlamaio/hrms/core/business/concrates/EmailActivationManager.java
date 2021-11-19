package kodlamaio.hrms.core.business.concrates;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.business.abtracts.EmailActivationService;
import kodlamaio.hrms.core.business.abtracts.EmailService;
import kodlamaio.hrms.core.dataAccess.EmailActivationDao;
import kodlamaio.hrms.core.dtos.EmailActivationForVerifyDto;
import kodlamaio.hrms.core.entities.concrate.EmailActivation;
import kodlamaio.hrms.core.entities.concrate.User;
import kodlamaio.hrms.core.ultilities.results.ErrorResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.core.ultilities.results.SuccessResult;

@Service
public class EmailActivationManager implements EmailActivationService {

	private EmailActivationDao emailActivationDao;
	private EmailService emailService;

	@Autowired
	public EmailActivationManager(EmailActivationDao emailActivationDao, EmailService emailService) {
		super();
		this.emailActivationDao = emailActivationDao;
		this.emailService = emailService;
	}

	@Override
	public Result createAndSendActivationCodeByMail(User user) {

		EmailActivation emailActivation = new EmailActivation();
		emailActivation.setUser(user);
		emailActivation.setEmail(user.getEmail());
		emailActivation.setActivationCode("AktivasyonKoduTest"); // ToDo: Code Generator
		emailActivation.setExpirationDate(LocalDateTime.now().plusMinutes(10));

		emailActivationDao.save(emailActivation);
		System.out.println(emailActivation.getEmail());
		emailService.send(emailActivation.getEmail(), "Email aktivasyon kodu",
				"Aktivasyon kodunuz: " + emailActivation.getActivationCode());

		return new SuccessResult("Aktivasyon kodu olusturuldu ve gönderildi.");
	}

	@Override
	public Result verify(EmailActivationForVerifyDto emailActivationForVerifyDto) {
		EmailActivation result = emailActivationDao.getByEmailAndActivationCode(emailActivationForVerifyDto.getEmail(),
				emailActivationForVerifyDto.getActivationCode());
		if (result == null) {
			return new ErrorResult("Böyle bir e posta veya doğrulama kodu yok");
		} else if (result.isActivated() == true) {
			return new ErrorResult("Bu hesap zaten aktive edildi.");
		}
		result.setActivated(true);
		emailActivationDao.save(result);
		return new SuccessResult("Hesap aktive edildi.");
	}

}
