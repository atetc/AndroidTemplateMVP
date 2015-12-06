package rustem.saitkulov.templatemvp.ui.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseFragment<K extends BaseView, T extends BasePresenter<K>> extends Fragment implements BaseView {

    private T mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = createPresenter();
        mPresenter.onCreate(getActivity(), getLoaderManager());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getContentResId(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    protected abstract int getContentResId();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getPresenter().attachView(getBaseView());
    }

    @Override
    public void onStart() {
        super.onStart();

        mPresenter.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();

        mPresenter.onResume();
    }

    @Override
    public void onPause() {
        mPresenter.onPause();

        super.onPause();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();

        super.onStop();
    }

    @Override
    public void onDestroy() {
        mPresenter.onDestroy();

        super.onDestroy();
    }

    @Override
    public void showProgress(boolean inProgress) {
    }

    @Override
    public void showLoadingError(boolean isVisible) {
    }

    protected abstract T createPresenter();

    protected abstract K getBaseView();

    protected final T getPresenter() {
        return mPresenter;
    }

    protected final BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }

}
