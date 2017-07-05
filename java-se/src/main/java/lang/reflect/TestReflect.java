package lang.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestReflect {

	/**
	 * 获得Class 对象
	 */
	@Test
	public void test1() throws Exception {
		// 第一种: 使用forName()
		System.out.println(Class.forName("lang.reflect.User"));
		
		//第二种: 直接获取类的Class
		System.out.println(User.class);
		
		//第三种: 调用某个对象的getClass()
		System.out.println(Integer.TYPE.getClass());
	}
	
	/**
	 * 判断是否为某个类的实例
	 */
	@Test
	public void test2() throws Exception {
		System.out.println(Class.forName("lang.reflect.User").isInstance(new User()));
	}
	
	/**
	 * 获得实例
	 */
	@Test
	public void test3() throws Exception {
		Class<String> c = String.class;
		
		//第一种: 使用Class对象的newInstance()方法来创建Class对象对应类的实例
		String s = c.newInstance();
		System.out.println(s);
		
		//第二种: 
		Constructor<String> constructor = c.getConstructor(c);
		String newInstance = constructor.newInstance("1");
		System.out.println(newInstance);
	}
	
	/**
	 * 获得方法
	 */
	@Test
	public void test4() throws Exception {
		Class<?> c = User.class;
		
		//返回所有的方法:但不包括继承的方法
		Method[] declaredMethods = c.getDeclaredMethods();
		for (Method method : declaredMethods) {
			System.out.println(method.getName());
		}
		
		//返回所有公开的方法
		Method[] methods = c.getMethods();
		
		/**
		 * 返回一个特定非方法
		 * 参数1: 　方法名称
		 * 参数2:　方法参数
		 */
		Method method = c.getMethod("setId", int.class);
		method.invoke(c.newInstance());
		
		System.out.println(method.getName());
	}
	
	/**
	 * 调用方法
	 */
	@Test
	public void test5() throws Exception {
		Class<?> c = User.class;
		Object newInstance = c.newInstance();
		Method method = c.getMethod("setId", int.class);
		
		 method.invoke(newInstance, 1);
	}
	
	/**
	 * 创建数组
	 */
	@Test
	public void test6() throws Exception {
		Class<?> name = Class.forName("java.lang.String");
		Object array = Array.newInstance(name, 3);
		Array.set(array, 0, "0");
		Array.set(array, 1, "1");
		
		System.out.println(Array.get(array, 0));
		
		
	}
}
