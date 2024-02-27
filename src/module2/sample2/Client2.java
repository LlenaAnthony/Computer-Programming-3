package module2.sample2;

import java.io.*;
import java.net.*;

public class Client2 {
    public static void main(String[] args) {
        int port = 2000;
        try (
                InputStreamReader fileRdr = new InputStreamReader(
                        new FileInputStream("res/rrer"));

                Socket connection = new Socket("localhost", 2001);

                ObjectInputStream streamRdr = new ObjectInputStream(
                        connection.getInputStream());

                ObjectOutputStream streamWtr = new ObjectOutputStream(
                        connection.getOutputStream());
        ){

        } catch (Exception e){
                    e.printStackTrace();
        }
    }
}
