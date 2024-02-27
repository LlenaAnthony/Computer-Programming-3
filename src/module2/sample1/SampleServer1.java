package module2.sample1;

import java.io.BufferedReader;
import java.io.StringReader;
import java.net.ServerSocket;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class SampleServer1 {
    public static void main(String[] args) {
        int port = 2000;
        try (
               ServerSocket serverSocket = new ServerSocket (port);
               Socket clientSocket = serverSocket.accept();

               BufferedReader streamRdr = new BufferedReader(
                       new InputStreamReader(clientSocket.getInputStream())
               );

               PrintWriter streamWtr = new PrintWriter(
                       clientSocket.getOutputStream(), true)



        ){

            // server send
            streamWtr.println("What is your name?  "); // 1

            // server accepts input from client
            String name = streamRdr.readLine(); // 2
            int age;
            while (true) {
                streamWtr.println("What is your age? ");
                try {
                    age = Integer.parseInt(streamRdr.readLine());
                    if (age <= 0) {
                        throw new NumberFormatException();
                    } else {
                        break;
                    }
                }  catch (NumberFormatException nfe) {
                    // print method will auto flush
                    streamWtr.println("Please enter a valid age.");
                    continue;
                }
            }

            if(age >= 18){
                streamWtr.print(name + ", you may now exercise your right to vote!");
            } else {
                streamWtr.println(name + ", you are still young to vote! ");
            }
            streamWtr.println("Thank you and good day! ");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
