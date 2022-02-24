package academy.learnprograming;

import static academy.learnprograming.ThreadColour.ANSI_BLUE;

public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ANSI_BLUE+ "Hello from "+ currentThread().getName());  //current thread jo run kar rhi hai uska name ayga
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
            System.out.println(ANSI_BLUE+"Thread has slept, woke me up");
            return;
        }
        System.out.println(ANSI_BLUE+ "Hello from "+ currentThread().getName()+" has been awake from the sleep");

     }
}
