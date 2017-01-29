import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

public class SocketProcessor implements Runnable{
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private Settings settings;

    public SocketProcessor(Socket socket) throws IOException {
        this.socket = socket;
        this.inputStream = socket.getInputStream();
        this.outputStream = socket.getOutputStream();
        this.settings = new Settings();
    }

    public void run() {
        try {
            Request request = getRequest();
            String response = getResponse(request);
            sendResponse(response);

        } catch (Throwable t) {
        } finally {
            try {
                socket.close();
            } catch (Throwable t) {
            }
        }
        System.err.println("Client processing finished");
    }

    private void sendResponse(String responseBody) {
        String responseHeaders = this.settings.getResponseHeaders(responseBody.length());
        String response = responseHeaders + responseBody;
        try {
            outputStream.write(response.getBytes());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getResponse(Request request) throws NoSuchMethodException{
        String response = "";
        Router router = new Router(this.settings.getRoutes());
        Controllers controllers = new Controllers();
        Class controllersClass = controllers.getClass();

        Method method = controllersClass.getDeclaredMethod(router.getRoute(request));

        try {
            response = (String) method.invoke(controllersClass.newInstance());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return response;
    }

    private Request getRequest() throws IOException{
        SocketRequestReceiver requestReceiver = new SocketRequestReceiver(this.inputStream);
        requestReceiver.receiveRequest();
        RequestBuilder requestBuilder = new RequestBuilder(requestReceiver.getRequestStartLine(),
                requestReceiver.getRequestHeaders(), requestReceiver.getRequestBody());
        requestBuilder.build();
        return requestBuilder.getRequest();
    }

}
