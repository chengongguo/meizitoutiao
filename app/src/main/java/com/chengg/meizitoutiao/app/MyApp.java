package com.chengg.meizitoutiao.app;

import com.chengg.meizitoutiao.BuildConfig;
import com.socks.library.KLog;

/**
 * @author ChayChan
 * @description: Application类
 * @date 2017/6/10  15:44
 */

public class MyApp extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();

        //**************************************相关第三方SDK的初始化等操作*************************************************
        KLog.init(BuildConfig.DEBUG);//初始化KLog
//        LitePalApplication.initialize(getApplicationContext());//初始化litePal
    }
}
