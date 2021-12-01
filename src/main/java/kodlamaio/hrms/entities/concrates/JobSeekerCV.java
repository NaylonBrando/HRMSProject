package kodlamaio.hrms.entities.concrates;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "job_seeker_cvs")
public class JobSeekerCV {
	@NotNull
	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	private final LocalDateTime createdAt = LocalDateTime.now();
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@JoinColumn(name = "job_seeker_id")
	@OneToOne
	private JobSeeker jobSeeker;

	@Length(max = 300)
	@Column(name = "cover_letter")
	private String coverLetter;

	@JsonIgnore
	@OneToMany(mappedBy = "jobSeekerCV")
	private List<JobSeekerCVImage> images;

	@JsonIgnore
	@OneToMany(mappedBy = "jobSeekerCV")
	private List<JobSeekerCVWebSite> webSites;

	@JsonIgnore
	@OneToMany(mappedBy = "jobSeekerCV")
	private List<JobSeekerCVEducation> educations;

	@JsonIgnore
	@OneToMany(mappedBy = "jobSeekerCV")
	private List<JobSeekerCVExperience> experiences;

	@JsonIgnore
	@OneToMany(mappedBy = "jobSeekerCV")
	private List<JobSeekerCVSkill> skills;

	@JsonIgnore
	@OneToMany(mappedBy = "jobSeekerCV")
	private List<JobSeekerCVLanguage> languages;
}
