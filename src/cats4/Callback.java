package cats4;

public interface Callback<T> {
	
	void onResult(T result);
	
	void onError(Exception e);
	
}
