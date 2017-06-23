package lang;

import org.junit.Test;

/**
 *String 测试 
 */
public class StringTest {
	
	
	/**
	 * 字符串与字符
	 */
	@Test
	public void test01() {
		String  s = "abcd";
		char[] value = {'a','b','c'};;
		
		System.out.println(new String(value));
		
		System.out.println(s.charAt(1));
		
		char[] charArray = s.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			System.out.print(charArray[i]);
		}
	}
	/**
	 * 字符串与字节 : 字符串转成字节时,默认是系统编码, 也可以指定编码
	 */
	@Test
	public void test02() throws Exception {
		String  s = "abcd";
		byte[] bytes = s.getBytes();
		System.out.println(new String(bytes));
	}
	
	/**
	 * 字符串比较
	 */
	@Test
	public void test03() {
		String  s1 = "abcd";
		String  s2 = "abcde";
		String  s3 = "Abcd";
		String  s4 = "abcd";
		
		System.out.println(s1.compareTo(s2));
		System.out.println(s2.compareTo(s1));
		System.out.println(s1.compareTo(s4));
		
		System.out.println(s1.equals(s4));
		
		System.out.println(s1.compareToIgnoreCase(s3));
	}
	
	/**
	 * 字符串查找
	 */
	@Test
	public void test04() {
		String  s1 = "abcd";
		System.out.println(s1.contains("ab"));
		
		System.out.println(s1.indexOf(98)); //返回int参数的字符串表示
		System.out.println(s1.indexOf("a"));
		System.out.println(s1.lastIndexOf("a"));
		System.out.println(s1.startsWith("a"));
		System.out.println(s1.endsWith("d"));
	}
	
	/**
	 * 字符串替换
	 */
	@Test
	public void test05() {
		String  s1 = "abcdba";
		
		System.out.println(s1.replace('a', 'e')); //替换所有
		System.out.println(s1.replaceAll("b", "f"));
		
		System.out.println(s1.replaceFirst("a", "j"));//替换首个
	}
	
	/**
	 * 字符串截取
	 */
	@Test
	public void test06() {
		String  s1 = "abcd";
		System.out.println(s1.substring(3));
		System.out.println(s1.substring(0, 1)); //输出a, 右边是开区间
	}
	
	/**
	 * 字符串拆分
	 */
	@Test
	public void test07() {
		String  s1 = "abcdch";
		String[] split = s1.split("c");
		for (String string : split) {
			System.out.println(string); //输出ab 和 d
		}
		
		String[] split2 = s1.split("c", 1); 
		for (String string : split2) {
			System.out.println(string); 
		}
	}

	/**
	 * format : http://blog.csdn.net/lonely_fireworks/article/details/7962171
	 */
	@Test
	public void test08() {
		String  s1 = "{0}/bcdch";
		System.out.println(String.format("1", s1));

	}

	/**
	 * 其他
	 */
	@Test
	public void test09() {
		String  s1 = "abcdch";
		
		System.out.println(s1.isEmpty());
		System.out.println(s1.length());
		System.out.println(s1.trim());
		System.out.println(s1.toLowerCase());
		System.out.println(s1.intern());
	}
}
