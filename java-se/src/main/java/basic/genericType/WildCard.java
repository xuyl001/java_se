package basic.genericType;

import java.util.ArrayList;
import java.util.List;

/**
 *通配符  : 不能添加
 */
public class WildCard {
	
	/**
	 * 无边界: 可以是任何类型
	 */
	public void test01() {
		List<?> list = null;
		
		list = new ArrayList<String>();
		list = new ArrayList<Integer>();
		
		//编译报错
		//list_str.add("1");
	}
	
	/**
	 * 上边界: 该类和其子类
	 */
	public void test02() {
		List<? extends Man> list = null;
		list  = new ArrayList<Man>();
		list =  new ArrayList<Child>();
		
		//编译报错
	   // list  = new ArrayList<Person>();
	}
	
	/**
	 * 下边界: 该类和其父类
	 */
	public void test03() {
		List<? super Man> list = null;
		list = new ArrayList<Person>();
		list = new ArrayList<Man>();
		
		//编译错误
//		list = new ArrayList<Child>();
	}
}

class Person {

}

class Man extends Person{
	
}

class Child extends Man {
	
}