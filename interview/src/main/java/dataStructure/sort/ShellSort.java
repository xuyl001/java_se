package dataStructure.sort;

/**
 * Created by conglin.liu on 2017/6/12.
 */
public class ShellSort {
    static  int[] array = {21,34,12,18,56,10};//要排序的数组
    public static void main(String[] args) {
        shellsort(array, array.length);
    }
    /**
     * 第2种方法
     * @param a
     * @param n
     */
    static void shellsort(int a[], int n) {
        int i, j, gap;
        for (gap = n / 2; gap > 0; gap /= 2)//步长
            for (i = gap; i < n; i++)//直接插入排序 : 从第gap个元素开始
                for (j = i - gap; j >= 0 && a[j] > a[j + gap]; j -= gap)//组内比较
                    swap(j, j + gap);
    }

    //交换数组中两个元素的数据
    public  static void swap(int low, int high) {
        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;
    }
}
