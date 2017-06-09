package event;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者 : 被通知的人
 */
public class SimpleObserver implements Observer {
	 public SimpleObserver(SimpleObservable so){
	      so.addObserver(this );
	 }
	
	public void update(Observable o, Object arg) {
		   if(arg != null)  System.out.println(arg + "===" + o);
		   System.out.println("Data has changed to" + ((SimpleObservable) o).getData());
	}

}
