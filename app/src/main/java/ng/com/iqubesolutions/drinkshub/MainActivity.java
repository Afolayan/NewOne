package ng.com.iqubesolutions.drinkshub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import ng.com.iqubesolutions.drinkshub.adapter.ViewPagerAdapter;
import ng.com.iqubesolutions.drinkshub.ui.AllDrinksFragment;
import ng.com.iqubesolutions.drinkshub.ui.BeerFragment;
import ng.com.iqubesolutions.drinkshub.ui.MainLoginFragment;
import ng.com.iqubesolutions.drinkshub.ui.SignupFragment;
import ng.com.iqubesolutions.drinkshub.ui.SoftDrinksFragment;
import ng.com.iqubesolutions.drinkshub.ui.WineSpiritFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationDrawerFragment.FragmentDrawerListener,
        LoginFragment.OnFragmentInteractionListener,
        MainFragment.OnFragmentInteractionListener, MainLoginFragment.OnFragmentInteractionListener,
        SignupFragment.OnFragmentInteractionListener
{

    private static final String TAG = MainActivity.class.getSimpleName();
    private NavigationDrawerFragment drawerFragment;
    AllDrinksFragment allDrinksFragment;
    SoftDrinksFragment softDrinksFragment;
    BeerFragment beerFragment;
    WineSpiritFragment wineSpiritFragment;

    Fragment fragment;
    Boolean action = false;
    int page = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.colorAccent));
        setSupportActionBar(toolbar);
        /**
         * Navigation Drawer Implementation starts from here
         */
       FragmentManager fragmentManager = getSupportFragmentManager();
        /* fragmentManager.beginTransaction().replace(R.id.container_body, fragment).commit();*/



        drawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);

        /**
         * and ends here
         */

        /**
         * Declaration for fragments in/and tablayout starts here
         */

        allDrinksFragment = new AllDrinksFragment();
        softDrinksFragment = new SoftDrinksFragment();
        beerFragment = new BeerFragment();
        wineSpiritFragment = new WineSpiritFragment();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this, R.color.tab_selector));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.colorAccent));
        tabLayout.setSelectedTabIndicatorHeight(6);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
        adapter.addFragment(allDrinksFragment, "All Drinks");
        adapter.addFragment(softDrinksFragment, "Soft Drinks");
        adapter.addFragment(beerFragment, "Beer");
        adapter.addFragment(wineSpiritFragment, "Wine&Spirit");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        if (drawerFragment.isDrawerOpen()) {
            drawerFragment.closeDrawer();

        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        /*if (id == R.id.action_items) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
          action = false;
        switch( position){
            case 0:

            case 1: {
                page = 1;
                getSupportActionBar().setTitle("DrinksHub");
                startActivity(new Intent( this, MainActivity.class));
                this.finish();
                action = true;
                return;
            }
            case 2: {
                page = 2;
                //change fragment class as appropriate
                fragment = new MainFragment();
                action = true;
                break;
            }
            case 3: {
                page = 3;
                startActivity(new Intent( this, LoginActivity.class));
                action = true;
                return;
            }
            case 4: {
                page = 4;
                fragment = new MainFragment();
                action = true;
                break;
            }
            default: {
                startActivity(new Intent( this, MainActivity.class));
                this.finish();
            }
        }
        if (action) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container_body, fragment)
                    .commit();
        }

    }
}
