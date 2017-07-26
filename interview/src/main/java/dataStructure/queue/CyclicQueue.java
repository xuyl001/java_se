package dataStructure.queue;

/**
 * 循环队列: 通过数组实现
 * Created by conglin.liu on 2017/7/21.
 */
public class CyclicQueue {
    private int[] queue;
    public  int  max;//数组的容量
    private int front;//队首下标
    private int rear;//队尾下标
    private int length;//队列长度

    public CyclicQueue(int max) {
        this.queue = new int[max];
        this.max = max;
        this.front = 0;
        this.rear = -1;
        this.length = 0;
    }

    //插入到队尾
    public void insert(int elem){
        if(isFull()) {
            try {
                throw new Exception("满");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //如果队尾指针已经到达数组的末端,插入到数组的第一个位置
        if(rear == (max-1) ) {
            rear = -1;
        }

        queue[++rear] = elem;
        length++;
    }
    //移除队首
    public int delete() {
        if(isEmpty()) {
            try {
                throw new Exception("空");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        int elem = queue[front++];
        //如果对首指针已经达到数组末端, 则移到数组的第一个位置
        if(front == max) {
            front = 0;
        }

        length--;
        return elem;
    }

    //判断空
    public boolean isEmpty() {
        return length == 0;
    }
    //判断满
    public boolean isFull(){
        return length == max;
    }

    public static void main(String[] args) {
        CyclicQueue queue = new CyclicQueue(2);
        queue.insert(1);
        queue.insert(2);
//        queue.insert(3);
        System.out.println(queue.delete());

        for (int i: queue.queue) {
            System.out.println(i);
        }
    }
}
