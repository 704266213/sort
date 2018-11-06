package test;

public interface CallBackInterface<T> {


    void onSuccess(T entity);

    void onFail(String errorInfo);

}
