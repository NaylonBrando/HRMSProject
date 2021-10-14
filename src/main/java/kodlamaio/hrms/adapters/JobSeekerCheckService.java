package kodlamaio.hrms.adapters;

import kodlamaio.hrms.entities.concrates.JobSeeker;

public interface JobSeekerCheckService {

	boolean checkRealPerson(JobSeeker jobSeeker);
}
