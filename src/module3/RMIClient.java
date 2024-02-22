package module3;

import java.awt.image.SampleModel;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.getRegistry("localhost" ,10000);
            SampleRemote remote = (SampleRemote) registry.lookup("samplermi");

            String test = "The quick brown fox jumps over the lazy dog. ";
            System.out.println("\""+test+"\" : " +remote.countCharacters(test));
        } catch (RemoteException | NotBoundException exc){
            exc.printStackTrace();
        }
    }
}
