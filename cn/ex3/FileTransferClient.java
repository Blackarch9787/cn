import java.io.*;
import java.net.*;
public class FileTransferClient {
public static void main(String[] args) {
String host = "localhost";
int port = 5555;
String filePath = ""; // Update with correct path
try (Socket socket = new Socket(host, port);
FileInputStream fileIn = new FileInputStream(filePath);
OutputStream out = socket.getOutputStream()) {
byte[] buffer = new byte[4096];
int bytesRead;
while ((bytesRead = fileIn.read(buffer)) != -1) {
out.write(buffer, 0, bytesRead);
}
System.out.println("File sent successfully.");
} catch (IOException e) {
e.printStackTrace();
}
}
}