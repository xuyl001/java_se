package basic.genericType;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 *泛型 
 */
public class Generic {

	/**
	 * 泛型类 
	 */
	@Test
	public void test01() {
		DaoClass<String> d = new DaoClass<String>();
		d.setValue("1");
		System.out.println(d.getValue());
	}
	

	/**
	 * 泛型接口 
	 */
	@Test
	public void test02() {
		Dao d = new Dao();
		d.print("1", 0);
	}
	
	/**
	 * 类型擦除1
	 */
	@Test
	public void test03() {
		List<String> list_str = new ArrayList<String>();
		List<Integer> list_int = new ArrayList<Integer>();
		
		System.out.println(list_str.getClass() == list_int.getClass());
	}
	
	/**
	 * 类型擦除2
	 */
	@Test
	public void test04() {
		List<String> list = new ArrayList<String>();
		
		try {
			list.getClass().getMethod("add", Object.class).invoke(list, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	
	
	
	/**
	 * 泛型方法
	 * @param <A>
	 */
	public static <K, V>V  get(K k, V v) {
		System.out.println(k + "-----" + v);
		return null;
	}
	
	/**
	 * 泛型方法 多个类型限定: 一个类多个接口,用&隔开, 且类在做前面 
	 */
	public static <T extends DaoClass&DaoInterface>T  list(){
		return null;
	}
	
	
	public static void main(String[] args) {
		get("1", 1);
		Generic.<String, Integer>get("1", 1);
	}
	
	
	
	
}

/**
 * 泛型类 
 */
class DaoClass<T> {
	private T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}

/**
 * 泛型接口
 */
interface DaoInterface<K,V>{
	void print(K k, V v);	
}

class Dao implements DaoInterface<String, Integer>{

	public void print(String k, Integer v) {
		System.out.println(k + "------" + v);
	}
}