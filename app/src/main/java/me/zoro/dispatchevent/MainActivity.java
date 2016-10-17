package me.zoro.dispatchevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import me.zoro.dispatchevent.spref.Setting;
import me.zoro.dispatchevent.view.FirstLayout;
import me.zoro.dispatchevent.view.LastView;
import me.zoro.dispatchevent.view.SecondLayout;
import me.zoro.dispatchevent.view.ThirdLayout;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.firstLayout)
    FirstLayout firstLayout;
    @BindView(R.id.secondLayout)
    SecondLayout secondLayout;
    @BindView(R.id.thirdLayout)
    ThirdLayout thirdLayout;
    @BindView(R.id.lastView)
    LastView lastView;
    @BindView(R.id.textLog)
    TextView textLog;

    @BindView(R.id.firstLayoutDispatch)
    SwitchCompat firstLayoutDispatch;
    @BindView(R.id.firstLayoutIntercept)
    SwitchCompat firstLayoutIntercept;
    @BindView(R.id.firstLayoutTouch)
    SwitchCompat firstLayoutTouch;

    @BindView(R.id.secondLayoutDispatch)
    SwitchCompat secondLayoutDispatch;
    @BindView(R.id.secondLayoutIntercept)
    SwitchCompat secondLayoutIntercept;
    @BindView(R.id.secondLayoutTouch)
    SwitchCompat secondLayoutTouch;

    @BindView(R.id.thirdLayoutDispatch)
    SwitchCompat thirdLayoutDispatch;
    @BindView(R.id.thirdLayoutIntercept)
    SwitchCompat thirdLayoutIntercept;
    @BindView(R.id.thirdLayoutTouch)
    SwitchCompat thirdLayoutTouch;

    @BindView(R.id.lastViewDispatch)
    SwitchCompat lastViewDispatch;
    @BindView(R.id.lastViewIntercept)
    SwitchCompat lastViewIntercept;
    @BindView(R.id.lastViewTouch)
    SwitchCompat lastViewTouch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        firstLayoutDispatch.setChecked(Setting.getInstance().getBoolean(Setting.KEY_FIRST_LAYOUT_DISPATCH, false));
        firstLayoutIntercept.setChecked(Setting.getInstance().getBoolean(Setting.KEY_FIRST_LAYOUT_INTERCEPT, false));
        firstLayoutTouch.setChecked(Setting.getInstance().getBoolean(Setting.KEY_FIRST_LAYOUT_TOUCH, false));

        secondLayoutDispatch.setChecked(Setting.getInstance().getBoolean(Setting.KEY_SECOND_LAYOUT_DISPATCH, false));
        secondLayoutIntercept.setChecked(Setting.getInstance().getBoolean(Setting.KEY_SECOND_LAYOUT_INTERCEPT, false));
        secondLayoutTouch.setChecked(Setting.getInstance().getBoolean(Setting.KEY_SECOND_LAYOUT_TOUCH, false));

        thirdLayoutDispatch.setChecked(Setting.getInstance().getBoolean(Setting.KEY_THIRD_LAYOUT_DISPATCH, false));
        thirdLayoutIntercept.setChecked(Setting.getInstance().getBoolean(Setting.KEY_THIRD_LAYOUT_INTERCEPT, false));
        thirdLayoutTouch.setChecked(Setting.getInstance().getBoolean(Setting.KEY_THIRD_LAYOUT_TOUCH, false));

        lastViewDispatch.setChecked(Setting.getInstance().getBoolean(Setting.KEY_LAST_VIEW_DISPATCH, false));
        lastViewIntercept.setChecked(Setting.getInstance().getBoolean(Setting.KEY_LAST_VIEW_INTERCEPT, false));
        lastViewTouch.setChecked(Setting.getInstance().getBoolean(Setting.KEY_LAST_VIEW_TOUCH, false));

        ILogListener logListener = new ILogListener() {
            @Override
            public void log(String info) {
                textLog.append("\n" + info);
            }
        };
        firstLayout.setLogListener(logListener);
        secondLayout.setLogListener(logListener);
        thirdLayout.setLogListener(logListener);
        lastView.setLogListener(logListener);
    }

    @OnClick(R.id.btnClean)
    public void clean() {
        textLog.setText("");
    }

    /*******
     * first
     ********/
    @OnCheckedChanged(R.id.firstLayoutDispatch)
    public void onFirstLayoutDispatch(boolean isChecked) {
        Setting.getInstance().putBoolean(Setting.KEY_FIRST_LAYOUT_DISPATCH, isChecked);
    }

    @OnCheckedChanged(R.id.firstLayoutIntercept)
    public void onFirstLayoutIntercept(boolean isChecked) {
        Setting.getInstance().putBoolean(Setting.KEY_FIRST_LAYOUT_INTERCEPT, isChecked);
    }

    @OnCheckedChanged(R.id.firstLayoutTouch)
    public void onFirstLayoutTouch(boolean isChecked) {
        Setting.getInstance().putBoolean(Setting.KEY_FIRST_LAYOUT_TOUCH, isChecked);
    }

    /*******
     * second
     ********/
    @OnCheckedChanged(R.id.secondLayoutDispatch)
    public void onSecondLayoutDispatch(boolean isChecked) {
        Setting.getInstance().putBoolean(Setting.KEY_SECOND_LAYOUT_DISPATCH, isChecked);
    }

    @OnCheckedChanged(R.id.secondLayoutIntercept)
    public void onSecondLayoutIntercept(boolean isChecked) {
        Setting.getInstance().putBoolean(Setting.KEY_SECOND_LAYOUT_INTERCEPT, isChecked);
    }

    @OnCheckedChanged(R.id.secondLayoutTouch)
    public void onSecondLayoutTouch(boolean isChecked) {
        Setting.getInstance().putBoolean(Setting.KEY_SECOND_LAYOUT_TOUCH, isChecked);
    }

    /*******
     * third
     ********/
    @OnCheckedChanged(R.id.thirdLayoutDispatch)
    public void onThirdLayoutDispatch(boolean isChecked) {
        Setting.getInstance().putBoolean(Setting.KEY_THIRD_LAYOUT_DISPATCH, isChecked);
    }

    @OnCheckedChanged(R.id.thirdLayoutIntercept)
    public void onThirdLayoutIntercept(boolean isChecked) {
        Setting.getInstance().putBoolean(Setting.KEY_THIRD_LAYOUT_INTERCEPT, isChecked);
    }

    @OnCheckedChanged(R.id.thirdLayoutTouch)
    public void onThirdLayoutTouch(boolean isChecked) {
        Setting.getInstance().putBoolean(Setting.KEY_THIRD_LAYOUT_TOUCH, isChecked);
    }

    /*******
     * last
     ********/
    @OnCheckedChanged(R.id.lastViewDispatch)
    public void onLastViewDispatch(boolean isChecked) {
        Setting.getInstance().putBoolean(Setting.KEY_LAST_VIEW_DISPATCH, isChecked);
    }

    @OnCheckedChanged(R.id.lastViewIntercept)
    public void onLastViewIntercept(boolean isChecked) {
        Setting.getInstance().putBoolean(Setting.KEY_LAST_VIEW_INTERCEPT, isChecked);
    }

    @OnCheckedChanged(R.id.lastViewTouch)
    public void onLastViewTouch(boolean isChecked) {
        Setting.getInstance().putBoolean(Setting.KEY_LAST_VIEW_TOUCH, isChecked);
    }


}
