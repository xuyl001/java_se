package dataStructure.singleLink;

/**
 * Created by conglin.liu on 2017/7/13.
 */
public class Link {
    protected String name;
    public Link next;

    public Link(String name, Link next) {
        this.name = name;
        this.next = next;
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
                "name='" + name + '\'' +
                ", next=" + next +
                '}';
    }
}
