/**
 * Created by teimur on 1/29/17.
 */
public class Route {

    private String method;
    private String path;
    private String controller;

    public Route(String method, String path, String controller){
        this.method = method;
        this.path = path;
        this.controller = controller;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }
}
