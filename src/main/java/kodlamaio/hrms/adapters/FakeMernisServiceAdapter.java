package kodlamaio.hrms.adapters;

import kodlamaio.hrms.entities.concrates.JobSeeker;

public class FakeMernisServiceAdapter implements JobSeekerCheckService {

	@Override
	public boolean checkRealPerson(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		return true;
	}

}
