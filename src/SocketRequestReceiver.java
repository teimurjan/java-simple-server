import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SocketRequestReceiver {

    private String requestStartLine;
    private String requestHeaders;
    private String requestBody;
    private int requestBodyLength;
    private BufferedReader reader;

    public SocketRequestReceiver(InputStream inputStream) {
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
        this.requestStartLine = "";
        this.requestHeaders = "";
        this.requestBody = "";
        this.requestBodyLength = 0;
    }

    public void receiveRequest() throws IOException {
        this.receiveRequestStartLine();
        this.receiveRequestHeaders();
        if (this.requestBodyLength > 0) {
            this.receiveRequestBody();
        }
    }

    public void receiveRequestStartLine() throws IOException {
        this.requestStartLine = this.reader.readLine();
    }

    public void receiveRequestHeaders() throws IOException {
        String line;
        while ((line = this.reader.readLine()) != null) {
            if (line.isEmpty()) break;
            if (line.startsWith("Content-Length: "))
                this.requestBodyLength = Integer.parseInt(line.split(":")[1].trim());
            this.requestHeaders += line + "\n";
        }
    }

    public void receiveRequestBody() throws IOException {
        int chunk;
        while ((chunk = this.reader.read()) != -1) {
            this.requestBody += (char) chunk;
            if (this.requestBody.length() == this.requestBodyLength) break;
        }
    }

    public String getRequestStartLine() {
        return requestStartLine;
    }

    public void setRequestStartLine(String requestStartLine) {
        this.requestStartLine = requestStartLine;
    }

    public String getRequestHeaders() {
        return requestHeaders;
    }

    public void setRequestHeaders(String requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }
}
