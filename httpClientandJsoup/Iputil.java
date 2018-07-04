package httpClientandJsoup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import httpClientandJsoup.JsonBean.PoisBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Iputil//主函数所在类
{

   public static void main(String [] args)
   {
	  
       JsonBean jsonBean=new JsonBean();
       
      try
      {
    	  String urlString = "";
    	 
    	 
	         URL url = new URL("http://restapi.amap.com/v3/place/text?key=4e96a5ed9368a117fa46c359c36f6f7e&keywords=%E5%85%85%E7%94%B5%E6%A1%A9&types=&city=110000&children=1&offset=100&page=1&extensions=all");
	         URLConnection urlConnection = url.openConnection();
	         HttpURLConnection connection = null;
	         if(urlConnection instanceof HttpURLConnection)
	         {
	            connection = (HttpURLConnection) urlConnection;
	         }
	         else
	         {
	            System.out.println("输入url");
	            return;
	         }
	         BufferedReader in = new BufferedReader(
	         new InputStreamReader(connection.getInputStream(),"UTF-8"));
	         
	         String current;
	         while((current = in.readLine()) != null)
	         {
	            urlString += current;     
	         }
    	  
         


         JSONObject json=JSONObject.fromObject(urlString);//大括号object 字符串string 数组list

           jsonBean.setStatus(json.optString("status"));
           jsonBean.setCount(json.optString("count"));
           jsonBean.setInfo(json.optString("info"));
           jsonBean.setInfocode(json.optString("infocode"));

               JSONObject suggestionObj=json.optJSONObject("suggestion");
               JsonBean.SuggestionBean suggestion=new JsonBean.SuggestionBean();

                   List<String> keywordsList=new ArrayList<>();
                   JSONArray keywordsArray=suggestionObj.optJSONArray("keywords");
                   for (int i = 0; i < keywordsArray.size(); i++) {
                          keywordsList.add(keywordsArray.optString(i));
                   }
                   suggestion.setKeywords(keywordsList);

                   List<String> citiesList=new ArrayList<>();
                   JSONArray citiesArray=suggestionObj.optJSONArray("cities");
                   for (int i = 0; i < citiesArray.size(); i++) {
                       citiesList.add(citiesArray.optString(i));
                   }
                   suggestion.setCities(citiesList);


               jsonBean.setSuggestion(suggestion);




           List<PoisBean> poisBeansList=new ArrayList<>();
           JSONArray poisArray=json.optJSONArray("pois");
           for (int i = 0; i < poisArray.size(); i++) {
                JSONObject poisObj = poisArray.optJSONObject(i);
                JsonBean.PoisBean poisBean=new JsonBean.PoisBean();
                poisBean.setId(poisObj.optString("id"));
                poisBean.setName(poisObj.optString("name"));
                poisBean.setTag(poisObj.optString("tag"));
                poisBean.setType(poisObj.optString("type"));
                poisBean.setTypecode(poisObj.optString("typecode"));
                poisBean.setBiz_type(poisObj.optString("biz_type"));    
                poisBean.setAddress(poisObj.optString("address"));
                poisBean.setLocation(poisObj.optString("location"));
                poisBean.setTel(poisObj.optString("tel"));
                poisBean.setPostcode(poisObj.optString("postcode"));
                poisBean.setWebsite(poisObj.optString("website"));
                poisBean.setEmail(poisObj.optString("email"));
                poisBean.setPcode(poisObj.optString("pcode"));
                poisBean.setPname(poisObj.optString("pname"));
                poisBean.setCitycode(poisObj.optString("citycode"));
                poisBean.setCityname(poisObj.optString("cityname"));
                poisBean.setAdcode(poisObj.optString("adcode"));
                poisBean.setAdname(poisObj.optString("adname"));
                poisBean.setImportance(poisObj.optString("importance"));
                poisBean.setShopid(poisObj.optString("shopid"));
                poisBean.setShopinfo(poisObj.optString("shopinfo"));
                poisBean.setPoiweight(poisObj.optString("poiweight"));
                poisBean.setGridcode(poisObj.optString("gridcode"));
                poisBean.setDistance(poisObj.optString("distance"));
                poisBean.setNavi_poiid(poisObj.optString("navi_poiid"));
                poisBean.setEntr_location(poisObj.optString("entr_location"));
                poisBean.setBusiness_area(poisObj.optString("business_area"));
                poisBean.setExit_location(poisObj.optString("exit_location"));
                poisBean.setMatch(poisObj.optString("match1"));
                poisBean.setRecommend(poisObj.optString("recommend1"));
                poisBean.setTimestamp(poisObj.optString("timestamp1"));
                poisBean.setAlias(poisObj.optString("alias1"));
                poisBean.setIndoor_map(poisObj.optString("indoor_map1"));
                poisBean.setIndoor_data(poisObj.optString("indoor_data1"));
                poisBean.setGroupbuy_num(poisObj.optString("groupbuy_num1"));
                poisBean.setDiscount_num(poisObj.optString("discount_num1"));
                poisBean.setBiz_ext(poisObj.optString("biz_ext"));
                poisBean.setEvent(poisObj.optString("event"));
                poisBean.setChildren(poisObj.optString("children"));
                poisBean.setPhotos(poisObj.optString("photos"));


               poisBeansList.add(poisBean);
           }

           jsonBean.setPois(poisBeansList);

      }catch(IOException e)
      {
         e.printStackTrace();
      }     //get数据



              Conn c=new Conn();  //连接数据库
              Connection con=   c.getConn();

                try {
                     Statement sql;
                     ResultSet res;
                     int a;

                    sql=con.createStatement();
//         sql.executeUpdate("CREATE TABLE Map (id varchar(255)primary key, name varchar(255),tag varchar(255),"
//                            + "type varchar(255),typecode varchar(255), biz_type varchar(255),address varchar(255),location varchar(255),"
//                            + "tel varchar(255),postcode varchar(255),website varchar(255),email varchar(255),pcode varchar(255),pname varchar(255),"
//                            + "citycode varchar(255), cityname varchar(255), adcode varchar(255),adname varchar(255), importance varchar(255),shopid varchar(255),shopinfo varchar(255),poiweight varchar(255),"
//                            + "gridcode varchar(255),distance varchar(255),navi_poiid varchar(255),entr_location varchar(255),business_area varchar(255),exit_location varchar(255),"
//                            + "match1 varchar(255),recommend1 varchar(255),timestamp1 varchar(255),alias1 varchar(255),indoor_map1 varchar(255),indoor_data1 varchar(255),"
//                            + "groupbuy_num1 varchar(255),discount_num1 varchar(255),biz_ext varchar(255),event varchar(255),children varchar(255),photos varchar(255))  ");
//                                                                               

            for (int i = 0; i < jsonBean.getPois().size(); i++) {
                a = sql.executeUpdate("insert into Map (id,name,tag,type,typecode,biz_type,address,location,tel,postcode,website,email,pcode,pname,"
                        + "citycode,cityname,adcode,adname,importance,shopid,shopinfo,poiweight,gridcode,distance,navi_poiid,entr_location,business_area,"
                        + "exit_location,match1,recommend1,timestamp1,alias1,indoor_map1,indoor_data1,groupbuy_num1,discount_num1,biz_ext,event,children,photos) "
                        + "values('"+jsonBean.getPois().get(i).getId()+"','"+jsonBean.getPois().get(i).getName()+"'"
                        + ",'"+jsonBean.getPois().get(i).getTag()+"','"+jsonBean.getPois().get(i).getType()+"','"+jsonBean.getPois().get(i).getTypecode()+"'"
                        + ",'"+jsonBean.getPois().get(i).getBiz_type()+"','"+jsonBean.getPois().get(i).getAddress()+"','"+jsonBean.getPois().get(i).getLocation()+"'  "
                        + ",'"+jsonBean.getPois().get(i).getTel()+"','"+jsonBean.getPois().get(i).getPostcode()+"','"+jsonBean.getPois().get(i).getWebsite()+"','"+jsonBean.getPois().get(i).getEmail()+"'"
                        + ",'"+jsonBean.getPois().get(i).getPcode()+"','"+jsonBean.getPois().get(i).getPname()+"','"+jsonBean.getPois().get(i).getCityname()+"','"+jsonBean.getPois().get(i).getCityname()+"'"
                        + ",'"+jsonBean.getPois().get(i).getAdcode()+"','"+jsonBean.getPois().get(i).getAdname()+"','"+jsonBean.getPois().get(i).getImportance()+"','"+jsonBean.getPois().get(i).getShopid()+"'"
                        + ",'"+jsonBean.getPois().get(i).getShopinfo()+"','"+jsonBean.getPois().get(i).getPoiweight()+"','"+jsonBean.getPois().get(i).getGridcode()+"','"+jsonBean.getPois().get(i).getDistance()+"'"
                        + ",'"+jsonBean.getPois().get(i).getNavi_poiid()+"','"+jsonBean.getPois().get(i).getEntr_location()+"','"+jsonBean.getPois().get(i).getBusiness_area()+"','"+jsonBean.getPois().get(i).getExit_location()+"'"
                        + ",'"+jsonBean.getPois().get(i).getMatch()+"','"+jsonBean.getPois().get(i).getRecommend()+"','"+jsonBean.getPois().get(i).getTimestamp()+"','"+jsonBean.getPois().get(i).getAlias()+"'"
                        + ",'"+jsonBean.getPois().get(i).getIndoor_map()+"','"+jsonBean.getPois().get(i).getIndoor_data()+"','"+jsonBean.getPois().get(i).getGroupbuy_num()+"','"+jsonBean.getPois().get(i).getDiscount_num()+"' "
                        + ",'"+jsonBean.getPois().get(i).getBiz_ext()+"','"+jsonBean.getPois().get(i).getEvent()+"','"+jsonBean.getPois().get(i).getChildren()+"','"+jsonBean.getPois().get(i).getPhotos()+"')");

            }



                } catch (Exception e) {
                    e.printStackTrace();
                }


   }

}

