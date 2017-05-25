package ng.com.iqubesolutions.drinkshub.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OLUWAPHEMMY on 9/22/2016.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragmentList = new ArrayList<>();
    private List<String> mFragmentTitleList = new ArrayList<>();
    private Context context;

    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapter(FragmentManager fm, Context mContext) {
        super(fm);
        this.context = mContext;
    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        return mFragmentList.get(position);


    }

    // This method return the fragment and title for the Tabs in the Tab Strip
    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "All Drinks";
            case 1:
                return "Soft Drinks";
            case 2:
                return "Beer";
            case 3:
                return "Wine & Spirit";
        }

        return mFragmentTitleList.get(position);
    }

    // This method return the Number of tabs for the tabs Strip
    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
