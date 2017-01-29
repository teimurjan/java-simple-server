import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Controllers {

    private Settings settings;

    public Controllers(){
        this.settings = new Settings();
    }

    public String getIndex() throws IOException {
        return this.getFileByPath(this.settings.PATH_TO_INDEX_PAGE);
    }

    public String getAbout() throws IOException {
        return this.getFileByPath(this.settings.PATH_TO_ABOUT_PAGE);
    }

    public String get404Error() throws IOException {
        return this.getFileByPath(this.settings.PATH_TO_404_ERROR_PAGE);
    }

    public String getFileByPath(String path) throws IOException{
        FileReader fr=new FileReader(path);
        BufferedReader br= new BufferedReader(fr);
        StringBuilder content=new StringBuilder(1024);
        String s;
        while((s=br.readLine())!=null)
        {
            content.append(s);
        }
        return content.toString();
    }

}
