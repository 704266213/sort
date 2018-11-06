
/**
 * 如第0到5范围内的数从小到大排列，第六个数记为temp，此时第temp比第5个数小，
 * 那么第5个数往后退，接着再与第4个数比较，如果还是比第4个数小，那么第4个数继续后退，
 * 接着如果不小于第3个数，这个时候将temp存到4的位置 。
 * 总的来说，就是在一个有序范围内，插入一个该范围之外的数，
 * 随着执行下，有序范围逐渐扩大，最后整体有序。
 */
public class InsertSort {


    public int[] insertSort(int[] arr) {
        int size = arr.length;
        for (int i = 1; i < size; i++) {
            int temp = arr[i];
            for (int k = i - 1; k >= 0; k--) {
                int maxValue = arr[k];
                if (temp < maxValue) {
                    arr[k] = temp;
                    arr[k + 1] = maxValue;
                } else {
                    break;
                }
            }
        }
        return arr;
    }

}
