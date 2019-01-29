package sort;

/**
 * 希尔排序
 * 插入排序的改进版，优先比较距离远的元素，减少交换次数
 * <p>
 * 1、选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1
 * 2、按增量序列个数k，对序列进行k 趟排序
 * 3、每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
 * 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] a = {5, 2, 9, 4, 7, 6, 1, 3, 8};
        int h = 1; //希尔排序是使间隔为h的元素有序
        int insertIndex, insertElement;
        while (h < a.length / 3) { //while循环，扩大h
            h = 3 * h + 1; //这里用3倍作为希尔排序的间隔，是常用的值，加1是为了防止排序的都是3的倍数
        }
        while (h >= 1) { //while循环让h从大到小插入排序
            for (int i = h; i < a.length; i++) {  //从h位置开始，对整个数组遍历，i为插入元素的位置
                insertIndex = i - h; //插入的位置，默认前面间隔h的位置
                insertElement = a[i]; //新插入的元素，默认外层循环的最后一个元素
                while (insertIndex >= 0 && a[insertIndex] > insertElement) { //内层循环，只要新元素比待插入位置的元素小就继续
                    a[insertIndex + h] = a[insertIndex]; //比待插入元素大的元素后移h位
                    insertIndex -= h; //插入位置前移h位
                }
                a[insertIndex + h] = insertElement; //内层循环结束，把新元素放到插入位置后面
            }
            h = h / 3; //更大间隔的插入完成，缩小插入间隔
        }
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

}
