package lang.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 运用时获取注解 : 基类
 */
public class Parent<T> {  
	  
    private Class<T> entity;  
  
    public Parent() {  
        init();  
    }  
  
    @SuppressWarnings("unchecked")  
    public List<SortableField> init(){  
        List<SortableField> list = new ArrayList<SortableField>();  
        /**getClass().getGenericSuperclass()返回表示此 Class 所表示的实体（类、接口、基本类型或 void的直接超类的 Type(Class<T>泛型中的类型)，然后将其转换ParameterizedType。。 
         *  
         *getActualTypeArguments()返回表示此类型实际类型参数的 Type 对象的数组, 就是获得超类的泛型参数的实际类型
         *   [0]就是这个数组中第一个了。。 
         *   
         */  
        entity = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass())  
                .getActualTypeArguments()[0];  
          
        if(this.entity!=null){  
              
            /**返回类中所有字段，包括公共、保护、默认（包）访问和私有字段，但不包括继承的字段 
             * 
             * entity.getFields();只返回对象所表示的类或接口的所有可访问公共字段 
             * 可看API 
             */  
            Field[] fields = entity.getDeclaredFields();
            
            for(Field f : fields){  
                //获取字段中包含fieldMeta的注解  
                FieldMeta meta = f.getAnnotation(FieldMeta.class);  
                if(meta!=null){  
                    SortableField sf = new SortableField(meta, f);  
                    list.add(sf);  
                }  
            }  
              
            //返回对象所表示的类或接口的所有可访问公共方法  
            Method[] methods = entity.getMethods();  
              
            for(Method m:methods){  
                FieldMeta meta = m.getAnnotation(FieldMeta.class);  
                if(meta!=null){  
                    SortableField sf = new SortableField(meta,m.getName(),m.getReturnType());  
                    list.add(sf);  
                }  
            }  
            
            //第二个参数是: Comparator接口类型，重写compare方法实现排序  
            Collections.sort(list, new Comparator<SortableField>() {  
                public int compare(SortableField s1,SortableField s2) {  
                    return s1.getMeta().order()-s2.getMeta().order();  
//                  return s1.getName().compareTo(s2.getName());//也可以用compare来比较  
                }  
                  
            });  
        }  
        return list;  
          
    }  
}  
