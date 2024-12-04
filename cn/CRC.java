import java.util.Arrays;
public class CRC {
 public static void main(String[] args) {
 String[] dataSet = {"1101011011", "1011101", "111000111", "1101011010", 
"0111110101"};
 String generator = "10011";
 System.out.println("CRC Error Detection Simulation\n");
 System.out.println("Generator Polynomial: " + generator + "\n");
 for (String data : dataSet) {
 String encodedData = encodeData(data, generator);
 System.out.println("Original Data: " + data);
 System.out.println("Encoded Data: " + encodedData + "\n");
 }
 }
 // Function to perform XOR operation
 static String xor(String a, String b) {
 StringBuilder result = new StringBuilder();
for (int i = 1; i < b.length(); i++) {
 if (a.charAt(i) == b.charAt(i))
 result.append("0");
 else
 result.append("1");
 }
 return result.toString();
 }
 // Function to perform Modulo-2 division
 static String mod2div(String dividend, String divisor) {
 int pick = divisor.length();
 String tmp = dividend.substring(0, pick);
 int n = dividend.length();
 while (pick < n) {
 if (tmp.charAt(0) == '1')
 tmp = xor(divisor, tmp) + dividend.charAt(pick);
 else
 tmp = xor("0".repeat(pick), tmp) + dividend.charAt(pick);
 pick += 1;
 }
 if (tmp.charAt(0) == '1')
 tmp = xor(divisor, tmp);
 else
 tmp = xor("0".repeat(pick), tmp);
 return tmp;
 }
 // Function to encode data using CRC
 static String encodeData(String data, String generator) {
 int dataLen = data.length();
 int generatorLen = generator.length();
 String appendedData = data + "0".repeat(generatorLen - 1);
 String remainder = mod2div(appendedData, generator);
 return data + remainder;
 }
}