public class Main {


    public static void main(String[] args) {
        int[] arrayData = {11, 18, 3, 70, 9, 14, 6, 17, 24};
        String result = printArray(arrayData);
        System.out.println("原始数据结果：" + result);
        bubbleSortTest();
        selectSortTest();
        insertSortTest();
    }

    private static void bubbleSortTest() {
        int[] arrayData = {11, 18, 3, 70, 9, 14, 6, 17, 24};
        BubbleSort bubbleSort = new BubbleSort();
        int[] newArray = bubbleSort.bubbleSort(arrayData);
        String result = printArray(newArray);
        System.out.println("冒泡排序结果：" + result);
    }

    private static void selectSortTest() {
        int[] arrayData = {11, 18, 3, 70, 9, 14, 6, 17, 24};
        SelectSort selectSort = new SelectSort();
        int[] newArray = selectSort.selectSort(arrayData);
        String result = printArray(newArray);
        System.out.println("选择排序结果：" + result);
    }

    private static void insertSortTest() {
        int[] arrayData = {11, 18, 3, 70, 9, 14, 6, 17, 24};
        InsertSort insertSort = new InsertSort();
        int[] newArray = insertSort.insertSort(arrayData);
        String result = printArray(newArray);
        System.out.println("插入排序结果：" + result);
    }


    public static String printArray(int[] arr) {
        int size = arr.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(arr[i]).append(",");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
