package basic.array;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 *数组 
 */
public class ArrayTest {

	/**
	 * 基本类型:
	 * 类名 : 若干个[ + 内部表示I
	 * 父类 :Object
	 */
	@Test
	public void test01() {
		int[] a = new int[10];
		
		System.out.println(a.getClass().getName()); // [I
		//二维
		int[][] b = new int[10][10];
		System.out.println(b.getClass().getName()); //[[I
		
		//三维
		int[][][] c = new int[10][10][10];
		System.out.println(c.getClass().getName());//[[[I
		
		System.out.println(a.getClass().getSuperclass());// Object
	}
	
	/**
	 * 引用类型
	 * 类型: 若干个[+L+数组元素类全限定路径+类
	 */
	@Test
	public void test02() {
		//数组的类名
		System.out.println(int[].class);
		System.out.println(String[].class);
		System.out.println(Object[].class);
		System.out.println(Object[][].class);
		System.out.println(Object.class);
	}
	
	/**
	 * 测试数组的类信息: 是个空类
	 * 所有length属性: 是通过arraylength 指令获取的
	 */
	@Test
	public void test03() {
		int[] a = new int[10];
		Class clazz = a.getClass();
		
		System.out.println(clazz.getDeclaredFields().length);
		System.out.println(clazz.getDeclaredMethods().length);
		System.out.println(clazz.getDeclaredConstructors().length);
		System.out.println(clazz.getDeclaredAnnotations().length);
		System.out.println(clazz.getDeclaredClasses().length);
	}
	
	/**
	 * 数组扩容
	 */
	@Test
	public void test04() {
		
		String[] a = new String[10];
		String[] expandCapacity = expandCapacity(a, 2);
		
		System.out.println(expandCapacity.length);
	}
	
	
	/**
	 * 数组复制
	 */
	@Test
	public void test05() {
		Person[] s1 = {new Person()};
		Person[] copyOf = Arrays.copyOf(s1, s1.length);
		display(s1);
		display(copyOf);
		
		copyOf[0].setName("改变");
		display(s1);
		display(copyOf);
	}
	
	/**
	 * 数组与List转换
	 * 基本类型数组会被当做一个对象
	 */
	@Test
	public void test06() {
//		int[] a = {1,2,3};
//		List<int[]> asList = Arrays.asList(a);
//		System.out.println(asList.size());      //1
//		System.out.println(a.equals(asList.get(0)));  //true
		
		Integer[] a = {1,2,3};
		List<Integer> asList = Arrays.asList(a);
		
		System.out.println(asList.size());
		System.out.println(a.equals(asList.get(0)));
	}
	
	/**
	 * asList()返回的是Arrays的内部类 ArrayList
	 * ArrayList 的父类定义了 add ,并抛出异常, 但是没实现,需要子类自己重写, 所以ArrayList是定长的
	 */
	@Test
	public void test07() {
		Person[] s1 = {new Person()};
		List<Person> asList = Arrays.asList(s1);
	    asList.add(new Person()); //运行时错误
	}
	
	
	
	public void display(Person[] s) {
		for (Person string : s) {
			System.out.println(string.getName());
		}
	}
	
	public <T>T[] expandCapacity(T[] data , int multiple) {
		
		return Arrays.copyOf(data, data.length+multiple);
		
	} 
}
