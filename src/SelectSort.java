

/**
 * :遍历第i到第n个，找到i到n范围内最小的数，
 * 然后放在i的位置。接着遍历i+1到第n个，
 * 找到i+1到n范围内最小的数，然后放在i+1的位置，
 * 重复执行下去，最后数组从小到大排列。
 */
public class SelectSort {


    public int[] selectSort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            int minIndex = i;
            int minValue = arr[i];
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < minValue) {
                    minIndex = j;
                    minValue = arr[j];
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

}
