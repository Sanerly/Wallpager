package com.common.arouter;

/**
 * 作者：Sanerly
 * 时间：2019/3/7
 * 描述：地址
 */
public interface RouterUrl {


    /**
     * 首页
     */
    interface Home {
        String HOME = "/home";
       /*首页*/
        String ACTIVIYT_HOME =HOME + "/home";
    }

    /**
     * 壁纸
     */
    interface Paper{
        String PAPER = "/paper";
        /*壁纸*/
        String FRAGMENT_PAPER = PAPER + "/paper";
        //图片
        String FRAGMENT_PAPER_IMAGE = PAPER + "/image";
    }

    /**
     * 电影
     */
    interface Movie{
        String MOVIE = "/movie";
        /*电影*/
        String FRAGMENT_MOVIE = MOVIE + "/movie";

        String FRAGMENT_MOVIE_LIST = MOVIE + "/list";
    }

    /**
     * 阅读
     */
    interface Read{
        String READ = "/read";
        /*阅读*/
        String FRAGMENT_READ = READ + "/read";
    }

    /**
     * 我的
     */
    interface Mine{
        String MINE = "/mine";
        /*我的*/
        String FRAGMENT_MINE = MINE + "/mine";
    }


    interface AV{
        String AV = "/av";
        /*音频*/
        String ACTIVITY_AUDIO = AV + "/audio";
    }

}
