package me.zoro.dispatchevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.zoro.dispatchevent.spref.Setting;
import me.zoro.dispatchevent.utils.MyUtils;
import me.zoro.dispatchevent.view.DispatchSwitch;
import me.zoro.dispatchevent.view.FirstLayout;
import me.zoro.dispatchevent.view.LastView;
import me.zoro.dispatchevent.view.SecondLayout;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.firstLayout)
    FirstLayout firstLayout;
    @BindView(R.id.secondLayout)
    SecondLayout secondLayout;
    @BindView(R.id.lastView)
    LastView lastView;
    @BindView(R.id.textLog)
    TextView textLog;

    //Activity
    @BindView(R.id.switchActivityDispatch)
    DispatchSwitch switchActivityDispatch;
    @BindView(R.id.switchActivityTouch)
    DispatchSwitch switchActivityTouch;

    //FirstLayout
    @BindView(R.id.switchFirstDispatch)
    DispatchSwitch switchFirstDispatch;
    @BindView(R.id.switchFirstIntercept)
    DispatchSwitch switchFirstIntercept;
    @BindView(R.id.switchFirstTouch)
    DispatchSwitch switchFirstTouch;

    //SecondLayout
    @BindView(R.id.switchSecondDispatch)
    DispatchSwitch switchSecondDispatch;
    @BindView(R.id.switchSecondIntercept)
    DispatchSwitch switchSecondIntercept;
    @BindView(R.id.switchSecondTouch)
    DispatchSwitch switchSecondTouch;

    //LastView
    @BindView(R.id.switchLastDispatch)
    DispatchSwitch switchLastDispatch;
    @BindView(R.id.switchLastTouch)
    DispatchSwitch switchLastTouch;

    ILogListener logListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initWidgets();
    }

    private void initWidgets() {

        switchActivityDispatch.setSelectedState(Setting.getInstance().getInt(Setting.KEY_ACTIVITY_LAYOUT_DISPATCH, DispatchSwitch.STATE_OR_INDEX_SUPER));
        switchActivityTouch.setSelectedState(Setting.getInstance().getInt(Setting.KEY_ACTIVITY_LAYOUT_TOUCH, DispatchSwitch.STATE_OR_INDEX_SUPER));

        switchFirstDispatch.setSelectedState(Setting.getInstance().getInt(Setting.KEY_FIRST_LAYOUT_DISPATCH, DispatchSwitch.STATE_OR_INDEX_SUPER));
        switchFirstIntercept.setSelectedState(Setting.getInstance().getInt(Setting.KEY_FIRST_LAYOUT_INTERCEPT, DispatchSwitch.STATE_OR_INDEX_SUPER));
        switchFirstTouch.setSelectedState(Setting.getInstance().getInt(Setting.KEY_FIRST_LAYOUT_TOUCH, DispatchSwitch.STATE_OR_INDEX_SUPER));


        switchSecondDispatch.setSelectedState(Setting.getInstance().getInt(Setting.KEY_SECOND_LAYOUT_DISPATCH, DispatchSwitch.STATE_OR_INDEX_SUPER));
        switchSecondIntercept.setSelectedState(Setting.getInstance().getInt(Setting.KEY_SECOND_LAYOUT_INTERCEPT, DispatchSwitch.STATE_OR_INDEX_SUPER));
        switchSecondTouch.setSelectedState(Setting.getInstance().getInt(Setting.KEY_SECOND_LAYOUT_TOUCH, DispatchSwitch.STATE_OR_INDEX_SUPER));

        switchLastDispatch.setSelectedState(Setting.getInstance().getInt(Setting.KEY_LAST_VIEW_DISPATCH, DispatchSwitch.STATE_OR_INDEX_SUPER));
        switchLastTouch.setSelectedState(Setting.getInstance().getInt(Setting.KEY_LAST_VIEW_TOUCH, DispatchSwitch.STATE_OR_INDEX_SUPER));

        DispatchSwitch.OnDispatchStateChangeListener dispatchStateChangeListener = new DispatchSwitch.OnDispatchStateChangeListener() {
            @Override
            public void onCheckedChanged(DispatchSwitch view, int checkedIndex) {
                String key = null;
                switch (view.getId()) {
                    case R.id.switchActivityDispatch:
                        key = Setting.KEY_ACTIVITY_LAYOUT_DISPATCH;
                        break;
                    case R.id.switchActivityTouch:
                        key = Setting.KEY_LAST_VIEW_TOUCH;
                        break;
                    case R.id.switchFirstDispatch:
                        key = Setting.KEY_FIRST_LAYOUT_DISPATCH;
                        break;
                    case R.id.switchFirstIntercept:
                        key = Setting.KEY_FIRST_LAYOUT_INTERCEPT;
                        break;
                    case R.id.switchFirstTouch:
                        key = Setting.KEY_FIRST_LAYOUT_TOUCH;
                        break;
                    case R.id.switchSecondDispatch:
                        key = Setting.KEY_SECOND_LAYOUT_DISPATCH;
                        break;
                    case R.id.switchSecondIntercept:
                        key = Setting.KEY_SECOND_LAYOUT_INTERCEPT;
                        break;
                    case R.id.switchSecondTouch:
                        key = Setting.KEY_SECOND_LAYOUT_TOUCH;
                        break;
                    case R.id.switchLastDispatch:
                        key = Setting.KEY_LAST_VIEW_DISPATCH;
                        break;
                    case R.id.switchLastTouch:
                        key = Setting.KEY_LAST_VIEW_TOUCH;
                        break;
                    default:
                        key = null;
                }
                if (key != null) {
                    Setting.getInstance().putInt(key, checkedIndex);
                }
            }
        };

        switchActivityDispatch.setListener(dispatchStateChangeListener);
        switchActivityTouch.setListener(dispatchStateChangeListener);

        switchFirstDispatch.setListener(dispatchStateChangeListener);
        switchFirstIntercept.setListener(dispatchStateChangeListener);
        switchFirstTouch.setListener(dispatchStateChangeListener);

        switchSecondDispatch.setListener(dispatchStateChangeListener);
        switchSecondIntercept.setListener(dispatchStateChangeListener);
        switchSecondTouch.setListener(dispatchStateChangeListener);

        switchLastDispatch.setListener(dispatchStateChangeListener);
        switchLastTouch.setListener(dispatchStateChangeListener);

        logListener = new ILogListener() {
            @Override
            public void log(String info) {
                textLog.append("\n" + info);
            }
        };
        firstLayout.setLogListener(logListener);
        secondLayout.setLogListener(logListener);
        lastView.setLogListener(logListener);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (isInFirstLayout(ev)) {
            boolean result;
            String info = "MainActivity.dispatchTouchEvent " + MyUtils.motionEventName(ev);
            logListener.log(info);
            switch (Setting.getInstance().getInt(Setting.KEY_ACTIVITY_LAYOUT_DISPATCH, DispatchSwitch.STATE_OR_INDEX_SUPER)) {
                case DispatchSwitch.STATE_OR_INDEX_TRUE:
                    result = true;
                    break;
                case DispatchSwitch.STATE_OR_INDEX_FALSE:
                    result = false;
                    break;
                case DispatchSwitch.STATE_OR_INDEX_SUPER:
                default:
                    result = super.dispatchTouchEvent(ev);
                    break;
            }
            return result;
        }
        return super.dispatchTouchEvent(ev);
    }

    private boolean isInFirstLayout(MotionEvent ev) {
        int x = (int) ev.getRawX();
        int y = (int) ev.getRawY();
        int[] location = new int[2];
        firstLayout.getLocationOnScreen(location);
        int width = firstLayout.getWidth();
        int height = firstLayout.getHeight();
        if (location[0] < x && x < location[0] + width && location[1] < y && y < location[1] + height) {
            return true;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (isInFirstLayout(event)) {
            boolean result;
            String info = "MainActivity.onTouchEvent " + MyUtils.motionEventName(event);
            logListener.log(info);
            switch (Setting.getInstance().getInt(Setting.KEY_ACTIVITY_LAYOUT_TOUCH, DispatchSwitch.STATE_OR_INDEX_SUPER)) {
                case DispatchSwitch.STATE_OR_INDEX_TRUE:
                    result = true;
                    break;
                case DispatchSwitch.STATE_OR_INDEX_FALSE:
                    result = false;
                    break;
                case DispatchSwitch.STATE_OR_INDEX_SUPER:
                default:
                    result = super.onTouchEvent(event);
                    break;
            }
            return result;
        }
        return super.onTouchEvent(event);
    }

    @OnClick(R.id.btnClean)
    public void clean() {
        textLog.setText("");
    }


}
