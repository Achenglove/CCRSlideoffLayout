package com.ccr.ccrslideofflayout.base;

import android.app.Application;

import com.ccr.slideofflibrary.CCRSwipeBackManager;

/**
 * 在此写用途
 *
 * @Author: Acheng
 * @Email: 345887272@qq.com
 * @Date: 2017-09-23 14:41
 * @Version: V1.0 <描述当前版本功能>
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CCRSwipeBackManager.getInstance().init(this);//初始化滑动返回
    }
}
