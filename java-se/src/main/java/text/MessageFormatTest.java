package text;

import org.junit.Test;

import java.text.MessageFormat;

/**
 * Created by conglin.liu on 2017/6/23.
 */
public class MessageFormatTest {

    @Test
    public void test01() {
        String str = "{0}{1}C";
        Object[] array = new Object[]{"A","B"};
        String value = MessageFormat.format(str, array);
        System.out.println(value); // ABCDEFGHIJKLMNOPQ
    }

    /**
     * 单引号问题
     */
    @Test
    public void test02() {
        String str = " ''{0}'' {1}C";
        Object[] array = new Object[]{"A","B"};
        String value = MessageFormat.format(str, array);
        System.out.println(value); // ABCDEFGHIJKLMNOPQ
    }

}
