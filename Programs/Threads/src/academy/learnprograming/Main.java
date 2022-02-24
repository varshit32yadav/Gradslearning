package academy.learnprograming;

import static academy.learnprograming.ThreadColour.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(ANSI_PURPLE+"Hello from the main thread ");
        Thread anotherThread=new AnotherThread();
        anotherThread.setName("Varshit ka thread");
        anotherThread.start(); //run() can't be used directly as main thread is running here so main will run.
        new Thread(){   //creating the anonymous class
            @Override
            public void run() {
                System.out.println(ANSI_RED+"Hello from the anonymous class");
            }
        }.start();
//        MyRunnable myrunnable=new MyRunnable();
//        myrunnable.run();
        Thread myrunnable=new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println(ANSI_GREEN+"Hello from Runnable class from anonymous Runnable class");
                try {
                    anotherThread.join(1000);//join till 1 sec then execute next thread.
                    System.out.println(ANSI_GREEN+""+anotherThread.getName()+" is finished executing now run Runnable class");
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    System.out.println(ANSI_GREEN+"I could not wait after all, I was interrupted");
                }
            }
        });
        myrunnable.start();
        //anotherThread.interrupt();
        System.out.println(ANSI_PURPLE+"Hello again from the main thread");
    }
}
