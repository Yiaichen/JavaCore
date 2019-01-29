package sort;

/**
 * 插入排序
 * 对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
 * <p>
 * 1、从第一个元素开始，该元素认为已经被排序
 * 2、取出下一个元素，在已排序的元素序列中从后向前扫描
 * 3、如果已排序元素大于新元素，新元素继续比较前一个元素，直到找到已排序的元素小于或者等于新元素的位置
 * 4、将新元素插入到该位置后
 * 5、重复步骤2~4
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] a = {5, 2, 9, 4, 7, 6, 1, 3, 8};
        int insertIndex, insertElement;
        for (int i = 1; i < a.length; i++) { //外层循环，默认第一个元素有序，从第二个元素开始，时间复杂度N
            insertIndex = i - 1; //插入的位置，默认有序数列的最后一个元素的位置
            insertElement = a[i]; //新插入的元素，默认外层循环的元素
            while (insertIndex >= 0 && a[insertIndex] > insertElement) { //内层循环，只要新元素比待插入位置的元素小就继续，时间复杂度N
                a[insertIndex + 1] = a[insertIndex]; //比待插入元素大的元素后移一位
                insertIndex--; //插入位置前移一位
            }
            a[insertIndex + 1] = insertElement; //内层循环结束，把新元素放到插入位置后面
        }
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

}
