package com.example.myapplication;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.flipboard.bottomsheet.BottomSheetLayout;
import com.flipboard.bottomsheet.commons.IntentPickerSheetView;

public class MainActivity extends AppCompatActivity implements TextWatcher {
    private Button button,button2;
    private LinearLayout linearLayout;
    private LottieAnimationView lottieAnimationView;
    private BottomSheetLayout bottomSheetLayout;
    private EditText editText;
    private boolean lock;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.submit);
        button2 = findViewById(R.id.bottomSheet);
        editText = findViewById(R.id.extended_edit_text);
        lottieAnimationView = findViewById(R.id.animation_view);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          lottieAnimationView.setAnimation("1818-success-animation.json");
                                          lottieAnimationView.playAnimation();
                                          lottieAnimationView.loop(true);

                                      }
                                  }
        );

        editText.addTextChangedListener(new MainActivity());
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (lock || s.length() > 16) {
            return;
        }
        lock = true;
        for (int i = 4; i < s.length(); i += 5) {
            if (s.toString().charAt(i) != ' ') {
                s.insert(i, " ");
            }
        }
        lock = false;
    }
}
