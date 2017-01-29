import java.util.ArrayList;
import java.util.HashMap;


public class Settings {
    public static final String PATH_TO_INDEX_PAGE = "/home/teimur/projects/java-simple-server/src/templates/index.html";
    public static final String PATH_TO_ABOUT_PAGE = "/home/teimur/projects/java-simple-server/src/templates/about.html";
    public static final String PATH_TO_404_ERROR_PAGE = "/home/teimur/projects/java-simple-server/src/templates/error_404.html";

    public static final String getResponseHeaders(int contentLength) {
        return "HTTP/1.1 200 OK\r\n" +
                "Server: TeimurServer\r\n" +
                "Content-Type: text/html\r\n" +
                "Content-Length: " + contentLength + "\r\n" +
                "Connection: close\r\n\r\n";
    }

    public static final Route[] routes = {
            new Route("GET", "/", "getIndex"),
            new Route("GET", "/about", "getAbout")};

}
