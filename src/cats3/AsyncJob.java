package cats3;

public abstract class AsyncJob<T> {

	public abstract void start(Callback<T> callback);

}
