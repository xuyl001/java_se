package dataStructure.tree;

/**
 * 节点类
 * Created by conglin.liu on 2017/8/10.
 */
public class Node {
    public  int age;
    String name;
    public Node leftChild;  //左子节点的引用
    public Node rightChild; //右子节点的引用

    public Node(int age,String name){
        this.age = age;
        this.name = name;
    }

    public String display() {
        return "Node{" +
                "age=" + age +
                '}';
    }

    @Override
    public String toString() {
        return "Node{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
