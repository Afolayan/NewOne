package ng.com.iqubesolutions.drinkshub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import ng.com.iqubesolutions.drinkshub.adapter.LoginPagerAdapter;
import ng.com.iqubesolutions.drinkshub.ui.SignupFragment;

public class LoginActivity extends AppCompatActivity
        implements LoginFragment.OnFragmentInteractionListener,
        SignupFragment.OnFragmentInteractionListener{

    private Toolbar mActionBarToolbar;
    private static final String TAG = LoginActivity.class.getSimpleName();
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        Toolbar toolbar = getActionBarToolbar();
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.colorAccent));

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(LoginActivity.this, MainActivity.class));
                LoginActivity.this.finish();
            }
        });

        toolbar.setNavigationIcon( ContextCompat.getDrawable(this, R.mipmap.ic_close_dialog));

        tabLayout = (TabLayout)findViewById(R.id.tabs);
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        viewPager.setAdapter(new LoginPagerAdapter(getSupportFragmentManager(), this));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setSelectedTabIndicatorHeight(6);
        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this, R.color.tab_selector));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.colorAccent));
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    protected Toolbar getActionBarToolbar() {
        if (mActionBarToolbar == null) {
            mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
            if (mActionBarToolbar != null) {
                setSupportActionBar(mActionBarToolbar);
            }
        }
        return mActionBarToolbar;
    }
}
