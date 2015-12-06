package rustem.saitkulov.templatemvp.ui.second;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;

import rustem.saitkulov.templatemvp.ui.base.BaseActivity;

public class SecondActivity extends BaseActivity {

    public static void launch(Activity activity) {
        ActivityCompat.startActivity(activity, new Intent(activity, SecondActivity.class), null);
    }

    @Override
    protected Fragment createFragment() {
        return new SecondFragment();
    }
}