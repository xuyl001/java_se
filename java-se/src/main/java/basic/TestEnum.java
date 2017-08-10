package basic;

/**
 * 枚举的定义和使用
 */
public class TestEnum {

	/** 定义枚举 */
	 public enum Size {
	        SMALL("S"), //调用构造器 每个枚举值都要调用构造器
	        MEDIUM("M"),
	        LARGE("L"),
	        EXTRA_LARGE("XL");
		 
		 	//定义 构造器 访问修饰符要么不写，要么是私有的
	        private Size(String abb2)  {
	            this.abb = abb2;
	        }
	        
	       //定义私有字段 
	        private String abb;
	        public String getAbb() {
	            return this.abb;
	        }
	    }
	 
	    public static void main(String[] args){
	    /*	
	    	//1.第一种方式获取枚举变量
	        Size s = Size.SMALL;
	        System.out.println(s);//输出：SMALL 
	        System.out.println(Size.SMALL.getAbb()); //输出SMALL的值S
	     */	  
	    	
	      /*
	        //2.第二种方式获取枚举变量
	        Size s2 = Enum.valueOf(Size.class,"MEDIUM");//获取变量:MEDIUM
	        System.out.println(s2);
	      */
	    	
	      /*	
	        //3.获取所有枚举变量
	        Size[] values = Size.values();//获取所有的变量
	        System.out.println(values[0]);//输出：SMALL
	     */
	        
	    	TestSwith small = new TestSwith(Size.SMALL);
	    	small.displaySeason();
	    }
}

class TestSwith{
	private TestEnum.Size size;
    
    public TestSwith(TestEnum.Size size)  {
        this.size = size;  
    }  
    
    public void displaySeason()  
    {  
        switch (size) {  
        case SMALL:  
             System.out.println("春天花会开");  
            break;  
        default:  
            break;  
        }  
    }  
    
}	 




