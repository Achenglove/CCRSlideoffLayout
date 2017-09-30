package com.ccr.ccrslideofflayout.adapter;

import android.support.v7.widget.RecyclerView;

import com.ccr.ccrslideofflayout.R;

import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;


public class ContentAdapter extends BGARecyclerViewAdapter<String> {

    public ContentAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.item_test);
    }

    @Override
    protected void fillData(BGAViewHolderHelper helper, int position, String model) {
        helper.setText(R.id.tv_item_test_title, model);
        helper.setText(R.id.tv_item_test_content, "内容" + (position + 1));
    }
}