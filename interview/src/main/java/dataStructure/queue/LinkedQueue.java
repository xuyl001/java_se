package dataStructure.queue;

/**
 * 链式队列 : 尾进头出
 * Created by conglin.liu on 2017/7/26.
 */
public class LinkedQueue {

    Node front; //队头
    Node rear;  //队尾
    int count; //计数器

    public LinkedQueue() {
        front = rear = null;
        count = 0;
    }


    // 添加到队尾
    public void append(Object obj) throws Exception {
        Node node = new Node(obj, null);

        //如果当前队列不为空。
        if (rear != null) {
            rear.next = node; //队尾结点指向新结点
        }

        rear = node; //设置队尾结点为新结点

        //说明要插入的结点是队列的第一个结点
        if (front == null) {
            front = node;
        }
        count++;
    }

    //移除队首元素
    public Object delete() throws Exception {
        if (isEmpty()) {
            new Exception("队列已空！");
        }
        Node node = front;
        front = front.next;
        count--;
        return node.getElement();
    }

    //获得队首元素
    public Object getFront() throws Exception {
        if (!isEmpty()) {
            return front.getElement();
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public static void main(String[] args) throws Exception {
        LinkedQueue queue = new LinkedQueue();
        queue.append("a");
        queue.append("b");
        queue.append("c");
        queue.append("d");
        queue.append("e");
        queue.append("f");

        queue.delete();
        queue.delete();

        queue.append("g");

        while (!queue.isEmpty()) {
            System.out.println(queue.delete());
        }
    }
}


