package com.ccr.ccrslideofflayout.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ccr.ccrslideofflayout.R;
import com.ccr.ccrslideofflayout.adapter.ContentAdapter;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.androidcommon.adapter.BGADivider;
import cn.bingoogolapple.androidcommon.adapter.BGAOnRVItemClickListener;
import cn.bingoogolapple.androidcommon.adapter.BGAOnRVItemLongClickListener;

/**
 * 在此写用途
 *
 * @Author: Acheng
 * @Email: 345887272@qq.com
 * @Date: 2017-09-30 16:50
 * @Version: V1.0 <描述当前版本功能>
 */
public class TranslucentActivity extends BaseActivity {
    private ContentAdapter mContentAdapter;
    private RecyclerView mContentRv;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_translucent);
        mToolbar = getViewById(R.id.toolbar);
        mContentRv = getViewById(R.id.recyclerView);
    }

    @Override
    protected void setListener() {
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        initToolbar();
        initRecyclerView();
        StatusBarUtil.setTranslucentForImageView(this, 0, findViewById(R.id.ll_translucent_content));
    }

    private void initToolbar() {
        mToolbar.setBackgroundResource(android.R.color.transparent);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Test Translucent StatusBar");
    }

    private void initRecyclerView() {
        mContentRv.addItemDecoration(BGADivider.newBitmapDivider());

        mContentAdapter = new ContentAdapter(mContentRv);
        mContentAdapter.setOnRVItemClickListener(new BGAOnRVItemClickListener() {
            @Override
            public void onRVItemClick(ViewGroup parent, View itemView, int position) {
                Toast.makeText(parent.getContext(), "点击了条目 " + (position + 1), Toast.LENGTH_SHORT).show();
            }
        });
        mContentAdapter.setOnRVItemLongClickListener(new BGAOnRVItemLongClickListener() {
            @Override
            public boolean onRVItemLongClick(ViewGroup parent, View itemView, int position) {
                Toast.makeText(parent.getContext(), "长按了条目 " + (position + 1), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        List<String> data = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            data.add("标题" + i);
        }
        mContentAdapter.setData(data);
        mContentRv.setAdapter(mContentAdapter);
    }
}
