package com.guowei.android.presenter.adapter;

/**
 * Created by zhoug on 2016/8/21.
 */

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.guowei.android.R;
import com.guowei.android.base.BaseRecyclerViewAdapter;
import com.guowei.android.model.DesignBean;
import com.guowei.android.model.JavaBean;

import java.util.List;

import butterknife.Bind;

/**
 * Created by zhoug on 2016/8/21.
 */
public class StyleAdapter extends BaseRecyclerViewAdapter<DesignBean> {
    public StyleAdapter(List<DesignBean> datas) {
        super(datas);
    }

    public StyleAdapter() {
        super();
    }

    @Override
    protected BaseRecyclerViewHolder onCreate(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.testfragment, parent, false);
        return new AndroidHolder(view);
    }

    @Override
    protected void onBind(RecyclerView.ViewHolder holder, DesignBean data, int position) {
        if (holder instanceof AndroidHolder) {
            ((AndroidHolder) holder).setData(data);
        }
    }


    public class AndroidHolder extends BaseRecyclerViewHolder {
        @SuppressWarnings("unused")
        @Bind(R.id.item_image)
        ImageView imageView;
        @Bind(R.id.item_desc)
        TextView item_desc;
        @Bind(R.id.item_who)
        TextView item_who;
        @Bind(R.id.item_time)
        TextView item_time;
        @Bind(R.id.ll_rb_star)
        RatingBar ratingBar;
        public AndroidHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void setData(@NonNull DesignBean data) {
            super.setData(data);
            if (data.getArticle_name() != null) {
                item_desc.setText(data.getArticle_name());
            }
            if (data.getArticle_author() != null) {
                item_who.setText(data.getArticle_author());
            }
            if (data.getArticle_time() != null) {
                item_time.setText(data.getArticle_time());
            }
        }
    }
}


