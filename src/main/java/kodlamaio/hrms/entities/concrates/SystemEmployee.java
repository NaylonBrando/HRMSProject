package kodlamaio.hrms.entities.concrates;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlamaio.hrms.core.entities.concrate.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@Table(name = "system_employees")
public class SystemEmployee extends User {
//departman falan ekelnecek
	@Column(name = "first_name")
	private int firstName;

	@Column(name = "last_name")
	private int LastName;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@Column(name = "email")
	private String email;

}
