package dataStructure.doubleLink;

import dataStructure.singleLink.Link;

/**
 * 双端链表
 * Created by conglin.liu on 2017/7/13.
 */
public class DoubleLink {
    private Link first;
    private Link last;

    public DoubleLink() {
        this.first = null;
        this.last = null;
    }

    //插入到表头
    public void insert(Link link) {
        if(isEmpty()) {
            last = link;
        }
        link.next = first;
        first = link;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        DoubleLink doubleLink = new DoubleLink();
        Link link = new Link("first",null);
        Link link1 = new Link("seond",null);
        doubleLink.insert(link);
        doubleLink.insert(link1);
        System.out.println(doubleLink.first);

    }
}
