package com.ccr.ccrslideofflayout.adapter;

import android.support.v7.widget.RecyclerView;

import com.ccr.ccrslideofflayout.R;
import com.ccr.ccrslideofflayout.model.NormalModel;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;
import cn.bingoogolapple.swipeitemlayout.BGASwipeItemLayout;


public class SwipeDeleteAdapter extends BGARecyclerViewAdapter<NormalModel> {
    /**
     * 当前处于打开状态的item
     */
    private List<BGASwipeItemLayout> mOpenedSil = new ArrayList<>();

    public SwipeDeleteAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.item_bgaswipe);
    }

    @Override
    public void setItemChildListener(BGAViewHolderHelper viewHolderHelper, int viewType) {
        BGASwipeItemLayout swipeItemLayout = viewHolderHelper.getView(R.id.sil_item_bgaswipe_root);
        swipeItemLayout.setDelegate(new BGASwipeItemLayout.BGASwipeItemLayoutDelegate() {
            @Override
            public void onBGASwipeItemLayoutOpened(BGASwipeItemLayout swipeItemLayout) {
                closeOpenedSwipeItemLayoutWithAnim();
                mOpenedSil.add(swipeItemLayout);
            }

            @Override
            public void onBGASwipeItemLayoutClosed(BGASwipeItemLayout swipeItemLayout) {
                mOpenedSil.remove(swipeItemLayout);
            }

            @Override
            public void onBGASwipeItemLayoutStartOpen(BGASwipeItemLayout swipeItemLayout) {
                closeOpenedSwipeItemLayoutWithAnim();
            }
        });
        viewHolderHelper.setItemChildClickListener(R.id.tv_item_bgaswipe_delete);
        viewHolderHelper.setItemChildLongClickListener(R.id.tv_item_bgaswipe_delete);
    }

    @Override
    public void fillData(BGAViewHolderHelper viewHolderHelper, int position, NormalModel model) {
        viewHolderHelper.setText(R.id.tv_item_bgaswipe_title, model.mTitle)
                .setText(R.id.tv_item_bgaswipe_detail, model.mDetail);
    }

    public void closeOpenedSwipeItemLayoutWithAnim() {
        for (BGASwipeItemLayout sil : mOpenedSil) {
            sil.closeWithAnim();
        }
        mOpenedSil.clear();
    }
}