package sort;

/**
 * Created by conglin.liu on 2017/5/31.
 * 直接插入排序:
 * 将数据插入到已经排好序的序列中
 * 第一次插入时 : 当序列只有一个数时,认为是有序的
 */
public class InsertSort {
    static  int[] array={49,38,65,52,13,25,45,62,20};

    public static void main(String[] args) {
        insertSort();

//        test();
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]);
        }
    }

    public static void insertSort() {
        for (int i = 0; i <array.length ; i++) {
            int temp = array[i];//存储待排序的元素值
            int insertPoint = i-1; //与待排序元素值作比较的元素的下标
            while (insertPoint>=0 && array[insertPoint]>temp) {//比较大小: 待排序元素小
                array[insertPoint+1] = array[insertPoint];//要比较的元素向后移动一位
                insertPoint--;
            }
            array[insertPoint+1] = temp;//找到了插入位置，插入待排序元素
        }
    }

    public static void test() {
        for ( int i = 0; i < array.length; i++) {
            int temp = array[i];//待排序元素
            int insertPoint = i - 1; //要比较的元素
            while(insertPoint >= 0 && array[insertPoint] > temp) {
                array[insertPoint+1] = array[insertPoint];
                insertPoint--;
            }
            array[insertPoint+1] = temp; //插入待排序元素
        }
    }

}
