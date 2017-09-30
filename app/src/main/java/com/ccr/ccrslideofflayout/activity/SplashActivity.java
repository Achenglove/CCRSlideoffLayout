package com.ccr.ccrslideofflayout.activity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.ccr.ccrslideofflayout.R;


/**
 * 在此写用途
 *
 * @Author: Acheng
 * @Email: 345887272@qq.com
 * @Date: 2017-09-30 16:50
 * @Version: V1.0 <描述当前版本功能>
 */
public class SplashActivity extends BaseActivity {
    private TextView mVersionTv;

    @Override
    public boolean isSupportSwipeBack() {
        return false;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_splash);
        mVersionTv = getViewById(R.id.tv_splash_version);
    }

    @Override
    protected void setListener() {
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mVersionTv.setText("v" + getCurrentVersionName());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeBackHelper.forwardAndFinish(MainActivity.class);
            }
        }, 2000);
    }

    /**
     * 获取当前版本名称
     *
     * @return
     */
    public String getCurrentVersionName() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (Exception e) {
            // 利用系统api getPackageName()得到的包名，这个异常根本不可能发生
            return "";
        }
    }
}
