package kodlamaio.hrms.entities.concrates;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "system_employees")
public class SystemEmployee {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "first_name")
	private int firstName;

	@Column(name = "last_name")
	private int LastName;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@Column(name = "email")
	private String email;

}
