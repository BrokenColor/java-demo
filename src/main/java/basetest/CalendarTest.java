package basetest;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author guwanli
 * @date 2022/9/28 15:07
 */
public class CalendarTest {

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));
    }
}
