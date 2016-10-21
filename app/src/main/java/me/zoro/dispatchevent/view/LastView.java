package me.zoro.dispatchevent.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import me.zoro.dispatchevent.ILogListener;
import me.zoro.dispatchevent.spref.Setting;
import me.zoro.dispatchevent.utils.MyUtils;

/**
 * Created by luguanquan on 2016/10/17.
 */

public class LastView extends View {

    public LastView(Context context) {
        super(context);
    }

    public LastView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LastView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private ILogListener logListener;

    public void setLogListener(ILogListener logListener) {
        this.logListener = logListener;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        String info = "LastView.dispatchTouchEvent " + MyUtils.motionEventName(event) ;
        logListener.log(info);
        boolean result;
        switch (Setting.getInstance().getInt(Setting.KEY_LAST_VIEW_DISPATCH, DispatchSwitch.STATE_OR_INDEX_SUPER)) {
            case DispatchSwitch.STATE_OR_INDEX_TRUE:
                result = true;
                break;
            case DispatchSwitch.STATE_OR_INDEX_FALSE:
                result = false;
                break;
            case DispatchSwitch.STATE_OR_INDEX_SUPER:
            default:
                result = super.dispatchTouchEvent(event);
                break;
        }
        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        String info = "LastView.onTouchEvent " + MyUtils.motionEventName(event) ;
        logListener.log(info);
        boolean result;
        switch (Setting.getInstance().getInt(Setting.KEY_LAST_VIEW_TOUCH, DispatchSwitch.STATE_OR_INDEX_SUPER)) {
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
}
