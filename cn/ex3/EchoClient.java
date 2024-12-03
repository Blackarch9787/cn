import java.io.*;
import java.net.*;
public class EchoClient {
public static void main(String[] args) {
String host = "localhost";
int port = 3231;
try (Socket socket = new Socket(host, port);
BufferedReader in = new BufferedReader(new
InputStreamReader(socket.getInputStream()));
PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
BufferedReader consoleIn = new BufferedReader(new
InputStreamReader(System.in))) {
System.out.println("Connected to echo server on " + host + ":" + port);
String userInput;
while ((userInput = consoleIn.readLine()) != null) {
out.println(userInput);
System.out.println("Server replied: " + in.readLine());
}} catch (IOException e) {
e.printStackTrace();
}
}
}