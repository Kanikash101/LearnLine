package spark.planet.com.learnline.utils;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * using it for showing any webView in the entire app
 *
 * Created by Sony on 1/7/2018.
 */

public class MyWebViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
