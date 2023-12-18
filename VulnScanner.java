import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class VulnScanner{
    public static void main(String[] args) {
        String websiteUrl = ""; // Replace with your website URL

        try {
            URL url = new URL(websiteUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder content = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
                reader.close();

                // Perform vulnerability analysis on the website content
                analyzeWebsiteContent(content.toString());
            } else {
                System.out.println("Website is not accessible. Vulnerability may exist.");
            }

            connection.disconnect();
        } catch (IOException e) {
            System.out.println("An error occurred while checking the website: " + e.getMessage());
        }
    }

    private static void analyzeWebsiteContent(String websiteContent) {
       
      

        // Dummy analysis - checking for the presence of the word "vulnerable" in the website content
        if (websiteContent.contains("vulnerable")) {
            System.out.println("Potential vulnerability found: 'vulnerable' keyword detected in the website content.");
        } else {
            System.out.println("No vulnerabilities found in the website content.");
        }
    }
}