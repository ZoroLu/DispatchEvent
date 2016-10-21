package me.zoro.dispatchevent.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import me.zoro.dispatchevent.ILogListener;
import me.zoro.dispatchevent.spref.Setting;
import me.zoro.dispatchevent.utils.MyUtils;

/**
 * Created by luguanquan on 2016/10/17.
 */

public class SecondLayout extends FrameLayout {

    public SecondLayout(Context context) {
        super(context);
    }

    public SecondLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SecondLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private ILogListener logListener;

    public void setLogListener(ILogListener logListener) {
        this.logListener = logListener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result;
        switch (Setting.getInstance().getInt(Setting.KEY_SECOND_LAYOUT_TOUCH, DispatchSwitch.STATE_OR_INDEX_SUPER)) {
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
        String info = "SecondLayout.dispatchTouchEvent " + MyUtils.motionEventName(event) + " " + result;
        logListener.log(info);
        return result;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        String info = "SecondLayout.onInterceptTouchEvent " + MyUtils.motionEventName(ev);
        logListener.log(info);
        boolean result;
        switch (Setting.getInstance().getInt(Setting.KEY_SECOND_LAYOUT_INTERCEPT, DispatchSwitch.STATE_OR_INDEX_SUPER)) {
            case DispatchSwitch.STATE_OR_INDEX_TRUE:
                result = true;
                break;
            case DispatchSwitch.STATE_OR_INDEX_FALSE:
                result = false;
                break;
            case DispatchSwitch.STATE_OR_INDEX_SUPER:
            default:
                result = super.onInterceptTouchEvent(ev);
                break;
        }
        return result;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        String info = "SecondLayout.dispatchTouchEvent " + MyUtils.motionEventName(ev);
        logListener.log(info);
        boolean result;
        switch (Setting.getInstance().getInt(Setting.KEY_SECOND_LAYOUT_DISPATCH, DispatchSwitch.STATE_OR_INDEX_SUPER)) {
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
}
