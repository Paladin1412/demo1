package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test05 {

    public static void main(String[] args) {
        String time1 = "2020-03-01 22:35:47";
        String time2 = "2020-04-28 10:47:23";
        String time3 = "2020-03-28 10:47:23";
        System.out.println();
        System.out.println(time1 + "\n" + time2);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date date1 = format.parse(time1);
            Date date2 = format.parse(time2);
            Date date3 = format.parse(time3);
            System.out.println(date2.getTime()==date3.getTime());
            Long l = date2.getTime() - date1.getTime();
            int day = (int) (l / (1000 * 60 * 60 * 24));
            System.out.println(day);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }













//    volatile
   int a = 10;
     static int s = 10;
     public void setA(int a){
         this.a = a;
     }

    public static void main1(String[] args) {
        long l = System.currentTimeMillis();
        List<Test05> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Test05());
        }
        list.forEach(test05 -> {
            test05.setA(1);
        });
        long l1 = System.currentTimeMillis();

        System.out.println(l1-l);


    }

//    public static void main(String[] args) throws Exception {
//        byte[] bytes = new byte[1024 * 1024 * 2];
//        System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024);
//        System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
//        Test05 test05 = new Test05();
//        new Thread(() -> {
//            try {
//                Thread.sleep(1000);
//                test05.a = 11;
//                s = 11;
//                System.out.println("s be updated");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        while (s==10){
//        }
//        System.out.println("stop");
//
//
//    }
}
