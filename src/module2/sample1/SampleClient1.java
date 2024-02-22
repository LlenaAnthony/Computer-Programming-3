package module2.sample1;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.Socket;
import java.util.Scanner;
public class SampleClient1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int port = 2000;

        try (
                Socket socket = new Socket("localhost", 2000);
                BufferedReader streamRdr = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter streamWtr = new PrintWriter(
                        socket.getOutputStream(), true);
        ) {
            // read and print message from server
            System.out.println(streamRdr.readLine()); // 1
            String input = keyboard.nextLine();

            // send input to the server
            streamWtr.println(input); // 2

            // read and print message from the server
            System.out.println(streamRdr.readLine());
            input = keyboard.nextLine();

            streamWtr.println(input);

            System.out.println(streamRdr.readLine());
            System.out.println(streamRdr.readLine());

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}