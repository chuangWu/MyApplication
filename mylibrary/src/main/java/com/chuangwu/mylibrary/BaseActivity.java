package com.chuangwu.mylibrary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * @author : created by chuangWu
 * @version : 0.01
 * @email : chuangwu127@gmail.com
 * @created time : 2015-11-11 11:59
 * @description : none
 * @for your attention : none
 * @revise : none
 */
public abstract class BaseActivity extends Activity {

    protected View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rootView = LayoutInflater.from(this).inflate(getLayoutId(), null);
        setContentView(rootView);
        ButterKnife.bind(this);
        initView();
        initListener();
        initData();

    }

    @LayoutRes
    protected abstract int getLayoutId();

    protected void initView() {

    }

    protected void initListener() {

    }

    protected void initData() {

    }

    protected void next(Class<? extends Activity> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }


    protected void showToast(@NonNull int resId) {
        showToast(getString(resId));
    }

    protected void showToast(@NonNull String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    public void nextFinish(Class<? extends Activity> cls) {
        next(cls);
        finish();
    }
}
