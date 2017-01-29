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

    public HashMap<String, String> getIndexRoute() {
        final HashMap<String, String> route = new HashMap<String, String>();
        route.put("method", "GET");
        route.put("path", "/");
        route.put("route", "getIndex");
        return route;
    }

    public HashMap<String, String> getAboutRoute() {
        final HashMap<String, String> route = new HashMap<String, String>();
        route.put("method", "GET");
        route.put("path", "/about");
        route.put("route", "getAbout");
        return route;
    }

    public ArrayList<HashMap<String, String>> getRoutes() {
        final ArrayList<HashMap<String, String>> routes = new ArrayList<HashMap<String, String>>();
        routes.add(this.getIndexRoute());
        routes.add(this.getAboutRoute());
        return routes;
    }
}
