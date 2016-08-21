package com.qianphone.mvprecever.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.qianphone.mvprecever.R;
import com.qianphone.mvprecever.bean.Tngou;
import com.qianphone.mvprecever.presenter.MainPresenter;
import com.qianphone.mvprecever.view.MainView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MainPresenter(this).load();
    }

    @Override
    public void showView(final List<Tngou.TngouBean> tngous) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.e("自定义标签", "类名==MainActivity" + "方法名==run=====:" + tngous);
            }
        });
    }
}
