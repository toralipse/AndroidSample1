package com.example.toralipse.apptest;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button pd_button,google_button,other_button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pd_button = (Button)findViewById(R.id.pd_button);
        pd_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.planningdev.com/"));
                startActivity(next);
            }
        });
        google_button = (Button)findViewById(R.id.google_button);
        google_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.co.jp/"));
                startActivity(next);
            }
        });
        other_button = (Button)findViewById(R.id.other_button);
        other_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(next);
            }
        });
    }


    public static class TestFragment extends Fragment {

        public static Fragment onNewInstance(int color){
            TestFragment f = new TestFragment();
            Bundle b = new Bundle();
            b.putInt("color",color);
            f.setArguments(b);
            return f;
        }

        int color;

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            color = getArguments().getInt("color");
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = new View(getActivity());
            v.setBackgroundColor(color);
            return v;
        }
    }


}
