package module3.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer extends UnicastRemoteObject implements  SampleRemote{
    public RMIServer() throws RemoteException{}

    @Override
    public int countCharacters(String value) throws RemoteException{
        return value.length();
    }

    public static void main (String[]args){
        try{
            SampleRemote stub = new RMIServer();
            Registry reg = LocateRegistry.createRegistry(2000);
            reg.rebind("samplermi", stub);
            System.out.println("Sample RMI bound");
        } catch (RemoteException exc){
            exc.printStackTrace();
        }
    }

}
