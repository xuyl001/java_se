package dataStructure.queue;

/**
 * Created by conglin.liu on 2017/7/26.
 */
public class Element {
    private Object element; // 数据
    private int priority; // 优先级

    public Element(Object obj, int priority) {
        this.element = obj;
        this.priority = priority;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
