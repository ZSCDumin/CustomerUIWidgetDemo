package com.edu.zscdm.alertdialogdemo;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_alertDialog)
    Button btnAlertDialog;
    @BindView(R.id.btn_progressDialog)
    Button btnProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_alertDialog, R.id.btn_progressDialog})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_alertDialog:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("对话框");
                dialog.setMessage("正在上传图片...");
                dialog.setCancelable(true);
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //逻辑代码
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //逻辑代码
                    }
                });
                dialog.show();
                break;
            case R.id.btn_progressDialog:
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("进度条对话框！");
                progressDialog.setMessage("正在加载...");
                progressDialog.setCancelable(true);//设置是否允许取消
                progressDialog.show();
                break;
        }
    }
}
