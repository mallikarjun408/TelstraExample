package example.telstra.com.listjson;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.telstra.com.listjson.Adapters.MyRecyclerViewAdapter;
import example.telstra.com.listjson.Models.ListModel;
import example.telstra.com.listjson.ViewModels.ListViewModel;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview) RecyclerView recyclerView;
    @BindView(R.id.txtEmptyList) TextView txtEmptyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ListViewModel model = ViewModelProviders.of(this).get(ListViewModel.class);

        model.getList().observe(this, new Observer<ListModel>() {
            @Override
            public void onChanged(@Nullable ListModel mList) {
                if( mList.getRows() !=  null){
                    txtEmptyList.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(MainActivity.this, mList.getRows());
                    recyclerView.setAdapter(adapter);
                } else {
                    txtEmptyList.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                }

            }
        });
    }
}
