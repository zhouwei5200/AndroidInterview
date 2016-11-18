package com.guowei.android.widght.popupwindow;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;

import com.guowei.android.R;
import com.guowei.android.view.activity.CommitActivity;


/**
 *  作者：zhouguowei
 *  电话：17090417151
 *  邮箱：17090417151@163.com
 *  版本号：1.0
 *  类描述：
 *  备注消息：
 *  修改时间：
 **/
public class SlideFromBottomPopup extends BasePopupWindow implements View.OnClickListener{

    private View popupView;
    private Context context;
    public SlideFromBottomPopup(Activity context) {
        super(context);
        this.context = context;
        bindEvent();
    }
    @Override
    protected Animation getShowAnimation() {
        return getTranslateAnimation(250*2,0,300);
    }

    @Override
    protected View getClickToDismissView() {
        return popupView.findViewById(R.id.click_to_dismiss);
    }

    @Override
    public View getPopupView() {
        popupView= LayoutInflater.from(mContext).inflate(R.layout.popup_slide_from_bottom,null);
        return popupView;
    }

    @Override
    public View getAnimaView() {
        return popupView.findViewById(R.id.popup_anima);
    }

    private void bindEvent() {
        if (popupView!=null){
            popupView.findViewById(R.id.tx_1).setOnClickListener(this);
            popupView.findViewById(R.id.tx_2).setOnClickListener(this);
            popupView.findViewById(R.id.tx_3).setOnClickListener(this);
            popupView.findViewById(R.id.tx_4).setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tx_1:
                ((CommitActivity)context).tv_choose.setText("android");
                dismiss();
                break;
            case R.id.tx_2:
                ((CommitActivity)context).tv_choose.setText("java");
                dismiss();
                break;
            case R.id.tx_3:
                ((CommitActivity)context).tv_choose.setText("设计模式");
                dismiss();
                break;
            case R.id.tx_4:
                ((CommitActivity)context).tv_choose.setText("算法");
                dismiss();
                break;
            default:
                break;
        }

    }
}
