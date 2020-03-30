package com.dxminds.mvvmexample;

import android.os.Handler;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    public MutableLiveData<String> loginStatus = new MutableLiveData<String>();

    public void doLogin(String userName, String password) {
        UserModel userModel = new UserModel(userName, password);
        final int code = userModel.checkUserValidity(userName, password);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String msg;
                if (code == 0) {
                    msg = "Login Successful";
                } else {
                    msg = "Login Fail";
                }
                loginStatus.postValue(msg);
            }
        }, 2000);
    }
}
