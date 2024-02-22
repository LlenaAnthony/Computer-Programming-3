package module3.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RemoteRef;

public interface SampleRemote extends Remote {
    int countCharacters (String value) throws RemoteException;
}
