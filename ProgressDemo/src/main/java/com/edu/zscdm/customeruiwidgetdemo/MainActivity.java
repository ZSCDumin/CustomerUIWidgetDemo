package com.edu.zscdm.customeruiwidgetdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.textView)
    TextView textView;
    private int progress;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    progressBar.setProgress(progress);
                    textView.setText(progress+"%");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        updateProgress();
        progressBar.setVisibility(View.VISIBLE);
    }

    public void updateProgress() {
        progress = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progress < 100) {
                    try {
                        Thread.sleep(1000);
                        mHandler.sendEmptyMessage(0);
                        progress += 1;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}