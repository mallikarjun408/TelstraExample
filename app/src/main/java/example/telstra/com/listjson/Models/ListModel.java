package example.telstra.com.listjson.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MALLIKARJUN on 1/8/2019.
 */

public class ListModel {



    @SerializedName("title")
    private String title;

    @SerializedName("results")
    private List<Rows> rows;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Rows> getRows() {
        return rows;
    }

    public void setRows(List<Rows> rows) {
        this.rows = rows;
    }


}
