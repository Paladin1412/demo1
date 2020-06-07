package thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTask(),0,1000);
    }
}
class MyTask extends TimerTask{
    @Override
    public void run() {
        System.out.println("TimerTask execute - "+new Date());
    }
}
