package spark.planet.com.learnline.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import spark.planet.com.learnline.R;
import spark.planet.com.learnline.utils.Constants;
import spark.planet.com.learnline.utils.MyWebViewClient;

/**
 * using it for showing image or webview in full screen
 *
 * Created by Sony on 1/7/2018.
 */

public class ImageWebViewDetailPageActivity extends AppCompatActivity{

    Intent in;
    String url, type;
    WebView wv_website;
    ImageView iv_photo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        //getting the intent
        in = getIntent();

        //getting the values passed from the previous activity
        url = in.getStringExtra("url");
        type = in.getStringExtra("type");

        // initialising the webView and imageView
        wv_website = findViewById(R.id.wv_website);
        iv_photo = findViewById(R.id.iv_photo);

        wv_website.setWebViewClient(new MyWebViewClient());

        // based on the type of the media show imageView or webView
        switch (type){
            case Constants.PHOTO:
                Glide.with(this)
                        .load(url)
                        .into(iv_photo);
                break;
            case Constants.WEBVIEW:
                iv_photo.setVisibility(View.GONE);
                wv_website.setVisibility(View.VISIBLE);
                wv_website.getSettings().setLoadsImagesAutomatically(true);
                wv_website.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                wv_website.loadUrl(url);
                break;
        }

    }
}
