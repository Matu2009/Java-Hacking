import java.net.InetAddress;
import java.net.UnknownHostException;


public class DomainInfo {
    public static void main(String[] args) {
        String domain = "example.com";

        try {
            InetAddress ipAddress = InetAddress.getByName(domain);

            System.out.println("Domain: " + domain);
            System.out.println("IP Address: " + ipAddress.getHostAddress());
            System.out.println("Canonical Hostname: " + ipAddress.getCanonicalHostName());
            System.out.println("Host Name: " + ipAddress.getHostName());
        } catch (UnknownHostException e) {
            System.out.println("Unable to resolve domain: " + domain);
        }
    }
}
