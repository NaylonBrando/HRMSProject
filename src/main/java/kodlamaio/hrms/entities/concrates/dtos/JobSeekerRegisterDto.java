package kodlamaio.hrms.entities.concrates.dtos;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerRegisterDto {

	@NotNull
	@NotBlank
	@Email
	private String email;

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
	@Size(max = 50)
	private String firstName;

	@NotNull
	@NotBlank
	@Size(max = 50)
	private String lastName;

	@NotNull
	@NotBlank
	@Size(min = 11, max = 11)
	private String identificationNumber;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;

}
