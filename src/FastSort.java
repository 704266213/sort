/*
 *首先在数组中选择一个基准点（该基准点的选取可能影响快速排序的效率，后面讲解选取的方法），
 *然后分别从数组的两端扫描数组，设两个指示标志（lo指向起始位置，hi指向末尾)，
 *首先从后半部分开始，如果发现有元素比该基准点的值小，就交换lo和hi位置的值，
 *然后从前半部分开始扫秒，发现有元素大于基准点的值，就交换lo和hi位置的值，
 *如此往复循环，直到lo>=hi,然后把基准点的值放到hi这个位置。一次排序就完成了。
 *以后采用递归的方式分别对前半部分和后半部分排序，当前半部分和后半部分均有序时该数组就自然有序了。
 * 假设要排的数组为：A[8] ={ 5 2 8 9 1 3 4 10 }
           选择 key = 5， 开始时 i=0，j=7
  index      0    1    2    3    4    5    6    7

开始：       5    2    8    9    1    3    4    10
             i                                  j
第一次找     4    2    8    9    1    3    5    10
                  i                        j
交换：       4    2    5    9    1    3    8    10
                       i              j

第二次找     4    2    3    9    1    5    8    10
                            i         j
交换：       4    2    3    5    1    9    8    10
                            i    j

第三次找     4    2    3    1    5    9    8    10
                                 ij
调整key：    4    2    3    1    5    9    8    10
                                 ij


 */
public class FastSort {

    public int[] fastSort(int[] arr) {
        int size = arr.length;

        return arr;
    }
}
