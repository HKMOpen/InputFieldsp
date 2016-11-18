package com.iohkm.inputsugar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by hesk on 16年11月18日.
 */

public abstract class SugarBase extends RelativeLayout {
    protected EditChange mEditChange;
    protected boolean confirm_on_change_button = false;

    public SugarBase(Context context) {
        super(context);
        init(context);
    }

    public SugarBase(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SugarBase(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    protected abstract void init(Context context);

    public abstract void setDefaultValue(String infodata);

    public void setEditChange(EditChange listener) {
        mEditChange = listener;
    }

    public void showConfirmButton(boolean enabled) {
        confirm_on_change_button = enabled;
    }
}
