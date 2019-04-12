package com.sanerly.base.util;

import android.support.annotation.Nullable;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.CsvFormatStrategy;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * 作者：Sanerly
 * 时间；2019/3/16 16:01
 */
public class LogUtils {

    public static void init(){
        /*FormatStrategy strategy= PrettyFormatStrategy.newBuilder().showThreadInfo(false).build();*/

        Logger.addLogAdapter(new AndroidLogAdapter());
    }


    public static void d(@Nullable Object object){
        Logger.d(object);
    }

    public static void e(@Nullable String message){
        Logger.e(message);
    }

    public static void i(@Nullable String message){
        Logger.i(message);
    }
}
