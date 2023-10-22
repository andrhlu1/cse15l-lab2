import java.io.IOException;
import java.net.URI;

public class StringServer {

    private StringBuilder messages = new StringBuilder();
    private int messageCount = 0;

    public String handleRequest(URI url) {
        if (url.getPath().equals("/add-message")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                messageCount++;
                if (messages.length() > 0) {
                    messages.append("\n");
                }
                messages.append(messageCount).append(". ").append(parameters[1]);
                return messages.toString();
            } else {
                return "Invalid request!";
            }
        } else {
            return "404 Not Found!";
        }
    }

    public static void main(String[] args) {
        StringServer server = new StringServer();

        // Sample usage
        System.out.println(server.handleRequest(URI.create("/add-message?s=Hello")));
        System.out.println(server.handleRequest(URI.create("/add-message?s=How are you")));
    }
}
