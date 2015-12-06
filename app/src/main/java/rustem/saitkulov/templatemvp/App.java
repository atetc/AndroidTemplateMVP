package rustem.saitkulov.templatemvp;

import android.app.Application;
import android.os.StrictMode;

/**
 * @author Rustem
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            StrictMode.enableDefaults();
        }
    }
}