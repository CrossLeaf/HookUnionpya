package com.example.hookunionpay;

import android.app.Activity;
import android.view.View;

import com.squareup.okhttp.OkHttpClient;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Hook implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        XposedBridge.log("handleLoadPackage unionpay 執行！");
        XposedBridge.log("包名 = " + lpparam.packageName);
        if (lpparam.packageName.contentEquals("com.unionpay")) {
            XposedBridge.log("雲閃付 hook 運行");
            XposedHelpers.findAndHookMethod("com.unionpay.activity.UPActivityLogin",
                    lpparam.classLoader, "onResume", new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            super.beforeHookedMethod(param);
                            XposedBridge.log("抓到登入頁面");
                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                        }
                    });

            XposedHelpers.findAndHookMethod(Activity.class, "onStart",
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            Activity activity = (Activity) param.thisObject;
                            XposedBridge.log("Current activity name = " + activity.getLocalClassName());
                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                        }
                    });

            XposedHelpers.findAndHookMethod("org.aspectj.lang.a.a", lpparam.classLoader,
                    "a",
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            int id = ((View) param.thisObject).getId();
                            XposedBridge.log("點擊的 id = " + id);

                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            XposedBridge.log("點擊後");
                        }
                    });
        }
    }
}
