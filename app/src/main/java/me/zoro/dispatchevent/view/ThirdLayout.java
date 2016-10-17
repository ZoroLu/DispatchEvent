package me.zoro.dispatchevent.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import me.zoro.dispatchevent.ILogListener;
import me.zoro.dispatchevent.spref.Setting;

/**
 * Created by luguanquan on 2016/10/17.
 */

public class ThirdLayout extends FrameLayout {

    public ThirdLayout(Context context) {
        super(context);
    }

    public ThirdLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ThirdLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private ILogListener logListener;

    public void setLogListener(ILogListener logListener) {
        this.logListener = logListener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = Setting.getInstance().getBoolean(Setting.KEY_THIRD_LAYOUT_TOUCH, false);
        if (logListener != null) {
            logListener.log("ThirdLayout.onTouchEvent " + result);
        }
        System.out.println("ThirdLayout.onTouchEvent " + result);
        super.onTouchEvent(event);
        return result;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean result = Setting.getInstance().getBoolean(Setting.KEY_THIRD_LAYOUT_INTERCEPT, false);
        if (logListener != null) {
            logListener.log("ThirdLayout.onInterceptTouchEvent " + result);
        }
        System.out.println("ThirdLayout.onInterceptTouchEvent " + result);
        super.onInterceptTouchEvent(ev);
        return result;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean result = Setting.getInstance().getBoolean(Setting.KEY_THIRD_LAYOUT_DISPATCH, false);
        if (logListener != null) {
            logListener.log("ThirdLayout.dispatchTouchEvent " + result);
        }
        System.out.println("ThirdLayout.dispatchTouchEvent " + result);
        super.dispatchTouchEvent(ev);
        return result;
    }
}
