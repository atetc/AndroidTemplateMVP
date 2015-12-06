package rustem.saitkulov.templatemvp.ui.main;

import android.widget.Button;

import butterknife.Bind;
import butterknife.OnClick;
import rustem.saitkulov.templatemvp.R;
import rustem.saitkulov.templatemvp.ui.base.BaseFragment;
import rustem.saitkulov.templatemvp.ui.second.SecondActivity;

public class MainFragment extends BaseFragment<MainView, MainPresenter> implements MainView {

    @Bind(R.id.secondScreenBtn)
    Button mStartSecondScreenBtn;

    @Override
    protected int getContentResId() {
        return R.layout.fr_main;
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected MainView getBaseView() {
        return this;
    }

    @OnClick(R.id.secondScreenBtn)
    public void submit() {
        getPresenter().onStartSecondScreenBtnClick();
    }

    @Override
    public void showNextScreen() {
        SecondActivity.launch(getActivity());
    }
}