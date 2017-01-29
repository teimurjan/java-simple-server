import java.util.ArrayList;
import java.util.HashMap;

public class Router {

    private Route[] routes;

    public Router(Route[] routes){
        this.routes = routes;
    }

    public String getRoute(Request request) {
        for (Route route : routes) {
            if (route.getMethod().equals(request.getMethod()) &&
                    route.getPath().equals(request.getPath())) {
                return route.getController();
            }
        }
        return "get404Error";
    }
}
