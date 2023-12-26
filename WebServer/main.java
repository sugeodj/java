// main.java

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class main {
  public static void main(String[] args) {
        try {
            // Create an HTTP server that listens on port 8080
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

            // Create a context for the root path ("/") and set a handler
            server.createContext("/", new MyHandler());

            // Enable the server
            server.setExecutor(null); // creates a default executor
            server.start();

            System.out.println("Server is listening on port 8080...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  static class MyHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange t) throws IOException {
      // Create a response string
      String response = "Hello, world!";

      // Set the response headers
      t.getResponseHeaders().set("Content-Type", "text/plain");
      t.getResponseHeaders().set("Content-Length", Integer.toString(response.length()));

      // Send the response
      t.sendResponseHeaders(200, response.length());

      // Write the response to the output stream
      OutputStream os = t.getResponseBody();
      os.write(response.getBytes());

      // Close the output stream
      os.close();
    }
  }
}
