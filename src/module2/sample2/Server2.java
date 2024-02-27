package module2.sample2;

 import java.net.*;
 import java.io.*;
public class Server2 {
    public static void main(String[] args) {
        try(
                ServerSocket clientConnection = new ServerSocket(2001);
                Socket clientSocket = clientConnection.accept();

                ObjectInputStream reade = new ObjectInputStream(
                        clientSocket.getInputStream());

                ObjectOutputStream  writer = new ObjectOutputStream(
                        clientSocket.getOutputStream());

        ){

        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
