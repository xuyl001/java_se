package dataStructure.queue;

/**
 * 优先级队列
 * http://www.cnblogs.com/smyhvae/p/4793339.html
 * Created by conglin.liu on 2017/7/26.
 */
public class PriorityQueue {
    static final int defaultSize = 10; //默认队列长度
    int front; //队头
    int rear;  //队尾
    int count;  //计数器
    int maxSize; //队列最大长度
    Element[] queue; //队列

    public PriorityQueue() {
        init(defaultSize);
    }

    public PriorityQueue(int size) {
        init(size);
    }

    public void init(int size) {
        maxSize = size;
        front = rear = 0;
        count = 0;
        queue = new Element[size];
    }

    public void append(Object obj) throws Exception {
        //如果队列已满
        if (count >= maxSize) {
            throw new Exception("队列已满！");
        }
        queue[rear] = (Element) obj;
        rear++;
        count++;
    }

    public Object delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空！");
        }
        //默认第一个元素为优先级最高的。
        Element min = queue[0];
        int minIndex = 0;
        for (int i = 0; i < count; i++) {
            if (queue[i].getPriority() < min.getPriority()) {
                min = queue[i];
                minIndex = i;
            }
        }

        //找的优先级别最高的元素后，把该元素后面的元素向前移动。
        for (int i = minIndex + 1; i < count; i++) {
            queue[i - 1] = queue[i]; //移动元素
        }
        rear--;
        count--;
        return min;
    }

    public Object getFront() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空！");
        }
        //默认第一个元素为优先级最高的。
        Element min = queue[0];
        int minIndex = 0;
        for (int i = 0; i < count; i++) {
            if (queue[i].getPriority() < min.getPriority()) {
                min = queue[i];
                minIndex = i;
            }
        }
        return min;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public static void main(String[] args) throws Exception {
        PriorityQueue queue = new PriorityQueue();
        Element temp;

        //五个进程入队
        queue.append(new Element(1, 30));
        queue.append(new Element(2, 20));
        queue.append(new Element(3, 40));
        queue.append(new Element(4, 20));
        queue.append(new Element(5, 0));

        //按照优先级出队。
        System.out.println("编号  优先级");
        while (!queue.isEmpty()) {
            temp = (Element) queue.delete();
            System.out.println(temp.getElement() + " " + temp.getPriority());
        }
    }
}
