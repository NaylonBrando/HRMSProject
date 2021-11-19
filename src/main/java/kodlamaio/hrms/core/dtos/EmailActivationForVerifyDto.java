package kodlamaio.hrms.core.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailActivationForVerifyDto {
	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String activationCode;
}
