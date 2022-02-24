package academy.learnprograming;

import static academy.learnprograming.ThreadColour.ANSI_GREEN;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(ANSI_GREEN+"Hello from Runnable class");
    }
}
