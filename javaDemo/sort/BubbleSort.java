package javaDemo.sort;

//������ð������
//���� -------------- �ڲ��Ƚ�����
//���ݽṹ ---------- ����
//���ʱ�临�Ӷ� ---- O(n^2)
//����ʱ�临�Ӷ� ---- ��������ڲ�ѭ����һ������ʱ,ʹ��һ���������ʾ������Ҫ�����Ŀ���,���԰�����ʱ�临�ӶȽ��͵�O(n)
//ƽ��ʱ�临�Ӷ� ---- O(n^2)
//���踨���ռ� ------ O(1)
//�ȶ��� ------------ �ȶ�
public class BubbleSort {

    public static void main(String[] args) {
        int A[] = {6, 5, 3, 1, 8, 7, 2, 4};    // ��С����ð������
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
