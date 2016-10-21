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

public class FirstLayout extends FrameLayout {

    public FirstLayout(Context context) {
        super(context);
    }

    public FirstLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FirstLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private ILogListener logListener;

    public void setLogListener(ILogListener logListener) {
        this.logListener = logListener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        String info = "FirstLayout.onTouchEvent " + MyUtils.motionEventName(event);
        logListener.log(info);
        boolean result;
        switch (Setting.getInstance().getInt(Setting.KEY_FIRST_LAYOUT_TOUCH, DispatchSwitch.STATE_OR_INDEX_SUPER)) {
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

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        String info = "FirstLayout.onInterceptTouchEvent " + MyUtils.motionEventName(ev);
        logListener.log(info);
        boolean result;
        switch (Setting.getInstance().getInt(Setting.KEY_FIRST_LAYOUT_INTERCEPT, DispatchSwitch.STATE_OR_INDEX_SUPER)) {
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
        String info = "FirstLayout.dispatchTouchEvent " + MyUtils.motionEventName(ev);
        logListener.log(info);
        boolean result;
        switch (Setting.getInstance().getInt(Setting.KEY_FIRST_LAYOUT_DISPATCH, DispatchSwitch.STATE_OR_INDEX_SUPER)) {
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
