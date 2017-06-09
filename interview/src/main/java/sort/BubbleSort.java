package sort;

/**
 *冒泡排序 
 */
public class BubbleSort {
	/**
	 * 相邻的两个元素比: 每次选择一个最小的放在前面
	 */
	public static void main(String[] args) {
		int[] array = { 2, 3, 1, 4 };
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
