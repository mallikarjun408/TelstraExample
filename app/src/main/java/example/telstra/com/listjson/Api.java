package example.telstra.com.listjson;

import java.util.List;

import example.telstra.com.listjson.Models.ListModel;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by MALLIKARJUN on 1/8/2019.
 */

public interface Api {

    @GET("2iodh4vg0eortkl/facts")
    Call<ListModel> getList();
}