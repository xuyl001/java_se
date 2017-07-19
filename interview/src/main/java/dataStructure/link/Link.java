package dataStructure.link;

/**
 *
 * Created by conglin.liu on 2017/7/13.
 */
public class Link {
    protected  int age;
    protected String name;
    public Link next;
    public Link pre;

    public Link(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Link(int age, String name, Link next) {
        this.age = age;
        this.name = name;
        this.next = next;
    }

    public Link(int age, String name, Link next, Link pre) {
        this.age = age;
        this.name = name;
        this.next = next;
        this.pre = pre;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public Link getNext() {
        return next;
    }


    @Override
    public String toString() {
        return "Link{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", next=" + next +
                '}';
    }
}
