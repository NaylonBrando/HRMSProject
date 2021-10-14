package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.entities.concrates.JobSeeker;

public interface JobSeekerService {

	Result add(JobSeeker jobSeeker);

	Result delete(JobSeeker jobSeeker);

	Result update(JobSeeker jobSeeker);

	DataResult<List<JobSeeker>> getAll();

	DataResult<Optional<JobSeeker>> getById(int id);

}
