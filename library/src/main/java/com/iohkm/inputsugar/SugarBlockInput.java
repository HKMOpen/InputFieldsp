package com.iohkm.inputsugar;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by hesk on 16年11月18日.
 */

public class SugarBlockInput extends SugarBase {
    public SugarBlockInput(Context context) {
        super(context);
    }

    public SugarBlockInput(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SugarBlockInput(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private TextView mEd_label, mCharNum;
    private EditText tved;

    public TextView getTextLabelView() {
        return mEd_label;
    }

    public EditText getEdView() {
        return tved;
    }

    protected void init(Context context) {
        View me = LayoutInflater.from(context).inflate(R.layout.wrap_block_field, null, false);
        mEd_label = (TextView) me.findViewById(R.id.ed_label);
        mCharNum = (TextView) me.findViewById(R.id.ed_char_count);
        tved = (EditText) me.findViewById(R.id.ed_field);
        tved.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCharNum.setText(String.valueOf(s.length()));
                if (mEditChange != null) {
                    mEditChange.onChange(getId(), s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void setDefaultValue(String infodata) {
        mEd_label.setText(infodata);
        mCharNum.setText(String.valueOf(infodata.length()));
    }

}
