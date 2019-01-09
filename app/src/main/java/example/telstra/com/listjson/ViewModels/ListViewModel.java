package example.telstra.com.listjson.ViewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.List;

import example.telstra.com.listjson.Api;
import example.telstra.com.listjson.Constants.Constants;
import example.telstra.com.listjson.Models.ListModel;
import example.telstra.com.listjson.Models.Rows;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MALLIKARJUN on 1/8/2019.
 */


public class ListViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
    private MutableLiveData<ListModel> mList;

    //we will call this method to get the data
    public LiveData<ListModel> getList() {
        //if the list is null
        if (mList == null) {
            mList = new MutableLiveData<ListModel>();
            //we will load it asynchronously from server in this method
            loadListfromURL();
        }
        //finally we will return the list
        return mList;
    }


    //This method is using Retrofit to get the JSON data from URL
    private void loadListfromURL() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<ListModel>call = api.getList();


        call.enqueue(new Callback<ListModel>() {
            @Override
            public void onResponse(Call<ListModel> call, Response<ListModel> response) {

                //finally we are setting the list to our MutableLiveData
                // List<Rows> Rows =response.body().getRows();

                mList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ListModel> call, Throwable t) {
                Log.i("","");
            }
        });
    }
}