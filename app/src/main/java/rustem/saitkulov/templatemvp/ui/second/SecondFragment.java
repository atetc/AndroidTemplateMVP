package rustem.saitkulov.templatemvp.ui.second;

import rustem.saitkulov.templatemvp.R;
import rustem.saitkulov.templatemvp.ui.base.BaseFragment;

/**
 * @author Rustem
 */
public class SecondFragment extends BaseFragment<SecondView, SecondPresenter> implements SecondView {

    @Override
    protected int getContentResId() {
        return R.layout.fr_second;
    }

    @Override
    protected SecondPresenter createPresenter() {
        return new SecondPresenter();
    }

    @Override
    protected SecondView getBaseView() {
        return this;
    }
}
