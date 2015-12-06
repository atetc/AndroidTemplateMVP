package rustem.saitkulov.templatemvp.ui.main;

import rustem.saitkulov.templatemvp.ui.base.BasePresenter;

public class MainPresenter extends BasePresenter<MainView> {

    public void onStartSecondScreenBtnClick() {
        getView().showNextScreen();
    }
}