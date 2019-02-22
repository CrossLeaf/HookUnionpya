package com.example.hookunionpay;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void testA(){
//        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
//        Context context = instrumentation.getContext();               // 启动测试App
//        Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.unionpay");
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        context.startActivity(intent);

    }
}
