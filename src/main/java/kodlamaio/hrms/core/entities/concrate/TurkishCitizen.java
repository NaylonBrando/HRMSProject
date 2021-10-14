package kodlamaio.hrms.core.entities.concrate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurkishCitizen {

	private int id;
	private String firstName;
	private String lastName;
	private int dateOfBirth;
	private String nationalityId;

}
