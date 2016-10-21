package me.zoro.dispatchevent.utils;

import android.view.MotionEvent;

/**
 * Created by luguanquan on 2016/10/19.
 */

public class MyUtils {

    public static String motionEventName(MotionEvent event) {
        String name = null;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                name = "DOWN";
                break;
            case MotionEvent.ACTION_UP:
                name = "UP";
                break;
            case MotionEvent.ACTION_MOVE:
                name = "MOVE";
                break;
            default:
                name = "OTHER_EVENT";
        }
        return name;
    }
}
