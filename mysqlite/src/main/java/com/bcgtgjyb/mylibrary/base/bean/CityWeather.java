package com.bcgtgjyb.mylibrary.base.bean;

import com.bcgtgjyb.mylibrary.base.MyAnnotion;
import com.bcgtgjyb.mylibrary.base.MyModel;

import java.util.List;

/**
 * Created by bigwen on 2016/1/4.
 */
public class CityWeather {

    /**
     * errNum : 0
     * errMsg : success
     * retData : {"city":"武汉","cityid":"101200101","today":{"date":"2016-01-04","week":"星期一","curTemp":"10℃","aqi":"278","fengxiang":"无持续风向","fengli":"微风级","hightemp":"13℃","lowtemp":"6℃","type":"小雨","index":[{"name":"感冒指数","code":"gm","index":"","details":"将有一次强降温过程，且空气湿度较大，极易发生感冒，请特别注意增加衣服保暖防寒。","otherName":""},{"code":"fs","details":"属弱紫外辐射天气，长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。","index":"弱","name":"防晒指数","otherName":""},{"code":"ct","details":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。","index":"较冷","name":"穿衣指数","otherName":""},{"code":"yd","details":"有降水，推荐您在室内进行低强度运动；若坚持户外运动，须注意保暖，做好准备活动，携带雨具。","index":"较不宜","name":"运动指数","otherName":""},{"code":"xc","details":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。","index":"不宜","name":"洗车指数","otherName":""},{"code":"ls","details":"有降水，不适宜晾晒。若需要晾晒，请在室内准备出充足的空间。","index":"不宜","name":"晾晒指数","otherName":""}]},"forecast":[{"date":"2016-01-05","week":"星期二","fengxiang":"无持续风向","fengli":"微风级","hightemp":"9℃","lowtemp":"4℃","type":"小雨"},{"date":"2016-01-06","week":"星期三","fengxiang":"无持续风向","fengli":"微风级","hightemp":"10℃","lowtemp":"4℃","type":"晴"},{"date":"2016-01-07","week":"星期四","fengxiang":"无持续风向","fengli":"微风级","hightemp":"10℃","lowtemp":"0℃","type":"小雨"},{"date":"2016-01-08","week":"星期五","fengxiang":"无持续风向","fengli":"微风级","hightemp":"10℃","lowtemp":"1℃","type":"多云"}],"history":[{"date":"2015-12-28","week":"星期一","aqi":"154","fengxiang":"无持续风向","fengli":"微风级","hightemp":"9℃","lowtemp":"1℃","type":"多云"},{"date":"2015-12-29","week":"星期二","aqi":"185","fengxiang":"无持续风向","fengli":"微风级","hightemp":"10℃","lowtemp":"1℃","type":"多云"},{"date":"2015-12-30","week":"星期三","aqi":"245","fengxiang":"无持续风向","fengli":"微风级","hightemp":"12℃","lowtemp":"-1℃","type":"多云"},{"date":"2015-12-31","week":"星期四","aqi":"136","fengxiang":"无持续风向","fengli":"微风级","hightemp":"13℃","lowtemp":"2℃","type":"晴"},{"date":"2016-01-01","week":"星期五","aqi":"206","fengxiang":"无持续风向","fengli":"微风级","hightemp":"12℃","lowtemp":"3℃","type":"阴"},{"date":"2016-01-02","week":"星期六","aqi":"177","fengxiang":"无持续风向","fengli":"微风级","hightemp":"14℃","lowtemp":"5℃","type":"小雨"},{"date":"2016-01-03","week":"星期天","aqi":"158","fengxiang":"无持续风向","fengli":"微风级","hightemp":"17℃","lowtemp":"7℃","type":"多云"}]}
     */

    private int errNum;
    private String errMsg;
    /**
     * city : 武汉
     * cityid : 101200101
     * today : {"date":"2016-01-04","week":"星期一","curTemp":"10℃","aqi":"278","fengxiang":"无持续风向","fengli":"微风级","hightemp":"13℃","lowtemp":"6℃","type":"小雨","index":[{"name":"感冒指数","code":"gm","index":"","details":"将有一次强降温过程，且空气湿度较大，极易发生感冒，请特别注意增加衣服保暖防寒。","otherName":""},{"code":"fs","details":"属弱紫外辐射天气，长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。","index":"弱","name":"防晒指数","otherName":""},{"code":"ct","details":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。","index":"较冷","name":"穿衣指数","otherName":""},{"code":"yd","details":"有降水，推荐您在室内进行低强度运动；若坚持户外运动，须注意保暖，做好准备活动，携带雨具。","index":"较不宜","name":"运动指数","otherName":""},{"code":"xc","details":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。","index":"不宜","name":"洗车指数","otherName":""},{"code":"ls","details":"有降水，不适宜晾晒。若需要晾晒，请在室内准备出充足的空间。","index":"不宜","name":"晾晒指数","otherName":""}]}
     * forecast : [{"date":"2016-01-05","week":"星期二","fengxiang":"无持续风向","fengli":"微风级","hightemp":"9℃","lowtemp":"4℃","type":"小雨"},{"date":"2016-01-06","week":"星期三","fengxiang":"无持续风向","fengli":"微风级","hightemp":"10℃","lowtemp":"4℃","type":"晴"},{"date":"2016-01-07","week":"星期四","fengxiang":"无持续风向","fengli":"微风级","hightemp":"10℃","lowtemp":"0℃","type":"小雨"},{"date":"2016-01-08","week":"星期五","fengxiang":"无持续风向","fengli":"微风级","hightemp":"10℃","lowtemp":"1℃","type":"多云"}]
     * history : [{"date":"2015-12-28","week":"星期一","aqi":"154","fengxiang":"无持续风向","fengli":"微风级","hightemp":"9℃","lowtemp":"1℃","type":"多云"},{"date":"2015-12-29","week":"星期二","aqi":"185","fengxiang":"无持续风向","fengli":"微风级","hightemp":"10℃","lowtemp":"1℃","type":"多云"},{"date":"2015-12-30","week":"星期三","aqi":"245","fengxiang":"无持续风向","fengli":"微风级","hightemp":"12℃","lowtemp":"-1℃","type":"多云"},{"date":"2015-12-31","week":"星期四","aqi":"136","fengxiang":"无持续风向","fengli":"微风级","hightemp":"13℃","lowtemp":"2℃","type":"晴"},{"date":"2016-01-01","week":"星期五","aqi":"206","fengxiang":"无持续风向","fengli":"微风级","hightemp":"12℃","lowtemp":"3℃","type":"阴"},{"date":"2016-01-02","week":"星期六","aqi":"177","fengxiang":"无持续风向","fengli":"微风级","hightemp":"14℃","lowtemp":"5℃","type":"小雨"},{"date":"2016-01-03","week":"星期天","aqi":"158","fengxiang":"无持续风向","fengli":"微风级","hightemp":"17℃","lowtemp":"7℃","type":"多云"}]
     */

    private RetDataEntity retData;

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public void setRetData(RetDataEntity retData) {
        this.retData = retData;
    }

    public int getErrNum() {
        return errNum;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public RetDataEntity getRetData() {
        return retData;
    }

    //需要数据
    @MyAnnotion.DBName("CityWeatherRetDataEntity")
    public static class RetDataEntity extends MyModel{
        @MyAnnotion.DBField
        private String city;
        @MyAnnotion.DBField
        @MyAnnotion.DBPrimaryKey
        private String cityid;
        /**
         * date : 2016-01-04
         * week : 星期一
         * curTemp : 10℃
         * aqi : 278
         * fengxiang : 无持续风向
         * fengli : 微风级
         * hightemp : 13℃
         * lowtemp : 6℃
         * type : 小雨
         * index : [{"name":"感冒指数","code":"gm","index":"","details":"将有一次强降温过程，且空气湿度较大，极易发生感冒，请特别注意增加衣服保暖防寒。","otherName":""},{"code":"fs","details":"属弱紫外辐射天气，长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。","index":"弱","name":"防晒指数","otherName":""},{"code":"ct","details":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。","index":"较冷","name":"穿衣指数","otherName":""},{"code":"yd","details":"有降水，推荐您在室内进行低强度运动；若坚持户外运动，须注意保暖，做好准备活动，携带雨具。","index":"较不宜","name":"运动指数","otherName":""},{"code":"xc","details":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。","index":"不宜","name":"洗车指数","otherName":""},{"code":"ls","details":"有降水，不适宜晾晒。若需要晾晒，请在室内准备出充足的空间。","index":"不宜","name":"晾晒指数","otherName":""}]
         */

        private TodayEntity today;
        /**
         * date : 2016-01-05
         * week : 星期二
         * fengxiang : 无持续风向
         * fengli : 微风级
         * hightemp : 9℃
         * lowtemp : 4℃
         * type : 小雨
         */

        private List<ForecastEntity> forecast;
        /**
         * date : 2015-12-28
         * week : 星期一
         * aqi : 154
         * fengxiang : 无持续风向
         * fengli : 微风级
         * hightemp : 9℃
         * lowtemp : 1℃
         * type : 多云
         */

        private List<HistoryEntity> history;

        public void setCity(String city) {
            this.city = city;
        }

        public void setCityid(String cityid) {
            this.cityid = cityid;
        }

        public void setToday(TodayEntity today) {
            this.today = today;
        }

        public void setForecast(List<ForecastEntity> forecast) {
            this.forecast = forecast;
        }

        public void setHistory(List<HistoryEntity> history) {
            this.history = history;
        }

        public String getCity() {
            return city;
        }

        public String getCityid() {
            return cityid;
        }

        public TodayEntity getToday() {
            return today;
        }

        public List<ForecastEntity> getForecast() {
            return forecast;
        }

        public List<HistoryEntity> getHistory() {
            return history;
        }

        //今天
        @MyAnnotion.DBName("CityWeatherTodayEntity")
        public static class TodayEntity extends MyModel{
            @MyAnnotion.DBField
            @MyAnnotion.DBPrimaryKey
            private String date;
            @MyAnnotion.DBField
            private String week;
            @MyAnnotion.DBField
            private String curTemp;
            @MyAnnotion.DBField
            private String aqi;
            @MyAnnotion.DBField
            private String fengxiang;
            @MyAnnotion.DBField
            private String fengli;
            @MyAnnotion.DBField
            private String hightemp;
            @MyAnnotion.DBField
            private String lowtemp;
            @MyAnnotion.DBField
            private String type;
            /**
             * name : 感冒指数
             * code : gm
             * index :
             * details : 将有一次强降温过程，且空气湿度较大，极易发生感冒，请特别注意增加衣服保暖防寒。
             * otherName :
             */

            private List<IndexEntity> index;

            public void setDate(String date) {
                this.date = date;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public void setCurTemp(String curTemp) {
                this.curTemp = curTemp;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }

            public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
            }

            public void setFengli(String fengli) {
                this.fengli = fengli;
            }

            public void setHightemp(String hightemp) {
                this.hightemp = hightemp;
            }

            public void setLowtemp(String lowtemp) {
                this.lowtemp = lowtemp;
            }

            public void setType(String type) {
                this.type = type;
            }

            public void setIndex(List<IndexEntity> index) {
                this.index = index;
            }

            public String getDate() {
                return date;
            }

            public String getWeek() {
                return week;
            }

            public String getCurTemp() {
                return curTemp;
            }

            public String getAqi() {
                return aqi;
            }

            public String getFengxiang() {
                return fengxiang;
            }

            public String getFengli() {
                return fengli;
            }

            public String getHightemp() {
                return hightemp;
            }

            public String getLowtemp() {
                return lowtemp;
            }

            public String getType() {
                return type;
            }

            public List<IndexEntity> getIndex() {
                return index;
            }

            public static class IndexEntity {
                private String name;
                private String code;
                private String index;
                private String details;
                private String otherName;

                public void setName(String name) {
                    this.name = name;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public void setDetails(String details) {
                    this.details = details;
                }

                public void setOtherName(String otherName) {
                    this.otherName = otherName;
                }

                public String getName() {
                    return name;
                }

                public String getCode() {
                    return code;
                }

                public String getIndex() {
                    return index;
                }

                public String getDetails() {
                    return details;
                }

                public String getOtherName() {
                    return otherName;
                }
            }
        }

        //预报
        @MyAnnotion.DBName("CityWeatherForecastEntity")
        public static class ForecastEntity extends MyModel {
            @MyAnnotion.DBPrimaryKey
            @MyAnnotion.DBField
            private String date;
            @MyAnnotion.DBField
            private String week;
            @MyAnnotion.DBField
            private String fengxiang;
            @MyAnnotion.DBField
            private String fengli;
            @MyAnnotion.DBField
            private String hightemp;
            @MyAnnotion.DBField
            private String lowtemp;
            @MyAnnotion.DBField
            private String type;

            public void setDate(String date) {
                this.date = date;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
            }

            public void setFengli(String fengli) {
                this.fengli = fengli;
            }

            public void setHightemp(String hightemp) {
                this.hightemp = hightemp;
            }

            public void setLowtemp(String lowtemp) {
                this.lowtemp = lowtemp;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getDate() {
                return date;
            }

            public String getWeek() {
                return week;
            }

            public String getFengxiang() {
                return fengxiang;
            }

            public String getFengli() {
                return fengli;
            }

            public String getHightemp() {
                return hightemp;
            }

            public String getLowtemp() {
                return lowtemp;
            }

            public String getType() {
                return type;
            }
        }

        //历史
        public static class HistoryEntity {
            private String date;
            private String week;
            private String aqi;
            private String fengxiang;
            private String fengli;
            private String hightemp;
            private String lowtemp;
            private String type;

            public void setDate(String date) {
                this.date = date;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }

            public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
            }

            public void setFengli(String fengli) {
                this.fengli = fengli;
            }

            public void setHightemp(String hightemp) {
                this.hightemp = hightemp;
            }

            public void setLowtemp(String lowtemp) {
                this.lowtemp = lowtemp;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getDate() {
                return date;
            }

            public String getWeek() {
                return week;
            }

            public String getAqi() {
                return aqi;
            }

            public String getFengxiang() {
                return fengxiang;
            }

            public String getFengli() {
                return fengli;
            }

            public String getHightemp() {
                return hightemp;
            }

            public String getLowtemp() {
                return lowtemp;
            }

            public String getType() {
                return type;
            }
        }
    }
}
/**
 * {
 "errNum": 0,
 "errMsg": "success",
 "retData": {
 "city": "武汉",
 "cityid": "101200101",
 "today": {
 "date": "2016-01-04",
 "week": "星期一",
 "curTemp": "10℃",
 "aqi": "278",
 "fengxiang": "无持续风向",
 "fengli": "微风级",
 "hightemp": "13℃",
 "lowtemp": "6℃",
 "type": "小雨",
 "index": [
 {
 "name": "感冒指数",
 "code": "gm",
 "index": "",
 "details": "将有一次强降温过程，且空气湿度较大，极易发生感冒，请特别注意增加衣服保暖防寒。",
 "otherName": ""
 },
 {
 "code": "fs",
 "details": "属弱紫外辐射天气，长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。",
 "index": "弱",
 "name": "防晒指数",
 "otherName": ""
 },
 {
 "code": "ct",
 "details": "建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。",
 "index": "较冷",
 "name": "穿衣指数",
 "otherName": ""
 },
 {
 "code": "yd",
 "details": "有降水，推荐您在室内进行低强度运动；若坚持户外运动，须注意保暖，做好准备活动，携带雨具。",
 "index": "较不宜",
 "name": "运动指数",
 "otherName": ""
 },
 {
 "code": "xc",
 "details": "不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。",
 "index": "不宜",
 "name": "洗车指数",
 "otherName": ""
 },
 {
 "code": "ls",
 "details": "有降水，不适宜晾晒。若需要晾晒，请在室内准备出充足的空间。",
 "index": "不宜",
 "name": "晾晒指数",
 "otherName": ""
 }
 ]
 },
 "forecast": [
 {
 "date": "2016-01-05",
 "week": "星期二",
 "fengxiang": "无持续风向",
 "fengli": "微风级",
 "hightemp": "9℃",
 "lowtemp": "4℃",
 "type": "小雨"
 },
 {
 "date": "2016-01-06",
 "week": "星期三",
 "fengxiang": "无持续风向",
 "fengli": "微风级",
 "hightemp": "10℃",
 "lowtemp": "4℃",
 "type": "晴"
 },
 {
 "date": "2016-01-07",
 "week": "星期四",
 "fengxiang": "无持续风向",
 "fengli": "微风级",
 "hightemp": "10℃",
 "lowtemp": "0℃",
 "type": "小雨"
 },
 {
 "date": "2016-01-08",
 "week": "星期五",
 "fengxiang": "无持续风向",
 "fengli": "微风级",
 "hightemp": "10℃",
 "lowtemp": "1℃",
 "type": "多云"
 }
 ],
 "history": [
 {
 "date": "2015-12-28",
 "week": "星期一",
 "aqi": "154",
 "fengxiang": "无持续风向",
 "fengli": "微风级",
 "hightemp": "9℃",
 "lowtemp": "1℃",
 "type": "多云"
 },
 {
 "date": "2015-12-29",
 "week": "星期二",
 "aqi": "185",
 "fengxiang": "无持续风向",
 "fengli": "微风级",
 "hightemp": "10℃",
 "lowtemp": "1℃",
 "type": "多云"
 },
 {
 "date": "2015-12-30",
 "week": "星期三",
 "aqi": "245",
 "fengxiang": "无持续风向",
 "fengli": "微风级",
 "hightemp": "12℃",
 "lowtemp": "-1℃",
 "type": "多云"
 },
 {
 "date": "2015-12-31",
 "week": "星期四",
 "aqi": "136",
 "fengxiang": "无持续风向",
 "fengli": "微风级",
 "hightemp": "13℃",
 "lowtemp": "2℃",
 "type": "晴"
 },
 {
 "date": "2016-01-01",
 "week": "星期五",
 "aqi": "206",
 "fengxiang": "无持续风向",
 "fengli": "微风级",
 "hightemp": "12℃",
 "lowtemp": "3℃",
 "type": "阴"
 },
 {
 "date": "2016-01-02",
 "week": "星期六",
 "aqi": "177",
 "fengxiang": "无持续风向",
 "fengli": "微风级",
 "hightemp": "14℃",
 "lowtemp": "5℃",
 "type": "小雨"
 },
 {
 "date": "2016-01-03",
 "week": "星期天",
 "aqi": "158",
 "fengxiang": "无持续风向",
 "fengli": "微风级",
 "hightemp": "17℃",
 "lowtemp": "7℃",
 "type": "多云"
 }
 ]
 }
 }
 */
