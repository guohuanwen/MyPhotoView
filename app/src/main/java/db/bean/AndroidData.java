package db.bean;

import java.util.List;

/**
 * Created by bigwen on 2015/12/9.
 */
public class AndroidData {
    /**
     * error : false
     * results : [{"who":"LHF","publishedAt":"2015-12-09T04:24:10.408Z","desc":"【Android效果集】学习ExplosionField之粒子破碎效果","type":"Android","url":"http://blog.csdn.net/xieyupeng520/article/details/49951835","used":true,"objectId":"5666f7fc00b0a9f1b6ce1ecf","createdAt":"2015-12-08T15:32:12.877Z","updatedAt":"2015-12-09T04:24:11.827Z"},{"who":"LHF","publishedAt":"2015-12-09T04:24:10.407Z","desc":"Art of Android Development Reading Notes","type":"Android","url":"http://hujiaweibujidao.github.io/blog/2015/12/05/Art-of-Android-Development-Reading-Notes/","used":true,"objectId":"5666cb2860b2298fddd900d7","createdAt":"2015-12-08T12:20:56.733Z","updatedAt":"2015-12-09T04:24:11.802Z"},{"who":"wuzheng","publishedAt":"2015-12-09T04:24:10.400Z","desc":"FinestWebView-Android","type":"Android","url":"https://github.com/TheFinestArtist/FinestWebView-Android","used":true,"objectId":"566128fd00b0ec3f656267f7","createdAt":"2015-12-04T05:47:41.025Z","updatedAt":"2015-12-09T04:24:11.821Z"},{"who":"wuzheng","publishedAt":"2015-12-09T04:24:10.399Z","desc":"FinestWebView-Android","type":"Android","url":"https://github.com/TheFinestArtist/FinestWebView-Android","used":true,"objectId":"566128fc60b25b797d0d31b3","createdAt":"2015-12-04T05:47:40.952Z","updatedAt":"2015-12-09T04:24:11.863Z"},{"who":"LHF","publishedAt":"2015-12-09T04:24:10.397Z","desc":"视频: Android Studio for Experts（各种实用技巧，可惜听不懂，不知道快捷键）","type":"Android","url":"http://v.youku.com/v_show/id_XMTM5NTY3MDY1Mg==.html","used":true,"objectId":"5655ceda60b294bc674a90ee","createdAt":"2015-11-25T15:08:10.677Z","updatedAt":"2015-12-09T04:24:11.831Z"},{"who":"MVP","publishedAt":"2015-12-09T04:24:10.387Z","desc":"理解 React diff 原理，有利于写出高性能的 React 应用","type":"Android","url":"http://zhuanlan.zhihu.com/purerender/20346379","used":true,"objectId":"564a93a260b259caed36374f","createdAt":"2015-11-17T02:40:34.814Z","updatedAt":"2015-12-09T04:24:11.798Z"},{"who":"wuzheng","publishedAt":"2015-12-08T04:09:51.807Z","desc":"WheelPicker","type":"Android","url":"https://github.com/AigeStudio/WheelPicker","used":true,"objectId":"5664defd60b204d55d556bcf","createdAt":"2015-12-07T01:21:01.816Z","updatedAt":"2015-12-08T04:09:52.461Z"},{"who":"LHF","publishedAt":"2015-12-08T04:09:51.806Z","desc":"解决 singleTask onActivityResult() 无效的问题","type":"Android","url":"http://mthli.github.io/singleTask-onActivityResult/","used":true,"objectId":"5663cade00b0ec3f65748ea5","createdAt":"2015-12-06T05:42:54.817Z","updatedAt":"2015-12-08T04:09:52.543Z"},{"who":"LHF","publishedAt":"2015-12-08T04:09:51.804Z","desc":"Android性能优化之被忽视的优化点","type":"Android","url":"http://android.jobbole.com/82182/","used":true,"objectId":"5663ba5760b2d140d331a14c","createdAt":"2015-12-06T04:32:23.346Z","updatedAt":"2015-12-08T04:09:52.536Z"},{"who":"LHF","publishedAt":"2015-12-08T04:09:51.802Z","desc":"22个值得收藏的Android开源代码-UI篇","type":"Android","url":"http://www.imooc.com/article/2448","used":true,"objectId":"5662dea860b202595a5edf33","createdAt":"2015-12-05T12:55:04.591Z","updatedAt":"2015-12-08T04:09:52.541Z"}]
     */

    private boolean error;
    /**
     * who : LHF
     * publishedAt : 2015-12-09T04:24:10.408Z
     * desc : 【Android效果集】学习ExplosionField之粒子破碎效果
     * type : Android
     * url : http://blog.csdn.net/xieyupeng520/article/details/49951835
     * used : true
     * objectId : 5666f7fc00b0a9f1b6ce1ecf
     * createdAt : 2015-12-08T15:32:12.877Z
     * updatedAt : 2015-12-09T04:24:11.827Z
     */

    private List<ResultsEntity> results;

    public void setError(boolean error) {
        this.error = error;
    }

    public void setResults(List<ResultsEntity> results) {
        this.results = results;
    }

    public boolean isError() {
        return error;
    }

    public List<ResultsEntity> getResults() {
        return results;
    }

    public static class ResultsEntity {
        private String who;
        private String publishedAt;
        private String desc;
        private String type;
        private String url;
        private boolean used;
        private String objectId;
        private String createdAt;
        private String updatedAt;

        public void setWho(String who) {
            this.who = who;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getWho() {
            return who;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public String getDesc() {
            return desc;
        }

        public String getType() {
            return type;
        }

        public String getUrl() {
            return url;
        }

        public boolean isUsed() {
            return used;
        }

        public String getObjectId() {
            return objectId;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }
    }
}
