package innerClass;

import innerClass.Parent.Inner2;

/**
 *普通内部类 
 *静态内部类
 *匿名内部类
 */
public class InnerClass {
	public static void main(String[] args) {
		/**
		 * 创建静态内部类：注意这里是 直接new的 
		 */
		Parent.Inner1 i = new Parent.Inner1();
		i.print();
		
		/**
		 * 创建普通内部类：注意这里是 p.new 
		 */
		Parent p = new Parent();
		Inner2 t =  p.new Inner2();
		t.print();
		
		/**
		 * 创建匿名内部类：注意这里是 
		 */
		
		Anonymity a= new Anonymity() {
			public void print() {
				System.out.println("in anonymity");
				
			}
		};
		a.print();
	}
}

class Parent {
	/**
	 * 静态内部类: 不指向某个具体的外部类对象,class的类型是 Parent.Inner
	 */
	static class Inner1 {
		public void print() {
			System.out.println("in inner1");
		}
	}
	
	/**
	 * 普通内部类 : 指向外部类, class类型是: Parent.Inner
	 */
	class Inner2 {
		public void print() {
			System.out.println("in inner2");
		}
	}
}

interface Anonymity{
	void print();
}