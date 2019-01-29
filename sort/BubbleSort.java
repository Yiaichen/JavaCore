package sort;

/**
 * 冒泡排序
 * 重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换
 * <p>
 * 1、初始状态：无序区为R[1..n]，有序区为空
 * 2、第i趟排序(i=0,1,2…n-1)开始时，当前无序区和有序区分别为R[0..n-i]和R[n-i+1..n]。
 * 对每一对相邻元素进行比较，从开始第一对到结尾的最后一对，如果第一个比第二个大，就交换它们两个，这样在最后的元素应该会是最大的数
 * 使R[1..n-i-1]和R[n-i..n]分别变为记录个数减少1个的新无序区和记录个数增加1个的新有序区
 * 3、循环n-1次，直到排序完成
 */
public class BubbleSort {

    public static void main(String[] args) {
        int A[] = {6, 5, 3, 1, 8, 7, 2, 4};
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
        for (int i : A) {
            System.out.print(i + " ");
        }
    }
}
