package sort;

/**
 * Created by conglin.liu on 2017/5/31.
 * 插入排序之直接排序
 */
public class InsertSort {
    static  int[] array={49,38,65,52,13,25,45,62,20};

    public static void main(String[] args) {
        insertSort();

        System.err.println("排序后的结果");
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]);
        }
    }

    public static void insertSort() {
        for (int i = 0; i <array.length ; i++) {
            int temp = array[i];//存储待排序的元素值
            int insertPoint = i-1; //与待排序元素值作比较的元素的下标
            while (insertPoint>=0 && array[insertPoint]>temp) {//当前元素比待排序元素大
                array[insertPoint+1] = array[insertPoint];//当前元素后移一位
                insertPoint--;
            }
            array[insertPoint+1] = temp;//找到了插入位置，插入待排序元素
        }

    }

}
