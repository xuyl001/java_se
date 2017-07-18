package dataStructure.link;

/**
 * 单链表
 * Created by conglin.liu on 2017/7/13.
 */
public class SingleLink {
    protected   Link first;

    public SingleLink() {
        first = null;
    }

    //插入到第一个链接点
    public  void insert(Link link) {
        link.next = first;
        first = link;
    }

    //删除第一个链接点
    public Link remove(Link link) {
        Link temp = first;
        first = link.next;
        return  temp;
    }

    //打印所有的节点
    public void display() {
        Link cur = first;
        while(cur != null) {
//            System.out.println(cur);
            cur = first.next;
        }
    }

    //查找属性为指定值的节点
    public Link find(String name) {
        Link cur = first;
        Link link = null;

        while(cur != null) {
            if(cur.getName().equals(name)) {
                link = cur;
                System.out.println(link);
                break;
            }else if(cur.next == null) {
                System.out.println("======");
                break;
            }

            cur = cur.next;
        }

        return link;
    }

    public static void main(String[] args) {
        SingleLink linkList = new SingleLink();
        testInsert(linkList);
        linkList.find("firs");

    }

    public static void testRemove() {
        SingleLink linkList = new SingleLink();
        Link link = new Link(1,"first", null);
        linkList.remove(link);
    }

    public static void testInsert(SingleLink linkList) {
        Link link = new Link(2,"first", null);
        linkList.insert(link);
//        System.out.println(link);
    }
}
