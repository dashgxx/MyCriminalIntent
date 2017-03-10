package com.example.xx.mycriminalintent;

import android.app.Fragment;
import android.util.Log;

/**
 * Created by XX on 2017/3/10.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

}
