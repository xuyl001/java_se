package dataStructure.sort;

/**
 *选择排序 
 */
public class SelectSort {
	/**
	 * 首位和剩下的所有元素比, 每次选择一个最大的放在首位
	 */
	public static void main(String[] args) {
		int[] array = {2,3,1,4};
		for (int i = 0; i < array.length-1; i++) {
			for (int j = i+1; j < array.length; j++) {
				if(array[i] < array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
