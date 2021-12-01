package kodlamaio.hrms.entities.concrates;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_postings")
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "advertisement_id")
	private int id;

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@ManyToOne()
	@JoinColumn(name = "job_id")
	private JobPosition jobPosition;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	//Not:
	//Swaggerda input olarak şu örnekteki formatta saat kullanin
	//       2000-10-31T01:30:00.000-05:00 -- yyyy-MM-dd'T'HH:mm:ss.SSSXXX
	//Not2: yeni format örn 2000-10-31T01:30:00 ama sorun cıkarir mi.
	//Kullanıma bakmak icin 
	//neyse biz eski formata dönmüsüm :D  yyyy-MM-dd
	//https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/format/annotation/DateTimeFormat.ISO.html
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "post_date", nullable = false)
	private LocalDate postDate;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "last_day", nullable = false)
	private LocalDate applicationDeadline;

	@Column(name = "free_positions")
	private int freePositions;
	
	@Column(name = "is_active")
	private boolean isActive;

}
