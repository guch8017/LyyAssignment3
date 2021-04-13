package com.github.guch8017.assignment3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText mUsernameET;
    private EditText mPasswordET;
    private Button mButton;
    private boolean first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        WebView view = findViewById(R.id.test);
        mUsernameET = findViewById(R.id.et_uid);
        mPasswordET = findViewById(R.id.et_pwd);
        mButton = findViewById(R.id.btn_login);
        mButton.setClickable(false);
        first = false;
        view.getSettings().setJavaScriptEnabled(true);
        view.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Log.d("TEST", "shouldOverrideUrlLoading: Url: " + request.getUrl().toString());
                view.loadUrl(request.getUrl().toString());
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                Log.d("TEST", "onPageFinished: Url: " + url);
                if(url.endsWith("/login")){
                    if(!first){
                        first = true;
                    } else {
                        findViewById(R.id.t_wrong_password).setVisibility(View.VISIBLE);
                    }
                    mButton.setClickable(true);
                }else{
                    Toast.makeText(getApplicationContext(), "Login successfully, redirect to homepage", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent();
                    intent.putExtra(Constant.LOGIN_RESULT, Constant.LOGIN_SUCCESS);
                    setResult(RESULT_OK, intent);
                    finish();
                }

            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButton.setClickable(false);
                view.loadUrl("javascript: (function(){document.getElementsByName('login-subject')[0].value = '" + mUsernameET.getText() + "';" +
                        "document.getElementsByName('password')[0].value = '" + mPasswordET.getText() + "';" +
                        "document.getElementsByClassName('cursor-pointer icon-input-submit')[0].click();})()");
            }
        });
        view.loadUrl(Constant.HOST_URL + Constant.LOGIN_S);

    }
}
