package sort;

/**
 * 堆排序
 * 递归的把已有序列均分为两个子序列，使子序列有序，合并子序列
 * <p>
 * 1、把长度为n的输入序列分成两个长度为n/2的子序列
 * 2、对这两个子序列分别采用归并排序
 * 3、将两个排序好的子序列合并成一个最终的排序序列
 */
public class MergeSort {

    private static int[] aux; //归并所需的辅助数组

    public static void main(String[] args) {
        int[] a = {5, 2, 9, 4, 7, 6, 1, 3, 8};
        aux = new int[a.length];
        sort(a, 0, a.length - 1); //开始递归排序
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    /**
     * 递归的排序归并
     */
    private static void sort(int[] a, int left, int right) {
        if (right <= left) { //排序从左到右，确保右边比左边大
            return;
        }
        int mid = (left + right) / 2; //找出中间位置
        sort(a, left, mid); //将左半边排序
        sort(a, mid + 1, right); //将右半边排序
        merge(a, left, mid, right); //归并结果
    }

    /**
     * 原地归并方法
     */
    private static void merge(int[] a, int left, int mid, int right) { //将a[left..mid]和a[mid+1..right]归并
        int i = left, j = mid + 1;  //左右半边起始位置
        for (int k = left; k <= right; k++) { //将a[left..right]复制到aux[left..right]
            aux[k] = a[k];
        }
        for (int k = left; k <= right; k++) { //归并回到a[left..right]
            if (i > mid) {  //i比mid大代表左半边用完，只有右半边有元素
                a[k] = aux[j++]; //右边元素给a[k]
            } else if (j > right) { //j比right大代表右半边用完，只有左半边有元素
                a[k] = aux[i++]; //左边元素给a[k]
            } else if (aux[j] < aux[i]) { //如果右边元素大于左边
                a[k] = aux[j++]; //右边元素给a[k]
            } else {    //否则左边大于等于右边
                a[k] = aux[i++]; //左边元素给a[k]
            }
        }
    }

}
