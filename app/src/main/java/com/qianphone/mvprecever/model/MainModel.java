package com.qianphone.mvprecever.model;

import com.qianphone.mvprecever.http.MainProtocol;

/**
 * Created by 周周 on 2016/8/21.
 */
public class MainModel implements MvpModel<MainModel.OnMainModelListener>{


    /**
     *  Model 层把数据得到就好 ,这一层,也不知道怎么处理数据,其实可以把json数据
     *  解析完了再传回去
     * @param onMainModelListener
     */
    @Override
    public void getData(OnMainModelListener onMainModelListener) {
       // new MainProtocol(onMainModelListener).getRequestForHttp();
        new MainProtocol(onMainModelListener).getRequestForVolley();
    }


     public interface OnMainModelListener{
        void getMainJson(String json);
    }
}
