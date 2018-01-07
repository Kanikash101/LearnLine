package spark.planet.com.learnline.model;

/*
 * using it for storing the url and type of the media content
 * type can be of 3 types : PHOTO, VIDEO and WEBVIEW
 *
 * Created by Sony on 1/6/2018.
 */

public class LearnLineMediaModel {

    private String url;
    private String type;

    public LearnLineMediaModel(String url, String type) {
        this.url = url;
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
