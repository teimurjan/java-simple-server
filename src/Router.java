import java.util.ArrayList;
import java.util.HashMap;

public class Router {

    private ArrayList<HashMap<String, String>> routes;

    public Router(ArrayList<HashMap<String, String>> routes){
        this.routes = routes;
    }

    public String getRoute(Request request) {
        for (HashMap<String, String> route : routes) {
            if (route.get("method").equals(request.getMethod()) &&
                    route.get("path").equals(request.getPath())) {
                return route.get("route");
            }
        }
        return "get404Error";
    }
}
