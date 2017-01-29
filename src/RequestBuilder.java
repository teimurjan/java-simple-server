public class RequestBuilder {

    private String startLine;
    private String headers;
    private String body;
    private Request request;

    public RequestBuilder(String startLine, String headers, String body) {
        this.startLine = startLine;
        this.headers = headers;
        this.body = body;
        this.request = new Request();
    }

    public void build() {
        this.setStartLineAttributes();
        this.request.setHeaders(this.headers);
        this.request.setBody(this.body);
    }

    public Request getRequest(){
        return this.request;
    }

    public void setStartLineAttributes() {
        String[] parsedStartLine = this.startLine.split(" ");
        this.request.setMethod(parsedStartLine[0]);
        this.request.setPath(parsedStartLine[1]);
        this.request.setVersion(parsedStartLine[2]);
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setStartLine(String startLine) {
        this.startLine = startLine;
    }
}
