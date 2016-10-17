package me.zoro.dispatchevent.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import me.zoro.dispatchevent.ILogListener;
import me.zoro.dispatchevent.spref.Setting;

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
        boolean result = Setting.getInstance().getBoolean(Setting.KEY_LAST_VIEW_DISPATCH, false);
        if (logListener != null) {
            logListener.log("LastView.dispatchTouchEvent " + result);
        }
        System.out.println("LastView.dispatchTouchEvent " + result);
        super.dispatchTouchEvent(event);
        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = Setting.getInstance().getBoolean(Setting.KEY_LAST_VIEW_TOUCH, false);
        if (logListener != null) {
            logListener.log("LastView.onTouchEvent " + result);
        }
        System.out.println("LastView.onTouchEvent " + result);
        super.onTouchEvent(event);
        return result;
    }
}
