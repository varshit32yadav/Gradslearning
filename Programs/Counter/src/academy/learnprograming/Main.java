package academy.learnprograming;

import static academy.learnprograming.ThreadColour.*;

public class Main {
    public static void main(String[] args) {
	// write your code here
        Countdown countdown=new Countdown();
        CountdownThread t1=new CountdownThread(countdown);
        CountdownThread t2=new CountdownThread(countdown);
        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t1.start();
        t2.start();
    }
}
//Multiple thread Concept: when multiple threads are running any thread can be exceuted at anytime.
//run the code everytime you  will get the different output.
class Countdown{
    int i;//making i global variable.Hence, it will be stored in heap memory which is shared by the threads.
    //if one thread has executed a value if i then other thread can not have that same value of i.

    public void doCountDown(){ //using synchronized keyword so that each thread can access the resources independently(by adding synchronized keyword we are allowing whole method to run before another thread can take the access.
                                            //  So thread 1 will run the method completely and then thread 2 will run)
      String color;
      switch(Thread.currentThread().getName()){
          case "Thread 1":
              color=ANSI_CYAN;break;
          case "Thread 2":
              color=ANSI_PURPLE;break;
          default:
              color=ANSI_GREEN;break;
        }
        synchronized (this){
            for (i = 0; i < 10; i++) {
                System.out.println(color + Thread.currentThread().getName() + ": i =" + i);
            }
        }
    }
}
class CountdownThread extends Thread{
    private Countdown threadCountdown;
    public CountdownThread(Countdown countdown){
        threadCountdown=countdown;
    }
    @Override
    public void run() {
        threadCountdown.doCountDown();
    }
}


