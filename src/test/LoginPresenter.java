package test;

public class LoginPresenter {

    private static CallBack callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    void login(int responseCode) {
        if (responseCode == 200) {
            UserModel userModel = new UserModel();
            userModel.setUserId("123456");
            userModel.setUserName("Jaty");
            callBack.onSuccess(userModel);
        } else {
            callBack.onFail("登陆失败", "https://hao.360.cn/");
        }
    }
}
