package dataStructure.link;

/**
 * 双向链表
 * Created by conglin.liu on 2017/7/18.
 */
public class DoubleLink {
    public Link first;
    public Link last;

    //插入到表头
    public void insertFirst(Link link){
        if(isEmpty()) {
            last = link; //插入的链表即为表头,又是表未
        }else{
            first.pre = link;
        }
        link.next = first;
        first = link;
    }

    //插入到表尾
    public void insertLast(Link link){
        if(isEmpty()) {
            first = link;
        }else{
            last.next = link;
            link.pre = last;
        }
        last = link;
    }

    //删除第一个链接点
    public Link deleteFirst() {
        if(isEmpty()) {
            try {
                throw  new Exception("空");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Link temp = first;
        //如果只用一个节点
        if(first.next == null) {
            last = null;
        }else{
            first.next.pre = null;
        }

        first = first.next;
        return temp;
    }

    //删除最后一个链接点
    public Link deleteLast() {
        if(isEmpty()) {
            try {
                throw  new Exception("空");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Link temp = last;
        //只有一个节点
        if(last.pre == null) {
            first = null;
        }else{
            last.pre.next = null;
        }

        last = last.pre;
        return temp;
    }

    //查找属性为指定值的链接点
    public Link find(int age){
        Link cur = first;
        while(cur != null && cur.age != age) {
            if(cur.next == null) {
                return null;
            }
             cur = cur.next;
        }
        System.out.println(cur);
        return cur;
    }

    //在指定节点之后插入
    public  boolean  insertAfter(Link link){
        Link tar = find(link.age);
        boolean flag = true;
        if(tar == null){ //没找到参考节点
             flag = false;
        }else{
            if(tar.next == null) { //参考节点是尾节点
                insertLast(link);
            }else{
                tar.next.pre = link;
                link.next = tar.next;

                //维护上一个节点的关系
                tar.next = link;
                link.pre = tar;
            }
        }
        return flag;
    }

    //判断为空
    public boolean isEmpty(){
        if(first == null) {
            return true;
        }
        return  false;
    }

    public static void main(String[] args) {
        DoubleLink doubleLink = new DoubleLink();
        Link link = new Link(1,"1");
        Link link1 = new Link(1,"2");
        doubleLink.insertFirst(link);
        doubleLink.insertAfter(link1);
//        doubleLink.insertLast(link1);
//        System.out.println(doubleLink.first);
//
//        doubleLink.deleteLast();
//        doubleLink.find(1);
        System.out.println(doubleLink.first);

    }
}
