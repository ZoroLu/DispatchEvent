package me.zoro.dispatchevent.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.zoro.dispatchevent.R;

/**
 * Created by luguanquan on 2016/10/21.
 */

public class DispatchSwitch extends FrameLayout {

    public static final int STATE_OR_INDEX_TRUE = 0;
    public static final int STATE_OR_INDEX_FALSE = 1;
    public static final int STATE_OR_INDEX_SUPER = 2;

    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.radioTrue)
    RadioButton radioTrue;
    @BindView(R.id.radioFalse)
    RadioButton radioFalse;
    @BindView(R.id.radioSuper)
    RadioButton radioSuper;

    public interface OnDispatchStateChangeListener {
        void onCheckedChanged(DispatchSwitch view, int checkedIndex);
    }

    private OnDispatchStateChangeListener listener;

    public void setListener(OnDispatchStateChangeListener listener) {
        this.listener = listener;
    }

    public DispatchSwitch(Context context) {
        this(context, null);
    }

    public DispatchSwitch(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DispatchSwitch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.dispatch_switch, this);
        ButterKnife.bind(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index = STATE_OR_INDEX_TRUE;
                switch (checkedId) {
                    case R.id.radioTrue:
                        index = STATE_OR_INDEX_TRUE;
                        break;
                    case R.id.radioFalse:
                        index = STATE_OR_INDEX_FALSE;
                        break;
                    case R.id.radioSuper:
                        index = STATE_OR_INDEX_SUPER;
                        break;
                    default:

                }
                if (listener != null) {
                    listener.onCheckedChanged(DispatchSwitch.this, index);
                }
                System.out.println(index);
            }
        });
    }

    public void setSelectedState(int index) {
        switch (index) {
            case STATE_OR_INDEX_TRUE:
                radioTrue.setChecked(true);
                break;
            case STATE_OR_INDEX_FALSE:
                radioFalse.setChecked(true);
                break;
            case STATE_OR_INDEX_SUPER:
                radioSuper.setChecked(true);
            default:
        }
    }
}
