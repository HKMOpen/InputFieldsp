package com.iohkm.inputsugar;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by hesk on 16年11月18日.
 */

public class SugarSingleInput extends SugarBase {
    public SugarSingleInput(Context context) {
        super(context);
    }

    public SugarSingleInput(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SugarSingleInput(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private TextView mEd_label;
    private EditText text_field;

    public TextView getTextView() {
        return mEd_label;
    }

    public EditText getEdView() {
        return text_field;
    }

    @Override
    protected void init(Context context) {
        View me = LayoutInflater.from(context).inflate(R.layout.wrap_single_field, null, false);
        mEd_label = (TextView) me.findViewById(R.id.ed_label);
        text_field = (EditText) me.findViewById(R.id.ed_field);
        text_field.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (mEditChange != null) {
                    mEditChange.onChange(getId(), s.toString());
                }
                if (confirm_on_change_button) {

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
    }


}
