package test;

public interface CallBack {

    <T> void onSuccess(T entity);

    void onFail(String errorInfo, String url);
}
