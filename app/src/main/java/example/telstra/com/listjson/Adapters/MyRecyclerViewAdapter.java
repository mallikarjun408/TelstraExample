package example.telstra.com.listjson.Adapters;

import android.app.LauncherActivity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.telstra.com.listjson.Models.ListModel;
import example.telstra.com.listjson.Models.Rows;
import example.telstra.com.listjson.R;

/**
 * Created by MALLIKARJUN on 1/8/2019.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ListViewHolder> {

    Context mCtx;
    List<Rows> mList;

    public MyRecyclerViewAdapter(Context mCtx, List<Rows> rowList) {
        this.mCtx = mCtx;
        this.mList = rowList;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Rows row = mList.get(position);

        Glide.with(mCtx)
                .load(row.getImgHref())
                .into(holder.img_imgHref);

        holder.txt_title.setText(row.getTitle());
        holder.txt_desc.setText(row.getDesc());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_imgHref)
        ImageView img_imgHref;

        @BindView(R.id.txt_title)
        TextView txt_title;

        @BindView(R.id.txt_desc)
        TextView txt_desc;

        public ListViewHolder(View itemView) {
            super(itemView);

           /* img_imgHref = itemView.findViewById(R.id.img_imgHref);
            txt_title = itemView.findViewById(R.id.txt_title);
            txt_desc = itemView.findViewById(R.id.txt_desc);*/

            ButterKnife.bind(this,itemView);
        }
    }
}

