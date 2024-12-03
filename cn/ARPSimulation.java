import java.util.HashMap;
import java.util.Map;
public class ARPSimulation {
private static Map<String, String> arpTable = new HashMap<>();
static {
arpTable.put("192.168.1.1", "00:14:22:01:23:45");
arpTable.put("192.168.1.2", "00:14:22:01:23:46");
arpTable.put("192.168.1.3", "00:14:22:01:23:47");
}
public static void main(String[] args) {
String ipToResolve = "192.168.1.1";
String macToResolve = "00:14:22:01:23:47";
String macAddress = arpRequest(ipToResolve);
if (macAddress != null) {
System.out.println("ARP Response: IP " + ipToResolve + " is at MAC " +
macAddress);
} else {
System.out.println("ARP Response: IP " + ipToResolve + " is not found.");
}String ipAddress = rarpRequest(macToResolve);
if (ipAddress != null) {
System.out.println("RARP Response: MAC " + macToResolve + " is at IP " +
ipAddress);
} else {
System.out.println("RARP Response: MAC " + macToResolve + " is not found.");
}
}
private static String arpRequest(String ipAddress) {
return arpTable.get(ipAddress);
}
private static String rarpRequest(String macAddress) {
for (Map.Entry<String, String> entry : arpTable.entrySet()) {
if (entry.getValue().equals(macAddress)) {
return entry.getKey();
}
}
return null;
}
}