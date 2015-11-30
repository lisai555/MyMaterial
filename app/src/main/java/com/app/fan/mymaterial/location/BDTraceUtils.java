package com.app.fan.mymaterial.location;

import android.content.Context;

import com.baidu.trace.LBSTraceClient;
import com.baidu.trace.OnStartTraceListener;
import com.baidu.trace.Trace;

/**
 * Created by fan on 2015/11/27.
 */
public class BDTraceUtils {

    public static void startTrace(Context mContext) {
        LBSTraceClient client = new LBSTraceClient(mContext);
        long serviceId = 105026;
        String entityName = "MrFan";
//轨迹服务类型（0 : 不上传位置数据，也不接收报警信息； 1 : 不上传位置数据，但接收报警信息；2 : 上传位置数据，且接收报警信息）
        int traceType = 2;
//实例化轨迹服务
        Trace trace = new Trace(mContext, serviceId, entityName, traceType);
//实例化开启轨迹服务回调接口
        OnStartTraceListener startTraceListener = new OnStartTraceListener() {
            //开启轨迹服务回调接口（arg0 : 消息编码，arg1 : 消息内容，详情查看类参考）
            @Override
            public void onTraceCallback(int arg0, String arg1) {
            }

            //轨迹服务推送接口（用于接收服务端推送消息，arg0 : 消息类型，arg1 : 消息内容，详情查看类参考）
            @Override
            public void onTracePushCallback(byte arg0, String arg1) {
            }
        };

//开启轨迹服务
        client.startTrace(trace, startTraceListener);
    }


}
