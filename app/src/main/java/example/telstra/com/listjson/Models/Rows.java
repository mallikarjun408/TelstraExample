package example.telstra.com.listjson.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by MALLIKARJUN on 1/8/2019.
 */

public class Rows {

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String desc;

    @SerializedName("imageHref")
    private String imgHref;

    public Rows(String title, String desc, String imgHref) {
        this.title = title;
        this.desc = desc;
        this.imgHref = imgHref;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {

        this.desc = desc;
    }

    public String getImgHref() {
        return imgHref;
    }

    public void setImgHref(String imgHref) {
        this.imgHref = imgHref;
    }


}
