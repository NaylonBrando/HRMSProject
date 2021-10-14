package kodlamaio.hrms.core.ultilities.results;

public class DataResult<T> extends Result {

	private T data;

	public DataResult(T data, boolean success, String message) {
		super(success, message);// super, base sınıfın ctorlarini yariyor
		this.data = data;
	}

	public DataResult(T data, boolean success) {
		super(success);// super, base sınıfın ctorlarini yariyor
		this.data = data;
	}

	public T getData() {
		return this.data;
	}

}
