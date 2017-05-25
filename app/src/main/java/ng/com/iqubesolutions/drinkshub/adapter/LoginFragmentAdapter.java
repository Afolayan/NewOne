package ng.com.iqubesolutions.drinkshub.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ng.com.iqubesolutions.drinkshub.LoginFragment;
import ng.com.iqubesolutions.drinkshub.ui.SignupFragment;

/**
 * Created by iqube on 5/24/17.
 */

public class LoginFragmentAdapter extends FragmentPagerAdapter {
    public static final int FRAGMENT_COUNT = 2;
    public LoginFragmentAdapter(FragmentManager fm) {
        super(fm);
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
