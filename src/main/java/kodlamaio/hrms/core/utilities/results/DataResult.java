package kodlamaio.hrms.core.utilities.results;

public class DataResult<T> extends Result {
	T data;
	public DataResult(T data ,boolean success, String message) { //t data generic tip datayı set etme vs için
		super(success, message);
		this.data=data;
		// TODO Auto-generated constructor stub
	}
	public DataResult(T data ,boolean success) { //t data generic tip datayı set ediyoruz
		super(success);
		this.data=data;
		// TODO Auto-generated constructor stub
	}
	public T getData()
	{
		
		return this.data;
		
	}
}
