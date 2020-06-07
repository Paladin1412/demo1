package thread.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test06 {
    Integer i = new Integer(0);

    public void add0() {
        i += 1;
    }

    public void add1() {
        i += 1;
    }

    public static void main(String[] args) throws ParseException {
//        Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("1996/11/01 11:12:13");
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        int i = calendar.get(Calendar.MONTH);
//        System.out.println(calendar.get(Calendar.YEAR));
//        System.out.println(calendar.get(Calendar.MONTH)+1);
//        System.out.println(calendar.get(Calendar.DATE));
//        System.out.println(calendar.get(Calendar.HOUR));
//        System.out.println(calendar.get(Calendar.MINUTE));
//        System.out.println(calendar.get(Calendar.SECOND));

        byte[] bytes = new byte[2 * 1024 * 1024];
        System.out.println("-Xmx:" + Runtime.getRuntime().maxMemory() / 1024.0 / 1024.0 / 1024.0);
        System.out.println("-Xms:" + Runtime.getRuntime().totalMemory() / 1024 / 1024);

        System.out.println();
        Test06 test06 = new Test06();
        new Thread(new Thread01(test06)).start();
        new Thread(new Thread02(test06)).start();
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(test06.i);
    }

}
