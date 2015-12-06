package rustem.saitkulov.templatemvp.ui.main;

import android.app.Fragment;

import rustem.saitkulov.templatemvp.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected Fragment createFragment() {
        return new MainFragment();
    }

    @Override
    protected boolean isToolbarUpButtonAvailable() {
        return false;
    }
}