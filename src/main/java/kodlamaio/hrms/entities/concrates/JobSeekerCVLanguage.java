package kodlamaio.hrms.entities.concrates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "job_seeker_cv_languages")
public class JobSeekerCVLanguage {
	//Not:nedense postgrede yıl-ay-gün biciminde
	@NotNull
	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	private final LocalDate createdAt = LocalDate.now();

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@JoinColumn(name = "job_seeker_cv_id")
	@ManyToOne
	private JobSeekerCV jobSeekerCV;

	@NotNull
	@JoinColumn(name = "language_id")
	@ManyToOne
	private Language language;

	@NotNull
	@Range(min = 1, max = 6)
	@Column(name = "level")
	private short level;
}