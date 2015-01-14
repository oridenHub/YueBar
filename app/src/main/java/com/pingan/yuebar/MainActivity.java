package com.pingan.yuebar;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.pingan.yuebar.fragment.DiscoverFragment;
import com.pingan.yuebar.fragment.MainFragment;
import com.pingan.yuebar.fragment.ProfileFragment;
import com.pingan.yuebar.fragment.TitleBarFragment;

import java.util.logging.Logger;


public class MainActivity extends Activity implements View.OnClickListener{

    private ImageButton ib_main;
    private ImageButton ib_profile;
    private ImageButton ib_discover;
    private View currentButton;
    private TitleBarFragment titleBarFragment;
    private MainFragment mainFragment;
    private DiscoverFragment discoverFragment;
    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleBarFragment = (TitleBarFragment) getFragmentManager().findFragmentById(R.id.fl_title_bar);

        ib_main = (ImageButton) findViewById(R.id.buttom_main);
        ib_profile = (ImageButton) findViewById(R.id.buttom_profile);
        ib_discover = (ImageButton) findViewById(R.id.buttom_discover);

        ib_main.setOnClickListener(this);
        ib_discover.setOnClickListener(this);
        ib_profile.setOnClickListener(this);

        setDefaultFragment(ib_main);
    }

    private void setDefaultFragment(View v) {

            if(titleBarFragment != null){
                titleBarFragment.setTitleName("周末去哪儿");
            }else{
                Toast.makeText(MainActivity.this, "出错啦", Toast.LENGTH_LONG).show();
            }

            MainFragment mainFragment = new MainFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fl_content, mainFragment);
            fragmentTransaction.commit();
            setButton(v);
    }

    private void setButton(View v){
        if (currentButton != null && currentButton.getId() != v.getId()) {
            currentButton.setEnabled(true);
        }
        v.setEnabled(false);
        currentButton = v;
    }

    private void setTitleName(String titleName){
        if(titleBarFragment != null){
            titleBarFragment.setTitleName(titleName);
        }else{
            Toast.makeText(MainActivity.this, "出错啦", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (v.getId()) {
            case R.id.buttom_main:   //点击‘活动’菜单，转到‘活动’页面
                setTitleName("周末去哪儿");
                if (mainFragment == null) {
                    mainFragment = new MainFragment();
                }
                // 使用当前Fragment的布局替代id_content的控件
                fragmentTransaction.replace(R.id.fl_content, mainFragment);
                setButton(v);
                break;
            case R.id.buttom_discover:  //点击‘发现’菜单，转到‘发现’页面
                setTitleName("发现");
                if (discoverFragment == null) {
                    discoverFragment = new DiscoverFragment();
                }
                fragmentTransaction.replace(R.id.fl_content, discoverFragment);
                setButton(v);
                break;
            case R.id.buttom_profile:  //点击‘我’菜单，转到‘我’页面
                setTitleName("我的");
                if (profileFragment == null) {
                    profileFragment = new ProfileFragment();
                }
                fragmentTransaction.replace(R.id.fl_content, profileFragment);
                setButton(v);
                break;
        }

        // 事务提交
        fragmentTransaction.commit();
    }
}
