package module3.rmi;

import java.awt.image.SampleModel;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 2000);
            SampleRemote remote = (SampleRemote) registry.lookup("samplermi");

            String test = "supercalifragilisticexpialidocious";
            System.out.println("\" " + test + "\": " +remote.countCharacters(test));
        } catch (RemoteException | NotBoundException exc){
            exc.printStackTrace();
        }
    }
}
