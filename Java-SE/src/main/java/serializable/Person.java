package serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Serializable
 */
public class Person implements Serializable{
//	private static final long serialVersionUID = 1L;
	
	private String name;
	
	//transient static
    private   int age;
    
    //新增: 验证serialVersionUID
    private int phone;
    
    //无法序列化
//    private  Thread t = new Thread();

    public Person(String name ,int age){
        this.name = name;
        this.age =age;
    }
    
    public Person() {
	}

    //自定义序列化
    public void writeObject(ObjectOutputStream out) throws IOException{
       out.defaultWriteObject();
       out.writeObject(name);
       out.writeInt(age);

    }
    
    // 自定义反序列化操作
    public void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException{ 
        in.defaultReadObject();
        name = (String) in.readObject();
        age = in.readInt();
        
        System.out.println(name + "--" + age);
    }


	public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "name is " + name + " , age is " + age;
    }
}
