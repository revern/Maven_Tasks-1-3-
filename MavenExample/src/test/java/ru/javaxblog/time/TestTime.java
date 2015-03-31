package ru.javaxblog.time;

/**
 * Created by Алмаз on 16.03.2015.
 */
import static org.junit.Assert.*;

import org.junit.Test;
public class TestTime {
    @Test
    public void testMain() {
        String dt=new java.text.SimpleDateFormat(("hh:mm aaa")).format(java.util.Calendar.getInstance().getTime());
        assertNotNull(dt);
    }
}
