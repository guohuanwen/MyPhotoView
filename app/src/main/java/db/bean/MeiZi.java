package db.bean;

import java.util.List;

/**
 * Created by bigwen on 2015/12/8.
 */
public class MeiZi {

    /**
     * error : false
     * results : [{"who":"daimajia","publishedAt":"2015-12-08T04:09:51.810Z","desc":"12-8","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034gw1eyrfnh1fcuj20ey0mi3zz.jpg","used":true,"objectId":"56658f0000b0bf3758bae595","createdAt":"2015-12-07T13:52:00.795Z","updatedAt":"2015-12-08T04:09:52.482Z"},{"who":"代码家","publishedAt":"2015-12-07T13:51:02.006Z","desc":"12-7","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034gw1eyrfi5kot7j20f00f0q5o.jpg","used":true,"objectId":"56658dd460b21eab5d5f9e16","createdAt":"2015-12-07T13:47:00.929Z","updatedAt":"2015-12-07T13:51:02.640Z"},{"who":"张涵宇","publishedAt":"2015-12-04T04:00:24.522Z","desc":"12.4-补","type":"福利","url":"http://ww4.sinaimg.cn/large/7a8aed7bjw1eynh92kg6jj20dc0gqwho.jpg","used":true,"objectId":"56610c4400b0d1dba281422f","createdAt":"2015-12-04T03:45:08.030Z","updatedAt":"2015-12-04T04:00:25.913Z"},{"who":"张涵宇","publishedAt":"2015-12-03T03:55:57.075Z","desc":"12.3","type":"福利","url":"http://ww3.sinaimg.cn/large/7a8aed7bjw1eymacvzrz6j20e00k0gnm.jpg","used":true,"objectId":"565fb06b00b0bf37589336f6","createdAt":"2015-12-03T03:00:59.791Z","updatedAt":"2015-12-03T03:55:58.446Z"},{"who":"张涵宇","publishedAt":"2015-12-02T04:39:38.456Z","desc":"12.2","type":"福利","url":"http://ww2.sinaimg.cn/large/7a8aed7bjw1eyl43vfbndj20dw0ijmye.jpg","used":true,"objectId":"565e59cb00b08a6c00dd8a8f","createdAt":"2015-12-02T02:39:07.763Z","updatedAt":"2015-12-02T04:39:39.073Z"},{"who":"张涵宇","publishedAt":"2015-12-01T04:53:32.043Z","desc":"12.1","type":"福利","url":"http://ww4.sinaimg.cn/large/7a8aed7bjw1eyk28taztqj20hs0qotb8.jpg","used":true,"objectId":"565d26c160b20de5ec72f8b2","createdAt":"2015-12-01T04:49:05.652Z","updatedAt":"2015-12-01T04:53:35.263Z"},{"who":"张涵宇","publishedAt":"2015-11-30T04:29:00.710Z","desc":"11.30","type":"福利","url":"http://ww4.sinaimg.cn/large/7a8aed7bjw1eyirmivmh6j20f80m7abx.jpg","used":true,"objectId":"565bacb800b0ec3faa63f263","createdAt":"2015-11-30T01:56:08.264Z","updatedAt":"2015-11-30T04:29:01.548Z"},{"who":"张涵宇","publishedAt":"2015-11-27T04:11:49.799Z","desc":"11.27","type":"福利","url":"http://ww1.sinaimg.cn/large/7a8aed7bjw1eyfe319rvfj20hs0qo41p.jpg","used":true,"objectId":"5657d32000b0bf379efca6ce","createdAt":"2015-11-27T03:50:56.410Z","updatedAt":"2015-11-27T04:11:50.446Z"},{"who":"张涵宇","publishedAt":"2015-11-26T04:34:38.988Z","desc":"11.26","type":"福利","url":"http://ww2.sinaimg.cn/large/7a8aed7bjw1eye51p41xlj20go0m8mz0.jpg","used":true,"objectId":"565665ef00b0ec3faa3eb406","createdAt":"2015-11-26T01:52:47.955Z","updatedAt":"2015-11-26T04:34:40.456Z"},{"who":"张涵宇","publishedAt":"2015-11-25T03:57:07.114Z","desc":"11.25","type":"福利","url":"http://ww3.sinaimg.cn/large/7a8aed7bjw1eyd07uugyvj20qo0hqgom.jpg","used":true,"objectId":"56551ad300b0023c05c478c7","createdAt":"2015-11-25T02:20:03.201Z","updatedAt":"2015-11-25T03:57:07.858Z"}]
     */

    private boolean error;
    /**
     * who : daimajia
     * publishedAt : 2015-12-08T04:09:51.810Z
     * desc : 12-8
     * type : 福利
     * url : http://ww2.sinaimg.cn/large/610dc034gw1eyrfnh1fcuj20ey0mi3zz.jpg
     * used : true
     * objectId : 56658f0000b0bf3758bae595
     * createdAt : 2015-12-07T13:52:00.795Z
     * updatedAt : 2015-12-08T04:09:52.482Z
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
