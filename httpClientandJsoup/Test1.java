package httpClientandJsoup;

import java.net.InetAddress;
import java.net.URLEncoder;

import httpClientandJsoup.HttpRequestor;

public class Test1 {

	public static void main(String[] args) throws Exception {
//		System.out.println(new HttpRequestor().doGet("http://restapi.amap.com/v3/place/text?key=4e96a5ed9368a117fa46c359c36f6f7e&keywords=%E5%85%85%E7%94%B5%E6%A1%A9&types=&city=110000&children=1&offset=100&page=1&extensions=all"));
		
//		String string = "北京大学";
//		String utfstr ="";
//		utfstr =URLEncoder.encode(string,"utf-8");
//		System.out.println(utfstr);
		
		 InetAddress ia=null;
	        try {
	            ia=ia.getLocalHost();
	             
	            String localname=ia.getHostName();
	            String localip=ia.getHostAddress();
	            System.out.println("本机名称是："+ localname);
	            System.out.println("本机的ip是 ："+localip);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}

}
