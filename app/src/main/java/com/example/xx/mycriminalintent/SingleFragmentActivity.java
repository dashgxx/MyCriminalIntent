package com.example.xx.mycriminalintent;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * Created by XX on 2017/3/9.
 */

public abstract class SingleFragmentActivity extends Activity
{

    protected  abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm=getFragmentManager();

        Fragment fragment=fm.findFragmentById(R.id.fragment_container);
        if(fragment==null)
        {
            fragment=createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container,fragment)
                    .commit();
        }
    }
}
