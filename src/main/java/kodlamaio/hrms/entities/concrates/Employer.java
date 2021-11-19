package kodlamaio.hrms.entities.concrates;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.core.entities.concrate.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdvertisements" })
@Table(name = "employers")
public class Employer extends User {

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "company_website")
	private String companyWebsite;

	@Column(name = "telephone_number")
	private String telephoneNumber;

	@Column(name = "tax_number")
	private String taxNumber;

	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;

}
