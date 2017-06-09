package sort;

/**
 * Created by conglin.liu on 2017/5/31.
 */
public class QuickSort {
    static  int[] array = {21,34,12,18,56,10};//要排序的数组

    public static void main(String[] args) {
        quickSort(0, array.length-1);

        System.err.println("快排后的结果:");
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]);
        }
    }

    //快排
    public  static void quickSort(int low, int high ) {
        if(low >= high) {
            return;
        }else {
            int partition = partition(low, high, array[low]);//分段
            quickSort(low,partition-1);//对低分段排序
            quickSort(partition+1,high);//对高分段排序
    }
    }
    /**
     * 以pivot为基准对数组进行划分 , 比pivot小的元素在低位段，比pivot大的元素在高位段
     * @param low 　默认0
     * @param high  默认最高位的下标
     * @param pivot  基准元素 , 默认第一个元素
     * @return  划分完成后基准元素所在位置的下标
     */
    public  static int  partition(int low, int high, int pivot) {
        while(low < high) {
            while(low<high && array[high]>=pivot) {//从右端开始扫描，定位到第一个比pivot小的元素
                high--;//如果array[high]比基准pivot大，就不管，继续向前移动
            }
            swap(low, high);//如果array[high]比基准pivot小，就交换low和high

            while(low<high && array[low]<=pivot) {////从左端开始扫描，定位到第一个比pivot大的元素
                low++;//如果array[low]比基准pivot小，就不管，继续向后移动
            }
            swap(low, high);//如果array[low]比基准pivot大，就交换low和high

        }
        return low;
    }
    //交换数组中两个元素的数据
    public  static void swap(int low, int high) {
        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;
    }

}
