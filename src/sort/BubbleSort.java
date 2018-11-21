package sort;

/**
 * 冒泡排序
 * 什么叫做是冒泡排序 冒泡排序就是相邻的元素进行对比 一步一步的把最大值找出来，这就是冒泡排序
 * 可以进行从大到小，也可以从小到大排序 只要更改switchSort 中的a<b即可
 */
public class BubbleSort {


    public int[] bubbleSort(int[] arr) {
        int size = arr.length - 1;
        for (int i = size; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int temp = arr[j];
                int next = arr[j + 1];
                if (temp > next) {
                    arr[j] = next;
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }


}
