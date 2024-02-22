package module3;

import java.rmi.RemoteException;
import java.rmi.Remote;

public interface SampleRemote extends Remote{
    int countCharacters (String value) throws RemoteException;
}
