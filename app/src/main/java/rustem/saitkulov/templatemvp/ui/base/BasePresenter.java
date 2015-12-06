package rustem.saitkulov.templatemvp.ui.base;

import android.app.LoaderManager;
import android.content.Context;

public abstract class BasePresenter<T extends BaseView> {

    private T mBaseView;

    /**
     * Activity context.
     */
    private Context mContext;

    /**
     * The loader manager.
     */
    private LoaderManager mLoaderManager;

    public void onCreate(Context context, LoaderManager loaderManager) {
        mContext = context;
        mLoaderManager = loaderManager;
    }

    public void onDestroy() {
        // Do nothing
    }

    public void onStart() {
        // Do nothing
    }

    public void onResume() {
        // Do nothing
    }

    public void onPause() {
        // Do nothing
    }

    public void onStop() {
        // Do nothing
    }

    public void attachView(T v) {
        mBaseView = v;
    }

    public T getView() {
        return mBaseView;
    }

    public Context getContext() {
        return mContext;
    }

    public LoaderManager getLoaderManager() {
        return mLoaderManager;
    }
}
