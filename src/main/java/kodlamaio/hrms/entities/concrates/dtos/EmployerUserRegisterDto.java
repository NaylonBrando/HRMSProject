package kodlamaio.hrms.entities.concrates.dtos;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerUserRegisterDto {

	@NotNull
	@NotBlank
	@Size(max = 255)
	private String companyName;

	@NotNull
	@NotBlank
	@Email
	private String companyEmail;

	@NotNull
	@NotBlank
	@Size(max = 255)
	private String companyWebsite;

	@NotNull
	@NotBlank
	@Size(min = 6, max = 100)
	private String password;

	@NotNull
	@NotBlank
	@Size(min = 6, max = 100)
	private String repeatPassword;

	@NotNull
	@NotBlank
	@Size(max = 20)
	private String telephoneNumber;

	@NotNull
	@NotBlank
	@Size(min = 10, max = 10)
	private String taxNumber;

}
