import java.io.*;
import java.net.*;
public class EchoServer {
public static void main(String[] args) {
int port = 3231;
try (ServerSocket serverSocket = new ServerSocket(port)) {
System.out.println("Echo Server started on port " + port);
while (true) {
try (Socket clientSocket = serverSocket.accept();
BufferedReader in = new BufferedReader(new
InputStreamReader(clientSocket.getInputStream()));
PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
String message;
while ((message = in.readLine()) != null) {
System.out.println("Received: " + message);
out.println("Echo: " + message);
}
}
}
} catch (IOException e) {
e.printStackTrace();
}
}
}