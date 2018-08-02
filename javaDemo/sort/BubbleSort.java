package javaDemo.sort;

/**
 * 冒泡排序
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
