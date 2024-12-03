import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class SimpleDNSClient {
public static void main(String[] args) {
try {
String domain = "www.google.com";
InetAddress dnsServer = InetAddress.getByName("1.1.1.1");
byte[] dnsQuery = buildDnsQuery(domain);
DatagramSocket socket = new DatagramSocket();
DatagramPacket requestPacket = new DatagramPacket(dnsQuery, dnsQuery.length,
dnsServer, 53);
socket.send(requestPacket);
byte[] buffer = new byte[512];
DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
socket.receive(responsePacket);
socket.close();
System.out.println("Raw DNS response: ");
for (int i = 0; i < responsePacket.getLength(); i++) {
System.out.print(String.format("%02X ", buffer[i]));
}System.out.println();
} catch (Exception e) {
e.printStackTrace();
}
}
private static byte[] buildDnsQuery(String domain) throws Exception {
byte[] header = {
(byte) 0xAA, (byte) 0xAA,
(byte) 0x01, (byte) 0x00,
(byte) 0x00, (byte) 0x01,
(byte) 0x00, (byte) 0x00,
(byte) 0x00, (byte) 0x00,
(byte) 0x00, (byte) 0x00
};
byte[] question = new byte[domain.length() + 2 + 4];
String[] labels = domain.split("\\.");
int pos = 0;
for (String label : labels) {
question[pos++] = (byte) label.length();
for (char c : label.toCharArray()) {
question[pos++] = (byte) c;
}
}
question[pos++] = 0x00;
question[pos++] = 0x00; question[pos++] = 0x01;
question[pos++] = 0x00; question[pos++] = 0x01;
byte[] dnsRequest = new byte[header.length + question.length];
System.arraycopy(header, 0, dnsRequest, 0, header.length);
System.arraycopy(question, 0, dnsRequest, header.length, question.length);
return dnsRequest;
}
}