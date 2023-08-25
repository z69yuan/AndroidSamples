package com.beancurd.androidsamples;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 首页页面
 *
 * ASM的目标就是 将Toaster插入到HomeActivity中作为属性，并且在jumpForClick中进行调用
 *
 * @author beancurdv on 2023/8/25
 */
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViewById(R.id.btn_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumpForClick();
            }
        });
    }


    private void jumpForClick() {
        Log.i("beancurdv", "jumpForClick executing ...");
    }

}
