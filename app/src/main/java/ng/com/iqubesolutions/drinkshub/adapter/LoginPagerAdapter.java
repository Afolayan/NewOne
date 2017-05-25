package ng.com.iqubesolutions.drinkshub.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import ng.com.iqubesolutions.drinkshub.LoginFragment;
import ng.com.iqubesolutions.drinkshub.ui.SignupFragment;

/**
 * Created by Afolayan Oluwaseyi on 5/24/17.
 */

public class LoginPagerAdapter extends FragmentStatePagerAdapter {
    public static final int FRAGMENT_COUNT = 2;
    Context context;

    public LoginPagerAdapter(FragmentManager fm, Context mContext) {
        super(fm);
        this.context = mContext;
    }

    @Override
    public Fragment getItem(int position) {
        switch ( position ){
            case 0:
                return new LoginFragment();
            case 1:
                return new SignupFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch ( position ){
            case 0:
                return "Login";
            case 1:
                return "Sign up";
        }
        return null;
    }
}
