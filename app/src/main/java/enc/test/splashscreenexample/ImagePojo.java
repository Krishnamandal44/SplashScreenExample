package enc.test.splashscreenexample;

/**
 * Created by Admin on 29-07-2017.
 */

public class ImagePojo {
    String icon;
    String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {

        return id;
    }

    String title;

    public ImagePojo(String id, String title, String icon) {
        this.id = id;
        this.icon = icon;
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
