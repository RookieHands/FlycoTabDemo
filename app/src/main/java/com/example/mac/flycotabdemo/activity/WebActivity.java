package com.example.mac.flycotabdemo.activity;

import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.mac.flycotabdemo.R;
import com.example.mac.flycotabdemo.Utils.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebActivity extends AppCompatActivity {

    public static final String TAG = "WebActivity";
    @BindView(R.id.tl_web)
    Toolbar tlWeb;
    @BindView(R.id.progressbar)
    ProgressBar progressbar;
    @BindView(R.id.wv_content)
    WebView wvContent;
    private String urls;

    @BindView(R.id.rl_error)
    RelativeLayout rlError;

    boolean isError = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorbg), 0);
        urls = getIntent().getStringExtra("url");
        setSupportActionBar(tlWeb);
        tlWeb.setNavigationIcon(R.drawable.back);
        tlWeb.setTitleTextAppearance(this, R.style.ToolBarTextAppearance);
        initWebViewSettings();
        wvContent.loadUrl(urls);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.web_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                if (wvContent.canGoBack()) {
                    wvContent.goBack();
                } else {
                    finish();
                }

                break;

            case R.id.share: {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, urls);
                startActivity(Intent.createChooser(intent, getTitle()));
            }
            break;
            case R.id.openinbrowse: {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(urls));
                startActivity(intent);
            }
            break;
            case R.id.copyurl: {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(
                        CLIPBOARD_SERVICE);
                clipboardManager.setText(urls);
                Snackbar.make(tlWeb, "已复制到剪切板", Snackbar.LENGTH_SHORT).show();
            }
            break;
            case R.id.refresh: {
                wvContent.reload();
            }
        }
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && wvContent.canGoBack()) {
            wvContent.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private void initWebViewSettings() {

        WebSettings settings = wvContent.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setAppCacheEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setSupportZoom(true);

        wvContent.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

                progressbar.setProgress(newProgress);
                if (newProgress == 100) {
                    progressbar.setVisibility(View.GONE);
                } else {
                    progressbar.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);

                setTitle(title);

            }
        });

        wvContent.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                if (url != null) view.loadUrl(url);
                return true;
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                isError = true;

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                if (isError) {
                    wvContent.setVisibility(View.GONE);
                    rlError.setVisibility(View.VISIBLE);
                    isError = false;
                } else {
                    wvContent.setVisibility(View.VISIBLE);
                    rlError.setVisibility(View.GONE);
                }
            }
        });
    }

}
