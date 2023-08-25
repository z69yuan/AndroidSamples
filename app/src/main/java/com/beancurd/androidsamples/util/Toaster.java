package com.beancurd.androidsamples.util;

import android.content.Context;
import android.widget.Toast;

/**
 * toaster 工具类
 *
 * @author beancurd on 2023/8/25
 */
public class Toaster {

    private Context mContext;

    Toaster(Context context) {
        this.mContext = context;
    }

    void show(String content) {
        Toast.makeText(mContext, content, Toast.LENGTH_SHORT).show();
    }
}
