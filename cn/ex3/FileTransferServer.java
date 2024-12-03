import java.io.*;
import java.net.*;
public class FileTransferServer {
public static void main(String[] args) {
int port = 5555;
try (ServerSocket serverSocket = new ServerSocket(port)) {
System.out.println("File Transfer Server started on port " + port);
while (true) {
try (Socket clientSocket = serverSocket.accept();
InputStream in = clientSocket.getInputStream();
FileOutputStream fileOut = new FileOutputStream("received_")){
byte[] buffer = new byte[4096];
int bytesRead;
while ((bytesRead = in.read(buffer)) != -1) {
fileOut.write(buffer, 0, bytesRead);
}
System.out.println("File received and saved as 'received_file.txt'");
}
}
} catch (IOException e) {
e.printStackTrace();
}
}
}