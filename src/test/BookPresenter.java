package test;

import java.util.ArrayList;
import java.util.List;

class BookPresenter {

    private CallBack callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    void getBookInfo(int responseCode) {
        if (responseCode == 200) {
            List<BookModel> bookModelList = new ArrayList();
            BookModel bookModel = new BookModel();
            bookModel.setBookId("001");
            bookModel.setBookName("高等数学");
            bookModelList.add(bookModel);

            BookModel bookModel1 = new BookModel();
            bookModel1.setBookId("002");
            bookModel1.setBookName("大学物理");
            bookModelList.add(bookModel1);

            callBack.onSuccess(bookModelList);
        } else {
            callBack.onFail("获取图书信息失败", "https://www.cnblogs.com/kangxu/p/6260755.html");
        }
    }
}