package com.example.jxg.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

//import static android.text.TextUtils.isEmpty;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toast.makeText(MainActivity.this, String.valueOf(isNetworkConnected()), Toast.LENGTH_LONG).show();//查询网络状态
//        Toast.makeText(MainActivity.this, String.valueOf(getNetworkType()), Toast.LENGTH_LONG).show();//查询网络类型
        Toast.makeText(MainActivity.this, String.valueOf(isNetworkConnected(MainActivity.this)), Toast.LENGTH_LONG).show();//查询网络状态
//        dialog();
//        dialog1();
//        dialog2();
//        dialog3();
//        dialog4();
//        dialog5();
    }

    /**
     * 检测网络是否可用
     *
     * @return
     */
    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return ni != null && ni.isConnectedOrConnecting();
    }

    /**
     * 获取当前网络类型
     *
     * @return 0：没有网络   1：WIFI网络   2：WAP网络    3：NET网络
     */

//    public static final int NETTYPE_WIFI = 0x01;
//    public static final int NETTYPE_CMWAP = 0x02;
//    public static final int NETTYPE_CMNET = 0x03;
    public static final String NETTYPE_WIFI = "WIFI网络";
    public static final String NETTYPE_CMWAP = "WAP网络";
    public static final String NETTYPE_CMNET = "NET网络";

    public String getNetworkType() {
        String netType = "没有网络";
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null) {
            return netType;
        }
        int nType = networkInfo.getType();
        if (nType == ConnectivityManager.TYPE_MOBILE) {
            String extraInfo = networkInfo.getExtraInfo();
            if (!TextUtils.isEmpty(extraInfo)) {
                if (extraInfo.toLowerCase().equals("cmnet")) {
                    netType = NETTYPE_CMNET;
                } else {
                    netType = NETTYPE_CMWAP;
                }
            }
        } else if (nType == ConnectivityManager.TYPE_WIFI) {
            netType = NETTYPE_WIFI;
        }
        return netType;
    }


    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("确认退出吗？");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                MainActivity.this.finish();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    protected void dialog1() {
        Dialog dialog = new AlertDialog.Builder(this).setIcon(
                android.R.drawable.btn_star).setTitle("喜好调查").setMessage(
                "你喜欢李连杰的电影吗？").setPositiveButton("很喜欢",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        Toast.makeText(MainActivity.this, "我很喜欢他的电影。",
                                Toast.LENGTH_LONG).show();
                    }
                }).setNegativeButton("不喜欢", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this, "我不喜欢他的电影。", Toast.LENGTH_LONG)
                        .show();
            }
        }).setNeutralButton("一般", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this, "谈不上喜欢不喜欢。", Toast.LENGTH_LONG).show();
            }
        }).create();
        dialog.show();
    }

    protected void dialog2() {
        new AlertDialog.Builder(this).setTitle("请输入").setIcon(
                android.R.drawable.ic_dialog_info).setView(
                new EditText(this)).setPositiveButton("确定", null)
                .setNegativeButton("取消", null).show();
    }

    protected void dialog3() {
        new AlertDialog.Builder(this).setTitle("复选框").setMultiChoiceItems(
                new String[]{"Item1", "Item2"}, null, null)
                .setPositiveButton("确定", null)
                .setNegativeButton("取消", null).show();
    }

    protected void dialog4() {
        new AlertDialog.Builder(this).setTitle("单选框").setIcon(
                android.R.drawable.ic_dialog_info).setSingleChoiceItems(
                new String[]{"Item1", "Item2"}, 0,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setNegativeButton("取消", null).show();
    }

    protected void dialog5() {
        new AlertDialog.Builder(this).setTitle("列表框").setItems(
                new String[]{"Item1", "Item2"}, null).setNegativeButton(
                "确定", null).show();
    }
//    protected void dialog6() {
//        LayoutInflater inflater = getLayoutInflater();
//        View layout = inflater.inflate(R.layout.dialog,
//                (ViewGroup) findViewById(R.id.dialog));
//        new AlertDialog.Builder(this).setTitle("自定义布局").setView(layout)
//                .setPositiveButton("确定", null)
//                .setNegativeButton("取消", null).show();
//    }

    public boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }//,判断是否有网络连接
    public boolean isWifiConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mWiFiNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (mWiFiNetworkInfo != null) {
                return mWiFiNetworkInfo.isAvailable();
            }
        }
        return false;
    }//判断WIFI网络是否可用
    public boolean isMobileConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mMobileNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (mMobileNetworkInfo != null) {
                return mMobileNetworkInfo.isAvailable();
            }
        }
        return false;
    }//判断MOBILE网络是否可用

}
