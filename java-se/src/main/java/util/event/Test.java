package util.event;

public class Test {
	 @SuppressWarnings("unused")
	public static void main(String[] args) {
		  SimpleObservable doc = new SimpleObservable ();
	      SimpleObserver view = new SimpleObserver (doc);
	      
	      doc.setData(1);
	    }	
}
