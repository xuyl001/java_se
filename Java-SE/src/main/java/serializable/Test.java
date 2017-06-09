package serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {
	static String  path = "dir.txt";
	
	public static void main(String[] args) {
		Person p = new Person("3", 1);
		
//		Person p = new Person();
//		write(p);
		
		//序列化之后 对对象重新赋值
		 p = new Person("4", 2);
		
		//输出的还是序列化之前的
		read(p);	
		
//		defaultSerializable();
	}
	
	static void defaultSerializable() {
		try {
			Person p = new Person("3", 1);
			ObjectOutputStream o = new ObjectOutputStream(new  FileOutputStream(path));
			p.writeObject(o);
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
			p.readObject(in);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	static void write(Person object)   {
		try {
			ObjectOutputStream o = new ObjectOutputStream(new  FileOutputStream(path));
			o.writeObject(object);
			o.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void read(Person object) {
		try {
			ObjectInputStream o = new ObjectInputStream(new FileInputStream(path));
			object  =(Person) o.readObject();
			o.close();
			System.out.println("序列化成功" + object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
