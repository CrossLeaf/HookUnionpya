//package com.example.hookunionpay;
//
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.util.Log;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.Serializable;
//import java.util.logging.Level;
//import java.util.logging.LogRecord;
//import java.util.logging.Logger;
//
//public class CommandBroadcastReceiver extends BroadcastReceiver {
//    public static String INTENT_ACTION = "com.zjdroid.invoke";
//    public static String TARGET_KEY = "target";
//    public static String COMMAND_NAME_KEY = "cmd";
//
//    @Override
//    public void onReceive(final Context arg0, Intent arg1) {
//        // TODO Auto-generated method stub
//        if (INTENT_ACTION.equals(arg1.getAction())) {
//            try {
//                int pid = arg1.getIntExtra(TARGET_KEY, 0);
//                if (pid == android.os.Process.myPid()) {
//                    String cmd = arg1.getStringExtra(COMMAND_NAME_KEY);
//                    final CommandHandler handler = CommandHandlerParser
//                            .parserCommand(cmd);
//                    if (handler != null) {
//                        new Thread(new Runnable() {
//                            @Override
//                            public void run() {
//                                // TODO Auto-generated method stub
//                                handler.doAction();
//                            }
//                        }).start();
//                    }else{
//                        Log.d("MyBroadcastReceiver", "the cmd is invalid");
//                    }
//                }
//            } catch (Exception e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static CommandHandler parserCommand(String cmd) {
//        CommandHandler handler = null;
//        try {
//            JSONObject jsoncmd = new JSONObject(cmd);
//            String action = jsoncmd.getString(ACTION_NAME_KEY);
//            Logger.log("the cmd = " + action);
//            if (ACTION_DUMP_DEXINFO.equals(action)) {
//                handler = new DumpDexInfoCommandHandler();
//            } else if (ACTION_DUMP_DEXFILE.equals(action)) {
//                if (jsoncmd.has(PARAM_DEXPATH_DUMPDEXCLASS)) {
//                    String dexpath = jsoncmd.getString(PARAM_DEXPATH_DUMPDEXCLASS);
//                    handler = new DumpDexFileCommandHandler(dexpath);
//                } else {
//                    Logger.log("please set the " + PARAM_DEXPATH_DUMPDEXCLASS + " value");
//                }
//            } else if (ACTION_BACKSMALI_DEXFILE.equals(action)) {
//                if (jsoncmd.has(PARAM_DEXPATH_DUMPDEXCLASS)) {
//                    String dexpath = jsoncmd.getString(PARAM_DEXPATH_DUMPDEXCLASS);
//                    handler = new BackSmaliCommandHandler(dexpath);
//                } else {
//                    Logger.log("please set the " + PARAM_DEXPATH_DUMPDEXCLASS + " value");
//                }
//            } else if (ACTION_DUMP_DEXCLASS.equals(action)) {
//                if (jsoncmd.has(PARAM_DEXPATH_DUMPDEXCLASS)) {
//                    String dexpath = jsoncmd.getString(PARAM_DEXPATH_DUMP_DEXFILE);
//                    handler = new DumpClassCommandHandler(dexpath);
//                } else {
//                    Logger.log("please set the " + PARAM_DEXPATH_DUMPDEXCLASS + " value");
//                }
//            } else if (ACTION_DUMP_HEAP.equals(action)) {
//                handler = new DumpHeapCommandHandler();
//            } else if (ACTION_INVOKE_SCRIPT.equals(action)) {
//                if (jsoncmd.has(FILE_SCRIPT)) {
//                    String filepath = jsoncmd.getString(FILE_SCRIPT);
//                    handler = new InvokeScriptCommandHandler(filepath, ScriptType.FILETYPE);
//                } else {
//                    Logger.log("please set the " + FILE_SCRIPT);
//                }
//
//            } else if (ACTION_DUMP_MEMERY.equals(action)) {
//                int start = jsoncmd.getInt(PARAM_START_DUMP_MEMERY);
//                int length = jsoncmd.getInt(PARAM_LENGTH_DUMP_MEMERY);
//                handler = new DumpMemCommandHandler(start, length);
//            } else {
//                Logger.log(action + " cmd is invalid! ");
//            }
//        } catch (JSONException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return handler;
//    }
//}
