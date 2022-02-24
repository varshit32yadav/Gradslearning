package academy.learnprograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//private and un-interrupted connection for each client
public class Echoer extends Thread{
    private Socket socket;
    public Echoer(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        try{
            //streams to send and receive data from the client.
            System.out.println("Client Connected");
            BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
            String echoString=input.readLine();
            while(!echoString.equals("exit")){
                output.println("echoed from the server: "+echoString);
            }
        }catch(IOException e){
            System.out.println("OOPS :"+e.getMessage());
        }
        finally{
            try {
                socket.close(); //closing the resources is very important
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
