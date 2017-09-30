package com.ccr.ccrslideofflayout.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ccr.ccrslideofflayout.R;
import com.ccr.ccrslideofflayout.adapter.RecyclerIndexAdapter;
import com.ccr.ccrslideofflayout.util.DataUtil;
import com.ccr.ccrslideofflayout.widget.IndexView;

import cn.bingoogolapple.androidcommon.adapter.BGADivider;
import cn.bingoogolapple.androidcommon.adapter.BGAOnRVItemClickListener;
import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewScrollHelper;


/**
 * 在此写用途
 *
 * @Author: Acheng
 * @Email: 345887272@qq.com
 * @Date: 2017-09-30 16:50
 * @Version: V1.0 <描述当前版本功能>
 */
public class RecyclerIndexActivity extends BaseActivity implements BGAOnRVItemClickListener {
    private RecyclerIndexAdapter mAdapter;
    private RecyclerView mDataRv;
    private LinearLayoutManager mLayoutManager;
    private IndexView mIndexView;
    private TextView mTipTv;
    private BGARecyclerViewScrollHelper mRecyclerViewScrollHelper;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_recycler_index);
        mDataRv = getViewById(R.id.rv_recyclerindexview_data);

        mIndexView = getViewById(R.id.indexview);
        mTipTv = getViewById(R.id.tv_recyclerindexview_tip);
    }

    @Override
    protected void setListener() {
        mAdapter = new RecyclerIndexAdapter(mDataRv);
        mAdapter.setOnRVItemClickListener(this);

        mIndexView.setDelegate(new IndexView.Delegate() {
            @Override
            public void onIndexViewSelectedChanged(IndexView indexView, String text) {
                int position = mAdapter.getPositionForCategory(text.charAt(0));
                if (position != -1) {
                    mRecyclerViewScrollHelper.smoothScrollToPosition(position);
                }
            }
        });
        mRecyclerViewScrollHelper = BGARecyclerViewScrollHelper.newInstance(mDataRv);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        initToolbar();

        mIndexView.setTipTv(mTipTv);

        mDataRv.addItemDecoration(BGADivider.newBitmapDivider()
                .setStartSkipCount(0)
                .setMarginLeftResource(R.dimen.size_level3)
                .setMarginRightResource(R.dimen.size_level9)
                .setDelegate(new BGADivider.SuspensionCategoryDelegate() {
                    @Override
                    protected boolean isCategory(int position) {
                        return mAdapter.isCategory(position);
                    }

                    @Override
                    protected String getCategoryName(int position) {
                        return mAdapter.getItem(position).topc;
                    }

                    @Override
                    protected int getFirstVisibleItemPosition() {
                        return mLayoutManager.findFirstVisibleItemPosition();
                    }
                }));

        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mDataRv.setLayoutManager(mLayoutManager);

        mAdapter.setData(DataUtil.loadIndexModelData());
        mDataRv.setAdapter(mAdapter);
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("测试 RecyclerView");
        setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        Toast.makeText(this, "选择了城市 " + mAdapter.getItem(position).name, Toast.LENGTH_SHORT).show();
    }
}
