package com.zykj.toorder.http;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;


/**
 * Created by csh on 15-7-21.
 */
public class HttpUtils {

    private HttpUtils(){

    }

    private static AsyncHttpClient client = new AsyncHttpClient();

    static {
        //使用默认的 cacheThreadPool
        client.setTimeout(15);
        client.setConnectTimeout(15);
        client.setMaxConnections(20);
        client.setResponseTimeout(20);
    }
    
    /*轮播图*/
    public static void getAdsList(AsyncHttpResponseHandler handler, String type){
        client.get(UrlContants.getUrl(UrlContants.GETADSLIST)+"&id="+type, handler);
    }
    

}
