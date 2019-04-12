package com.common.api;

/**
 * 作者：Sanerly
 * 时间；2019/3/26 14:44
 */
public interface Api {

    interface PaperApi {
        String BASE_URL = "http://service.picasso.adesk.com";
        //物语
        String PAPER_HOT = "/v1/vertical/category/4fb47a465ba1c65561000028/vertical?limit=30&order=new";
        //视觉
        String PAPER_NEW = "/v1/vertical/category/4fb479f75ba1c65561000027/vertical?limit=30&order=hot";
        //动漫最新
        String PAPER_ANIME = "/v1/vertical/category/4e4d610cdf714d2966000003/vertical?limit=30&order=new";

        //搜索 http://so.picasso.adesk.com/v1/search/wallpaper/resource/cc?limit=30&channel=360&adult=false&first=1&order=new
    }

    interface MovieApi{
        String BASE_URL = "https://api-m.mtime.cn";

        //正在售票
        String MOVIE_SOLD="/PageSubArea/HotPlayMovies.api?locationId=366";
        //正在热映
        String MOVIE_HOT="/PageSubArea/HotPlayMovies.api?locationId=366";
        //即将上映
        String MOVIE_COMING="/PageSubArea/HotPlayMovies.api?locationId=366";

    }
}
