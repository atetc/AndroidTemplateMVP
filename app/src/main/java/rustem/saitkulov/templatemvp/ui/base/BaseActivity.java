package rustem.saitkulov.templatemvp.ui.base;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Bind;

import rustem.saitkulov.templatemvp.R;

public abstract class BaseActivity extends AppCompatActivity {

    @Bind(R.id.appBarLayout)
    AppBarLayout mAppBarLayout;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutResource());
        ButterKnife.bind(this);

        if (isToolbarAvailable()) {
            mAppBarLayout.setVisibility(View.VISIBLE);
            setSupportActionBar(mToolbar);

            final ActionBar actionBar = getSupportActionBar();
            if (actionBar != null && isToolbarUpButtonAvailable()) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
                actionBar.setHomeButtonEnabled(true);
            }
        }

        if (savedInstanceState == null) {
            Fragment fragment = createFragment();
            if (fragment != null) {
                replaceFragment(fragment);
            } else {
                finish();
            }
        }
    }

    protected int getLayoutResource() {
        return R.layout.ac_single_frame;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected boolean isToolbarAvailable() {
        return true;
    }

    protected boolean isToolbarUpButtonAvailable() {
        return true;
    }

    protected abstract Fragment createFragment();

    public final Toolbar getToolbar() {
        return mToolbar;
    }

    public void replaceFragment(final Fragment fragment) {
        replaceFragment(fragment, false);
    }

    protected void replaceFragment(Fragment fragment, boolean withBackStack) {
        @SuppressLint("CommitTransaction")
        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction()
                .replace(R.id.fr_container, fragment);

        if (withBackStack) {
            transaction.addToBackStack(null);
        }

        transaction.commit();
    }
}
