/**
 * Copyright 2017 yidong
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.mac.flycotabdemo.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.mac.flycotabdemo.MainActivity;
import com.example.mac.flycotabdemo.R;
import com.example.mac.flycotabdemo.Utils.PermissionsChecker;
import com.example.mac.flycotabdemo.Utils.ToastUtil;
import com.example.mac.flycotabdemo.view.PathTextView;
import com.yanzhenjie.alertdialog.AlertDialog;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RationaleListener;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


/**
 * 文 件 名: WelcomeActivity
 * 描   述：欢迎页，splash页面
 */
public class WelcomeActivity extends AppCompatActivity {


    String TAG = "WelcomeActivity";

    PermissionsChecker checker;
    private final String[] PERMISSIONS = new String[]{

            Manifest.permission.CALL_PHONE,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);

        PathTextView pathTextView = (PathTextView) findViewById(R.id.ptv);
        pathTextView.init("weiliang");


        checker = new PermissionsChecker(this);
        AndPermission.with(this)
                .requestCode(200)
                .permission(
                        PERMISSIONS
                )
                .rationale(rationaleListener)
                .callback(listener)
                .start();
      //  gotoHome();

    }

    private void gotoHome() {
      Observable.timer(4000, TimeUnit.MILLISECONDS)
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(new Observer<Long>() {
                  @Override
                  public void onSubscribe(Disposable d) {

                  }

                  @Override
                  public void onNext(Long value) {
                      directToHome();
                  }

                  @Override
                  public void onError(Throwable e) {

                  }

                  @Override
                  public void onComplete() {

                  }
              });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 200: {
                // 设置之后在这里检查你需要的权限是否被允许，并做相应的操作。

                if (checker.lacksPermissions(PERMISSIONS)) {
                    //重新申请
                    AndPermission.with(this)
                            .requestCode(200)
                            .permission(
                                    PERMISSIONS
                            )
                            .rationale(rationaleListener)
                            .callback(listener)
                            .start();

                } else {

                    //ToastUtil.showToast(WelcomeActivity.this, "授权成功");
                    Log.d(TAG, "授权成功: ");
                    directToHome();
                }

                break;
            }
        }
    }

    private RationaleListener rationaleListener = new RationaleListener() {
        @Override
        public void showRequestPermissionRationale(int requestCode, final Rationale rationale) {

            AlertDialog.newBuilder(WelcomeActivity.this)
                    .setTitle("友好提醒")
                    .setMessage("你已拒绝过权限")
                    .setPositiveButton("好，给你", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            rationale.resume();
                        }
                    })
                    .setNegativeButton("我拒绝", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            rationale.cancel();
                        }
                    }).show();
        }
    };

    private PermissionListener listener = new PermissionListener() {
        @Override
        public void onSucceed(int requestCode, List<String> grantedPermissions) {
            if (requestCode == 200) {
                Log.d(TAG, "授权成功: ");
                //ToastUtil.showToast(WelcomeActivity.this, "授权成功");
                directToHome();
            }
        }

        @Override
        public void onFailed(int requestCode, List<String> deniedPermissions) {
            // 权限申请失败回调。
            if (requestCode == 200) {

                // 是否有不再提示并拒绝的权限。
                if (AndPermission.hasAlwaysDeniedPermission(WelcomeActivity.this, deniedPermissions)) {
                    AndPermission.defaultSettingDialog(WelcomeActivity.this, 200)
                            .setTitle("权限申请失败")
                            .setMessage("您拒绝了我们必要的一些权限，请在设置中授权！否则无法运行！")
                            .setPositiveButton("好，去设置")
                            .setNegativeButton("拒绝", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            })
                            .show();

                } else {
                    AndPermission.defaultSettingDialog(WelcomeActivity.this, 200)
                            .setTitle("权限申请失败")
                            .setMessage("您拒绝了我们必要的一些权限，已经没法愉快的玩耍了，请在设置中授权！")
                            .setPositiveButton("好，去设置")
                            .setNegativeButton("拒绝", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            })
                            .show();

                }
            }
        }
    };

    private void directToHome() {
        Intent intent = new Intent();
        intent.setClass(WelcomeActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
