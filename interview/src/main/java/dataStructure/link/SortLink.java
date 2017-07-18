package dataStructure.link;

/**
 * 有序链表
 * Created by conglin.liu on 2017/7/18.
 */
public class SortLink {
    private Link first;

    //插入
    public void insert(Link link){
        Link pre = null;
        Link cur = first;
        //链表又大到小
        while(cur != null && cur.age < link.age) {
            pre = cur;
            cur = cur.next;
        }

        //当前插入节点为表头
        if(pre == null) {
            this.first = link;
        }else {
            pre.next = link;
        }

        link.next = cur;
    }

    public static void main(String[] args) {
        SortLink sortLink = new SortLink();
        Link link = new Link(1,"first",null);
        Link link1 = new Link(2,"seond",null);
        sortLink.insert(link1);
        sortLink.insert(link);
        System.out.println(sortLink.first);

    }
}
