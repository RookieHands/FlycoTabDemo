package com.example.mac.flycotabdemo.http;

import com.example.mac.flycotabdemo.bean.DataBean;

import io.reactivex.Observable;

import io.reactivex.Observer;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * 文 件 名: ContentService
 * 描   述：Retrofit api接口
 */
public interface ContentService {

    @GET("data/{category}/{pagesize}/{pagenum}")
    Observable<DataBean> getContent(
            @Path("category") String category, @Path("pagesize") String pagesize,
            @Path("pagenum") int pagenum);


}
