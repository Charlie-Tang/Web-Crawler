package httpClientandJsoup;

import java.util.List;

//数据实体类
public class JsonBean {
	
	public String url = "http://restapi.amap.com/v3/place/text?key=4e96a5ed9368a117fa46c359c36f6f7e&keywords=%E5%8C%97%E4%BA%AC%E5%A4%A7%E5%AD%A6&types=%E9%AB%98%E7%AD%89%E9%99%A2%E6%A0%A1&city=%E5%8C%97%E4%BA%AC&children=1&offset=100&page=1&extensions=all";
	
	private String status;//0：请求失败；1：请求成功
	private String count;//搜索方案数目
	
	public String getstatus()
	{
		return status;
	}
	
	public void setStatus(String status) 
	{
		this.status = status;
    }
	
	public String getCount() 
	{
        return count;
    }

    public void setCount(String count) 
    {
        this.count = count;
    }
    
    public String getInfo() 
    {
        return info;
    }

    public void setInfo(String info) 
    {
        this.info = info;
    }

    public String getInfocode() 
    {
        return infocode;
    }

    public void setInfocode(String infocode) 
    {
        this.infocode = infocode;
    }

    public SuggestionBean getSuggestion() 
    {
        return suggestion;
    }

    public void setSuggestion(SuggestionBean suggestion) 
    {
        this.suggestion = suggestion;
    }

    public List<PoisBean> getPois() 
    {
        return pois;
    }

    public void setPois(List<PoisBean> pois) 
    {
        this.pois = pois;
    }

    private String info;//status为0时，info返回错误原因，否则返回“OK”。
    private String infocode;
    private SuggestionBean suggestion;//当用户输入的词语为泛搜索词的时候，将显示城市列表

    private List<PoisBean> pois;//搜索POI信息列表

    public static class SuggestionBean 
    {
        private List<?> keywords;//唯一ID
        private List<?> cities;//城市列表

        public List<?> getKeywords() 
        {
            return keywords;
        }

        public void setKeywords(List<?> keywords) 
        {
            this.keywords = keywords;
        }

        public List<?> getCities() 
        {
            return cities;
        }

        public void setCities(List<?> cities) 
        {
            this.cities = cities;
        }

    }

    public static class PoisBean {
        private String id;//唯一ID
        private String name;//名称
        private String tag;//该POI的特色内容

        public String getId() 
        {
            return id;
        }

        public void setId(String id) 
        {
            this.id = id;
        }

        public String getName() 
        {
            return name;
        }

        public void setName(String name) 
        {
            this.name = name;
        }

        public String getTag() 
        {
            return tag;
        }

        public void setTag(String tag) 
        {
            this.tag = tag;
        }

        public String getType() 
        {
            return type;
        }

        public void setType(String type) 
        {
            this.type = type;
        }

        public String getTypecode() 
        {
            return typecode;
        }

        public void setTypecode(String typecode) 
        {
            this.typecode = typecode;
        }

        public String getBiz_type() 
        {
            return biz_type;
        }

        public void setBiz_type(String biz_type) 
        {
            this.biz_type = biz_type;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) 
        {
            this.address = address;
        }

        public String getLocation() 
        {
            return location;
        }

        public void setLocation(String location)
        {
            this.location = location;
        }

        public String getTel() 
        {
            return tel;
        }

        public void setTel(String tel) 
        {
            this.tel = tel;
        }

        public String getPostcode() 
        {
            return postcode;
        }

        public void setPostcode(String postcode) 
        {
            this.postcode = postcode;
        }

        public String getWebsite() 
        {
            return website;
        }

        public void setWebsite(String website) 
        {
            this.website = website;
        }

        public String getEmail() 
        {
            return email;
        }

        public void setEmail(String email) 
        {
            this.email = email;
        }

        public String getPcode() 
        {
            return pcode;
        }

        public void setPcode(String pcode) 
        {
            this.pcode = pcode;
        }

        public String getPname() 
        {
            return pname;
        }

        public void setPname(String pname) 
        {
            this.pname = pname;
        }

        public String getCitycode() 
        {
            return citycode;
        }

        public void setCitycode(String citycode) 
        {
            this.citycode = citycode;
        }

        public String getCityname() 
        {
            return cityname;
        }

        public void setCityname(String cityname) 
        {
            this.cityname = cityname;
        }

        public String getAdcode() 
        {
            return adcode;
        }

        public void setAdcode(String adcode) 
        {
            this.adcode = adcode;
        }

        public String getAdname() 
        {
            return adname;
        }

        public void setAdname(String adname) 
        {
            this.adname = adname;
        }

        public String getImportance() 
        {
            return importance;
        }

        public void setImportance(String importance) 
        {
            this.importance = importance;
        }

        public String getShopid() 
        {
            return shopid;
        }

        public void setShopid(String shopid) 
        {
            this.shopid = shopid;
        }

        public String getShopinfo() 
        {
            return shopinfo;
        }

        public void setShopinfo(String shopinfo) 
        {
            this.shopinfo = shopinfo;
        }

        public String getPoiweight() 
        {
            return poiweight;
        }

        public void setPoiweight(String poiweight) 
        {
            this.poiweight = poiweight;
        }

        public String getGridcode() 
        {
            return gridcode;
        }

        public void setGridcode(String gridcode) 
        {
            this.gridcode = gridcode;
        }

        public String getDistance()
        {
            return distance;
        }

        public void setDistance(String distance) 
        {
            this.distance = distance;
        }

        public String getNavi_poiid()
        {
            return navi_poiid;
        }

        public void setNavi_poiid(String navi_poiid) 
        {
            this.navi_poiid = navi_poiid;
        }

        public String getEntr_location() 
        {
            return entr_location;
        }

        public void setEntr_location(String entr_location) 
        {
            this.entr_location = entr_location;
        }

        public String getBusiness_area()
        {
            return business_area;
        }

        public void setBusiness_area(String business_area) 
        {
            this.business_area = business_area;
        }

        public String getExit_location()
        {
            return exit_location;
        }

        public void setExit_location(String exit_location) 
        {
            this.exit_location = exit_location;
        }

        public String getMatch()
        {
            return match;
        }

        public void setMatch(String match)
        {
            this.match = match;
        }

        public String getRecommend() 
        {
            return recommend;
        }

        public void setRecommend(String recommend) 
        {
            this.recommend = recommend;
        }

        public String getTimestamp()
        {
            return timestamp;
        }

        public void setTimestamp(String timestamp) 
        {
            this.timestamp = timestamp;
        }

        public String getAlias()
        {
            return alias;
        }

        public void setAlias(String alias)
        {
            this.alias = alias;
        }

        public String getIndoor_map()
        {
            return indoor_map;
        }

        public void setIndoor_map(String indoor_map)
        {
            this.indoor_map = indoor_map;
        }

        public String getIndoor_data() 
        {
            return indoor_data;
        }

        public void setIndoor_data(String indoor_data) 
        {
            this.indoor_data = indoor_data;
        }

        public String getGroupbuy_num()
        {
            return groupbuy_num;
        }

        public void setGroupbuy_num(String groupbuy_num) 
        {
            this.groupbuy_num = groupbuy_num;
        }

        public String getDiscount_num() 
        {
            return discount_num;
        }

        public void setDiscount_num(String discount_num)
        {
            this.discount_num = discount_num;
        }

        public String getBiz_ext() 
        {
            return biz_ext;
        }

        public void setBiz_ext(String biz_ext)
        {
            this.biz_ext = biz_ext;
        }

        public String getEvent() 
        {
            return event;
        }

        public void setEvent(String event)
        {
            this.event = event;
        }

        public String getChildren()
        {
            return children;
        }

        public void setChildren(String children) 
        {
            this.children = children;
        }

        public String getPhotos() 
        {
            return photos;
        }

        public void setPhotos(String photos) 
        {
            this.photos = photos;
        }

        private String type;//兴趣点类型
        private String typecode;//兴趣点类型编码
        private String biz_type;//行业类型
        private String address;//地址
        private String location;//经纬度
        private String tel;//该POI的电话
        private String postcode;//邮编
        private String website;//该POI的网址
        private String email;//该POI的电子邮箱
        private String pcode;//poi所在省份编码
        private String pname;//poi所在省份名称
        private String citycode;//城市编码
        private String cityname;//城市名
        private String adcode;//区域编码
        private String adname;//区域名称
        private String importance;
        private String shopid;
        private String shopinfo;
        private String poiweight;
        private String gridcode;
        private String distance;
        private String navi_poiid;
        private String entr_location;
        private String business_area;
        private String exit_location;
        private String match;
        private String recommend;
        private String timestamp;
        private String alias;
        private String indoor_map;
        private String indoor_data;
        private String groupbuy_num;
        private String discount_num;
        private String biz_ext;
        private String event;
        private String children;
        private String photos;//照片相关信息


	public static void main(String[] args) {
		
		

	}
  }
}
