# Java RMI (Remote Method Invocation)

## Objective
Develop a Java program using Remote Method Invocation.

## Client-Server Interaction Overview
In a client-server application, the following processes typically occur:

### Server Side (prior to client connection):
- Programmatically starts the server.
- Waits perpetually for an incoming connection.

### Client Side (prior to data being received by the server):
- Collects data (GUI, file, console, etc.).
- References a class representing the collected data.
- Populates the object using the collected data.
- Transforms the object into "streamable data" (usually a string of characters).
- Programmatically connects to the server.
- Gets the output stream.
- Sends the object to the server via the output stream.

### Server Side (when a client connects to the server):
- Allows connection from clients.
- Gets the input stream.
- Accepts a string from the client using the input stream.
- Parses the accepted string.
- References a class representing the collected data.
- Populates the object using the collected data.
- Saves the object in the database.
- Gets the output stream.
- Sends a response to the client.

### Client Side (upon receiving a response from the server):
- Gets the input stream.
- Parses the collected text.
- Executes confirmation.

## Distributed Systems Overview
A distributed system is a combination of computers linked over a network, capable of running an application.

### Remote Procedure Call (RPC)
- First successful distributed technology.
- **Disadvantages:**
    - Not object-oriented.
    - Limited data types.
    - Requires learning a special Interface Definition Language (IDL).

## Distributed Programming in Java
Developers using the Java programming language can choose various solutions for creating distributed applications:
- Java RMI technology
- Java IDL technology
- Enterprise JavaBeans technology (not covered)
- Web services

## Java RMI Process
1. Create an interface shared by both the client and the server.
2. Create a server implementing the interface.
3. Start `rmiregistry` – the proxy.
4. Run the server, ensuring it binds the object to the registry.
5. Create a client getting the method implementation from the registry.

## Sample Program 1
Create a method that will be invoked remotely. This method shall accept a string value as a parameter and return the number of characters in the string.

### Steps to Create the RMI Server:
1. Create/design an interface extending the Remote interface.
2. Create a class implementing the interface.
3. In the main method:
    - Create an instance of the class.
    - Create a registry class and start/create a running registry.
    - Register the instance of the class to the registry using a unique name.

```java
// Interface Definition
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SampleRemote extends Remote {
    int countCharacters(String value) throws RemoteException;
}

// Server Implementation
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer extends UnicastRemoteObject implements SampleRemote {
    public RMIServer() throws RemoteException {}

    @Override
    public int countCharacters(String value) throws RemoteException {
        return value.length();
    }

    public static void main(String[] args) {
        try {
            SampleRemote stub = new RMIServer();
            Registry reg = LocateRegistry.createRegistry(10000);
            reg.rebind("samplermi", stub);
            System.out.println("Sample RMI bound");
        } catch (RemoteException exc) {
            exc.printStackTrace();
        }
    }
}
