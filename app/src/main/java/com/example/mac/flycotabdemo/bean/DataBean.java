/**
 * Copyright 2017 yidong
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.mac.flycotabdemo.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * 文 件 名: DataBean

 * 描   述：单类数据Pojo
 */
public class DataBean {


    /**
     * error : false
     * results : [{"_id":"593f2091421aa92c769a8c6a","createdAt":"2017-06-13T07:15:29.423Z","desc":"Android之自定义View：侧滑删除","publishedAt":"2017-06-15T13:55:57.947Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247484934&idx=1&sn=f2a40261efe8ebee45804e9df93c1cce&chksm=96cda74ba1ba2e5dbbac15a9e57b5329176d1fe43478e5c63f7bc502a6ca50e4dfa6c0a9041e#rd","used":true,"who":"陈宇明"},{"_id":"594109e5421aa92c769a8c84","createdAt":"2017-06-14T18:03:17.393Z","desc":"RecyclerView：利用打造悬浮效果","images":["http://img.gank.io/775b8ae5-4c21-4553-a77e-a0842248e1af"],"publishedAt":"2017-06-15T13:55:57.947Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/b335b620af39","used":true,"who":null},{"_id":"5941e2ac421aa92c7be61c14","createdAt":"2017-06-15T09:28:12.702Z","desc":"《From Java To Kotlin》从Java到Kotlin·译 （双语对比）","publishedAt":"2017-06-15T13:55:57.947Z","source":"web","type":"Android","url":"http://url.cn/4AS5wCG","used":true,"who":"陈宇明"},{"_id":"5941f5f3421aa92c7be61c16","createdAt":"2017-06-15T10:50:27.317Z","desc":"仿Nice首页图片列表9图样式，并实现拖拽效果","images":["http://img.gank.io/4f54c011-e293-436a-ada1-dc03669ffb10"],"publishedAt":"2017-06-15T13:55:57.947Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/0ea96b952170","used":true,"who":"兔子吃过窝边草"},{"_id":"59421faa421aa92c769a8c8e","createdAt":"2017-06-15T13:48:26.83Z","desc":"漂亮的波纹展开式搜索效果","publishedAt":"2017-06-15T13:55:57.947Z","source":"chrome","type":"Android","url":"https://github.com/didixyy/BilibiliSearchView","used":true,"who":"代码家"},{"_id":"5942200a421aa92c7be61c18","createdAt":"2017-06-15T13:50:02.743Z","desc":"目前最漂亮的一个 Dribbble 客户端，不能更好看！","images":["http://img.gank.io/f786c24f-235f-43ac-925f-2ae8406d0cd1","http://img.gank.io/e331b2b0-3854-4024-9bfc-c7687f132154","http://img.gank.io/efb20d5c-94de-4260-a3b0-63bcc2769a89"],"publishedAt":"2017-06-15T13:55:57.947Z","source":"chrome","type":"Android","url":"https://github.com/gejiaheng/Protein","used":true,"who":"代码家"},{"_id":"5942203b421aa92c73b6481c","createdAt":"2017-06-15T13:50:51.401Z","desc":"Android 轻量级 DeepLink 解决方案","images":["http://img.gank.io/2a24803a-5f2e-47af-a77d-4d24a00bf063"],"publishedAt":"2017-06-15T13:55:57.947Z","source":"chrome","type":"Android","url":"https://github.com/HongJun2046/OkDeepLink","used":true,"who":"Allen"},{"_id":"593a6015421aa92c769a8c43","createdAt":"2017-06-09T16:45:09.679Z","desc":"微信数据库组件，开源了～","publishedAt":"2017-06-14T11:34:54.556Z","source":"web","type":"Android","url":"https://github.com/Tencent/wcdb","used":true,"who":"color"},{"_id":"593f205e421aa92c73b64804","createdAt":"2017-06-13T07:14:38.148Z","desc":"又一个漂亮的 Gank 客户端！","images":["http://img.gank.io/6a80ddb8-646f-4177-bdae-d6066aa18982"],"publishedAt":"2017-06-14T11:34:54.556Z","source":"chrome","type":"Android","url":"https://github.com/yanyiqun001/ganguo","used":true,"who":"代码家"},{"_id":"593f2083421aa92c769a8c69","createdAt":"2017-06-13T07:15:15.25Z","desc":"歌词风格的 TextView，利用 Gradient 渐变实现。","images":["http://img.gank.io/738f9e17-60b8-4361-be84-3d11de47d4bc"],"publishedAt":"2017-06-14T11:34:54.556Z","source":"chrome","type":"Android","url":"https://github.com/livesun/GradientTextView","used":true,"who":"代码家"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean  {
        /**
         * _id : 593f2091421aa92c769a8c6a
         * createdAt : 2017-06-13T07:15:29.423Z
         * desc : Android之自定义View：侧滑删除
         * publishedAt : 2017-06-15T13:55:57.947Z
         * source : web
         * type : Android
         * url : https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247484934&idx=1&sn=f2a40261efe8ebee45804e9df93c1cce&chksm=96cda74ba1ba2e5dbbac15a9e57b5329176d1fe43478e5c63f7bc502a6ca50e4dfa6c0a9041e#rd
         * used : true
         * who : 陈宇明
         * images : ["http://img.gank.io/775b8ae5-4c21-4553-a77e-a0842248e1af"]
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }


    }
}
