package com.qianphone.mvprecever.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.qianphone.mvprecever.bean.Tngou;
import com.qianphone.mvprecever.model.MainModel;
import com.qianphone.mvprecever.view.MainView;

import java.util.List;

/**
 * Created by 周周 on 2016/8/21.
 */
public class MainPresenter extends MvpPresenter{
    private MainView mMainView;
    private MainModel mMainModel;
    public MainPresenter(MainView mainView){
        mMainView = mainView;
        mMainModel = new MainModel();
    }

    public void load(){
        mMainModel.getData(new MainModel.OnMainModelListener() {
            @Override
            public void getMainJson(String json) {
                Tngou tngou = new Gson().fromJson(json, Tngou.class);
                List<Tngou.TngouBean> tngou1 = tngou.getTngou();
                //Log.e("自定义标签", "类名==MainPresenter" + "方法名==getMainJson=====:" + tngou);
                mMainView.showView(tngou1);
            }
        });
    }
}
