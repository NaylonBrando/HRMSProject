package kodlamaio.hrms.entities.concrates;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers")
public class Employer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "company_website")
	private String companyWebsite;

	@Column(name = "company_email")
	private String companyEmail;

	@Column(name = "telephone_number")
	private String telephoneNumber;

	@Column(name = "tax_number")
	private String taxNumber;

}