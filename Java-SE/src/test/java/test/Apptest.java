package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Apptest {
    @Test
    public void test04() {
        List<String> list = new ArrayList<String>();

        try {
            list.getClass().getMethod("add", Object.class).invoke(list, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
