package sort;

/**
 * 快速排序
 * 通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序
 * <p>
 * 1、从数列中挑出一个元素，称为 “基准”（pivot）
 * 2、重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作
 * 3、递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序
 */
public class FastSort {

    public static void main(String[] args) {
        int[] a = {5, 2, 9, 4, 7, 6, 1, 3, 8};
        sort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    /**
     * 递归进行快速排序
     */
    private static void sort(int[] a, int left, int right) {
        if (right <= left) { //排序从左到右，确保右边比左边大
            return;
        }
        int j = partition(a, left, right); //切分
        sort(a, left, j - 1); //将左半边排序
        sort(a, j + 1, right); //将右半边排序
    }

    /**
     * 快速排序切分
     */
    private static int partition(int[] a, int left, int right) {
        int i = left, j = right + 1; //左右扫描指针
        int v = a[left]; //选取切分元素，这里选第一个，实际数据可以自行挑选
        while (true) {
            while (a[++i] < v) { //a[i]<v时增大i，只要比v小继续往右扫描 i="=" v="">< a[--j]){ //a[j]>v时减小j，只要比v大继续往左扫描
                if (j == left) { //扫描到左边则终止
                    break;
                }
            }
            while (v < a[--j]) { //a[j]>v时减小j，只要比v大继续往左扫描
                if (j == left) { //扫描到左边则终止
                    break;
                }
            }
            if (i >= j) { //如果左右指针交叉，终止循环
                break;
            }
            exch(a, i, j); //不满足上述条件（左边比v大，右边比v小，指针未交叉），左右元素交换位置
        }
        exch(a, left, j); //将切分元素v放入正确的位置
        return j; //a[left..j-1]<=a[j]<=a[j+1..right]，并返回j
    }

    /**
     * 交换两个元素
     */
    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
