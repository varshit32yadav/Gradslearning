package academy.learnprograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try(Socket socket=new Socket("localhost",5000)){ //port number should be same on which server is listening at
            //streams to send and receive data from the client.
            try{
                socket.setSoTimeout(5000);//in realtime, if socket doesn't respond within this time then connection with server is closed.
                BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
                Scanner sc=new Scanner(System.in);
                String echoString;
                String response;

                do{
                    System.out.println("Enter the String to be echoed");
                    echoString=sc.nextLine();
                    output.println(echoString);
                    if(!echoString.equals("exit")){
                        response=input.readLine();
                        System.out.println(response);
                    }
                }while(!echoString.equals("exit"));
            }catch(SocketTimeoutException e){
                System.out.println(e.getMessage());
            }
        }catch(IOException e){
            System.out.println("Client Exception"+e.getMessage());
            e.printStackTrace();
        }
    }
}
