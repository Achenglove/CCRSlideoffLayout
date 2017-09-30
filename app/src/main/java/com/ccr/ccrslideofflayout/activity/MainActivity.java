package com.ccr.ccrslideofflayout.activity;

import android.os.Bundle;
import android.view.View;

import com.ccr.ccrslideofflayout.R;


/**
 * 在此写用途
 *
 * @Author: Acheng
 * @Email: 345887272@qq.com
 * @Date: 2017-09-30 16:50
 * @Version: V1.0 <描述当前版本功能>
 */
public class MainActivity extends BaseActivity {

    /**
     * 主界面不需要支持滑动返回，重写该方法永久禁用当前界面的滑动返回功能
     *
     * @return
     */
    @Override
    public boolean isSupportSwipeBack() {
        return false;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        mToolbar = getViewById(R.id.toolbar);
    }

    @Override
    protected void setListener() {
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        setSupportActionBar(mToolbar);
    }

    public void testSwipeBack(View v) {
        mSwipeBackHelper.forward(TestActivity.class);
    }

    public void testTranslucent(View v) {
        mSwipeBackHelper.forward(TranslucentActivity.class);

//        mSwipeBackHelper.forwardAndFinish(TranslucentActivity.class);
    }

    public void testPullRefreshAndWebView(View v) {
        mSwipeBackHelper.forward(WebViewActivity.class);
    }

    public void testSwipeDelete(View v) {
        mSwipeBackHelper.forward(SwipeDeleteActivity.class);
    }

    public void testRecyclerView(View v) {
        mSwipeBackHelper.forward(RecyclerIndexActivity.class);
    }

    public void testEditText(View v) {
        mSwipeBackHelper.forward(EditTextActivity.class);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
