package test;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class Main implements CallBack {


    public static void main(String[] args) {
        Main main = new Main();

        LoginPresenter loginPresenter = new LoginPresenter();
        loginPresenter.setCallBack(main);
        loginPresenter.login(200);

        BookPresenter bookPresenter = new BookPresenter();
        bookPresenter.setCallBack(main);
        bookPresenter.getBookInfo(200);

    }

    @Override
    public <T> void onSuccess(T entity) {
        if (entity instanceof UserModel) {
            UserModel userModel = (UserModel) entity;
            System.out.println("登陆");
            System.out.println("用户Id：" + userModel.getUserId());
            System.out.println("用户名称：" + userModel.getUserName());
        } else if (entity instanceof List) {
            if (((List) entity).get(0) instanceof BookModel) {
                List<BookModel> bookModels = (List<BookModel>) entity;
                System.out.println("======================================");
                System.out.println("获取图书信息");
                for (BookModel bookModel : bookModels) {
                    System.out.println("图书Id：" + bookModel.getBookId());
                    System.out.println("图书名称：" + bookModel.getBookName());
                }
                System.out.println("======================================");
            }
        }
    }


    @Override
    public void onFail(String errorInfo, String url) {
        System.out.println("错误信息：" + errorInfo);
        System.out.println("出错URL：" + url);
    }


}
