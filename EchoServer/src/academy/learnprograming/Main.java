package academy.learnprograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;//socket for server
import java.net.Socket;//socket for client

public class Main {

    public static void main(String[] args) {

        try(ServerSocket serverSocket=new ServerSocket(5000)) {  //[0-65535] range of port number
            while(true){ //so that multiple clients can access the same server.
                Echoer e1=new Echoer(serverSocket.accept());
                e1.start();
            }//now server will always be up and working as needed in realtime.you can terminate it manually
        }catch (IOException e){
            System.out.println("Server Exception"+e.getMessage());
            e.printStackTrace();
        }

    }
}
