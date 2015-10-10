package com.zykj.toorder.http;

/**
 * @author Administrator
 * 服务器路径
 */
public class UrlContants {

    public static final String SERVERIP = "121.42.194.222";

    public static final String BASE_URL = "http://121.42.194.222/api.php?";

    public static final String IMAGE_URL = "http://121.42.194.222/Uploads/";
    
    public static final String ORDERPAY = "http://121.42.194.222/pingxx/api/pay.php";//支付

    public static final String BASEURL = BASE_URL+"%s";

    public static final String jsonData = "datas";

    public static final String ERROR = "{\"code\":400,\"message\":\"请求失败\",\"datas\":null}";

    public static final String ZERODATA = "{\"code\":200,\"message\":\"没有数据\",\"datas\":\"\"}";

    public static final String GETADSLIST = "c=public&a=getAdsList&type=slideFocus";//轮播图
    


    public static String getUrl(String token){
        if(token==null || token.equals("")){
            return BASE_URL;
        }
        return  String.format(BASEURL,token);
    }
}
