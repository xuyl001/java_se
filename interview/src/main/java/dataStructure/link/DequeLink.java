package dataStructure.link;

/**
 * 双端链表
 * Created by conglin.liu on 2017/7/13.
 */
public class DequeLink {
    private Link first;
    private Link last;

    public DequeLink() {
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

    //插入到链表的末端
    public void insertLast(Link link) {
        if(isEmpty()) {
            first = link;
        }else{
            last.next = link;
        }
        last = link;
    }

    //删除第一个链结点, 返回删除节点引用
    public Link delete() {
        if(isEmpty()) {
            try {
                throw  new Exception("空");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(first.next == null) {//只有一个节点
            last = null;
        }

        Link temp = first;
        first = first.next;
        return temp;
    }


    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        DequeLink doubleLink = new DequeLink();
        Link link = new Link(1,"first",null);
        Link link1 = new Link(2,"seond",null);
        doubleLink.insert(link);
//        link.insertLast(link1);
        doubleLink.delete();
        System.out.println(doubleLink.first);

    }
}
