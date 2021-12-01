package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.business.abtracts.BaseService;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.entities.concrates.JobSeekerCVImage;

public interface JobSeekerCVImageService extends BaseService<JobSeekerCVImage, Integer> {
	DataResult<List<JobSeekerCVImage>> getAllByJobSeekerCV_Id(int jobSeekerCVId);

	Result addAndSave(JobSeekerCVImage jobSeekerImage, MultipartFile file);
}
