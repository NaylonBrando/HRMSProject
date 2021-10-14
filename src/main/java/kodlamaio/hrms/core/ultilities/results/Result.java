package kodlamaio.hrms.core.ultilities.results;
//Niye cıplak bıraktık? Java communitysi öyle, bunu interface gibi algiliyor
public class Result {

	private boolean success;
	private String message;

	public Result(boolean success) {
		this.success = success;
	}

	public Result(boolean success, String message) {
		this(success);//mevcut sadece boolean paramlı ctora successi yolla
		this.message = message;
	}
	
	public boolean isSuccess() {
		return this.success;
	}
	
	public String getMessage() {
		return this.message;
	}

}
