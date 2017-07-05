package util.event;

import java.util.Observable;

/**
 *事件源 : 通知者
 */
public class SimpleObservable extends Observable {
	 private int data;
	 
     public int getData(){
        return data;
     }
	 
    public void setData(int i){
	   this.data = i;
	   //只有在setChange()被调用后，notifyObservers()才会去调用update()，否则什么都不干。
	   setChanged();
	   
       notifyObservers(SimpleObserver.class);
    }
}
