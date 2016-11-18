package com.guowei.android.base;

import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by zhoug on 2016/8/17.
 */
public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private boolean showFoot = false;
    static final int TYPE_ITEM = 0;
    static final int TYPE_FOOTER = 1;
    private List<T> mDatas = new LinkedList<>();
    private OnItemClickListener<T> mOnItemClickListener;

    public BaseRecyclerViewAdapter(List<T> datas) {
        if (datas != null) {
            mDatas = datas;
        }
    }
    public BaseRecyclerViewAdapter() {

    }

    public void addAll(List<T> datas) {
        mDatas.addAll(datas);
        this.notifyDataSetChanged();
    }

    public void addItemTop(List<T> datas) {
        mDatas = datas;
    }

    public void remove(int position) {
        mDatas.remove(position);
        this.notifyDataSetChanged();
    }

    public void removeAll() {
        if (mDatas.size() != 0) {
            mDatas.clear();
        }
        this.notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        int type = showFoot ? 1 : 0;
        if (mDatas == null) {
            return type;
        }
        return mDatas.size() + type;
    }

    @Override
    public int getItemViewType(int position) {
        if (!showFoot) {
            return TYPE_ITEM;
        }
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    public void isShowFooter(boolean showFoot) {
        this.showFoot = showFoot;
        this.notifyDataSetChanged();
    }

    public boolean isShowFooter() {
        return this.showFoot;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    public List<T> getDatas() {
        return mDatas;
    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return  onCreate(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //获取的是最终的位置
        final int pos  =  holder.getLayoutPosition();
        final T data = mDatas.get(position);
        if(data == null){
            return;
        }
        onBind(holder,data,position);
        if(mOnItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(v,pos,data);
                    mOnItemClickListener.onItemLongClick(v,pos,data);
                }
            });
        }

    }
    protected abstract BaseRecyclerViewHolder onCreate(ViewGroup parent, int viewType);
    protected  abstract  void  onBind (RecyclerView.ViewHolder holder, T data,int position);

     protected class BaseRecyclerViewHolder extends  RecyclerView.ViewHolder{


         public BaseRecyclerViewHolder(View itemView) {
             super(itemView);
             ButterKnife.bind(this,itemView);
         }

         public void setData(@NonNull T data){

         }
     }

    public interface OnItemClickListener<T> {

        void onItemClick(View view, int position, T info);

        void onItemLongClick(View view, int position, T info);

    }
    public void setOnItemClickListener(OnItemClickListener<T> listener) {
        this.mOnItemClickListener = listener;
    }

}
