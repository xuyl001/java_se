package lang;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.Test;

/**
 *System: 该类代表系统级别, 由final修饰, 所有的方法都是静态方法 
 */
public class SystemTest {

	/**
	 * 测试属性in
	 */
	@Test
	public void test01() throws Exception {
		 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		 System.out.println(reader.readLine());
	}
	
	/**
	 * 测试exit(): 非零表示终止midnight, January 1, 1970 
	 */
	@Test
	public void test02() throws Exception {
		 System.exit(1);
		 System.out.println(1);
	}
	
	/**
	 * 系统时间: currentTimeMillis() 从midnight, January 1, 1970至今的毫秒值
	 */
	@Test
	public void test03() throws Exception {
		System.out.println(System.currentTimeMillis());
	}
}
