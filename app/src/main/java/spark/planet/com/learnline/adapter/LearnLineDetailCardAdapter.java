package spark.planet.com.learnline.adapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import spark.planet.com.learnline.R;
import spark.planet.com.learnline.activity.ImageWebViewDetailPageActivity;
import spark.planet.com.learnline.activity.MainActivity;
import spark.planet.com.learnline.activity.PlayVideo;
import spark.planet.com.learnline.model.LearnLineMediaModel;
import spark.planet.com.learnline.utils.Constants;
import spark.planet.com.learnline.utils.MyWebViewClient;

/**
 * showing the media content list of each item using this adapter
 * <p>
 * Created by Sony on 1/7/2018.
 */

public class LearnLineDetailCardAdapter extends RecyclerView.Adapter<LearnLineDetailCardAdapter.MyViewHolder> {

    private List<LearnLineMediaModel> learnLineMediaModelList;
    MainActivity mainActivity;
    Intent in;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // getting the references of the fields from the layout
        ImageView iv_feed_photo, player_view;
        WebView wv_website;
        CardView card_feed_photo;
        Button btn_new_page;

        public MyViewHolder(View view) {
            super(view);
            iv_feed_photo = view.findViewById(R.id.iv_feed_photo);
            player_view = view.findViewById(R.id.player_view);
            wv_website = view.findViewById(R.id.wv_website);
            card_feed_photo = view.findViewById(R.id.card_feed_photo);
            btn_new_page = view.findViewById(R.id.btn_new_page);
        }
    }


    public LearnLineDetailCardAdapter(MainActivity mainActivity, List<LearnLineMediaModel> learnLineMediaModelList) {
        this.learnLineMediaModelList = learnLineMediaModelList;
        this.mainActivity = mainActivity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.learn_line_detail_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        // binding data to view here
        // getting the model for each row
        final LearnLineMediaModel learnLineMediaModel = learnLineMediaModelList.get(position);

        String video_thumbnail;
        // setting the webViewClient for the webView
        holder.wv_website.setWebViewClient(new MyWebViewClient());

        // based on the type of media show content
        switch (learnLineMediaModel.getType()) {
            // if media is photo
            case Constants.PHOTO:
                holder.player_view.setVisibility(View.GONE);
                Glide.with(mainActivity)
                        .load(learnLineMediaModel.getUrl())
                        .into(holder.iv_feed_photo);
                break;

            // if media is video
            case Constants.VIDEO:
                video_thumbnail = "https://img.youtube.com/vi/" + learnLineMediaModel.getUrl() + "/0.jpg";
                Glide.with(mainActivity)
                        .load(video_thumbnail)
                        .into(holder.iv_feed_photo);
                holder.player_view.setVisibility(View.VISIBLE);
                break;

            // if media is webView
            case Constants.WEBVIEW:
                holder.iv_feed_photo.setVisibility(View.GONE);
                holder.wv_website.setVisibility(View.VISIBLE);
                holder.btn_new_page.setVisibility(View.VISIBLE);
                holder.wv_website.getSettings().setLoadsImagesAutomatically(true);
                holder.wv_website.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                holder.wv_website.loadUrl(learnLineMediaModel.getUrl());
                holder.player_view.setVisibility(View.GONE);
                break;
        }

        // on click listener for button new page
        // when user wants to open new window for the WebView
        holder.btn_new_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // using intent to open a new activity
                in = new Intent(mainActivity, ImageWebViewDetailPageActivity.class);
                in.putExtra("url", learnLineMediaModel.getUrl());
                in.putExtra("type", learnLineMediaModel.getType());
                mainActivity.startActivity(in);

            }
        });

        // on click listener for card feed photo
        // when user want to open a window for video or photo
        holder.card_feed_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (learnLineMediaModel.getType()) {
                    case Constants.PHOTO:
                        in = new Intent(mainActivity, ImageWebViewDetailPageActivity.class);
                        in.putExtra("url", learnLineMediaModel.getUrl());
                        in.putExtra("type", learnLineMediaModel.getType());
                        mainActivity.startActivity(in);
                        break;
                    case Constants.VIDEO:
                        in = new Intent(mainActivity, PlayVideo.class);
                        in.putExtra("video_id", learnLineMediaModel.getUrl());
                        mainActivity.startActivity(in);
                        break;

                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return learnLineMediaModelList.size();
    }
}
