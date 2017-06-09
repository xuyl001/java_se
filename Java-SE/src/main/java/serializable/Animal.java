package serializable;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * Externalizable
 */
public class Animal implements Externalizable {
	private static  String name;
    private transient int age;
    
	public Animal() {
	}
	
	
	public Animal(int age, String name) {
		this.age = age;
		this.name = name;
	}



	public static String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + "age=" + age + "]";
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		 out.writeObject(name);
	     out.writeInt(age);  
	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		 name = (String) in.readObject();
	      age = in.readInt();
	}
	
	public static void main(String[] args) {
		String  path = "dir.txt";
		Animal a = new Animal(1, "3");
		
		try {
			ObjectOutputStream o = new ObjectOutputStream(new  FileOutputStream(path));
			a.writeExternal(o);
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
			a.readExternal(in);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
