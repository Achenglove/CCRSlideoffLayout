# CCRSlideoffLayout
这是一个侧滑退出界面的库，包括滑动返回布局接口，滑动删除接口，下拉刷新返回接口，Edittext位于底部的情况等

基本使用
```
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CCRSwipeBackManager.getInstance().init(this);//初始化滑动返回
    }
}
```
