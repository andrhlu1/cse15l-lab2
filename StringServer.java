import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class StringHandler implements URLHandler {
    private final ArrayList<String> messages = new ArrayList<>();

    @Override
    public String handleRequest(URI url) {
        if (url.getPath().equals("/add-message")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters.length == 2 && parameters[0].equals("s")) {
                messages.add(String.format("%d. %s", messages.size() + 1, parameters[1]));
                return String.join("\n", messages);
            }
            return "Invalid request!";
        } else {
            return "404 Not Found!";
        }
    }
}

public class StringServer {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new StringHandler());
    }
}
