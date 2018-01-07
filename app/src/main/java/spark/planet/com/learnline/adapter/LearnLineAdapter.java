package spark.planet.com.learnline.adapter;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import spark.planet.com.learnline.R;
import spark.planet.com.learnline.activity.MainActivity;
import spark.planet.com.learnline.model.LearnLineModel;
import spark.planet.com.learnline.utils.Constants;

/*
 * using it for showing the title, status, progress of the particular topic in the recyclerView
 *
 * Created by Sony on 1/6/2018.
 */

public class LearnLineAdapter extends RecyclerView.Adapter<LearnLineAdapter.MyViewHolder> {

    private List<LearnLineModel> learnLineModelList;
    MainActivity mainActivity;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        //getting the references of fields of the layout
        TextView tv_title, tv_progress;
        ImageView iv_progress_color;
        ConstraintLayout cl_learn_line_feed;
        RecyclerView rv_learn_line_media;
        View view_line_2;

        public MyViewHolder(View view) {
            super(view);
            tv_title =  view.findViewById(R.id.tv_title);
            iv_progress_color = view.findViewById(R.id.iv_progress_color);
            tv_progress = view.findViewById(R.id.tv_progress);
            cl_learn_line_feed = view.findViewById(R.id.cl_learn_line_feed);
            rv_learn_line_media = view.findViewById(R.id.rv_learn_line_media);
            view_line_2 = view.findViewById(R.id.view_line_2);
        }
    }


    public LearnLineAdapter(MainActivity mainActivity,List<LearnLineModel> learnLineModelList) {
        this.learnLineModelList = learnLineModelList;
        this.mainActivity = mainActivity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating the layout
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.learn_line_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        // binding the data here
        // getting the model for each row
        final LearnLineModel learnLineModel = learnLineModelList.get(position);

        // setting the title in the textView
        holder.tv_title.setText(learnLineModel.getTitle());

        // setting the progress
        holder.tv_progress.setText(learnLineModel.getProgress());

        // based on the progress status set the color of the imageView
        switch (learnLineModel.getStatus()){
            // if it's completed
            case Constants.STATUS_COMPLETED:
                holder.iv_progress_color.setBackgroundColor(mainActivity.getResources().getColor(R.color.colorGreen));
                break;

            // if it's in progress
            case Constants.STATUS_IN_PROGRESS:
                holder.iv_progress_color.setBackgroundColor(mainActivity.getResources().getColor(R.color.colorYellow));
                break;

            // if it's not started
            case Constants.STATUS_NOT_STARTED:
                holder.iv_progress_color.setBackgroundColor(mainActivity.getResources().getColor(R.color.colorGrey));
                break;
        }

        // when user clicks on the row then the related media content will get opened below
        holder.cl_learn_line_feed.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // layout manager for the recyclerView
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                // setting the layout manager for the RecyclerView
                holder.rv_learn_line_media.setLayoutManager(linearLayoutManager);

                // making the RecyclerView visible
                holder.rv_learn_line_media.setVisibility(View.VISIBLE);
                holder.view_line_2.setVisibility(View.VISIBLE);

                // attaching the adapter to the RecyclerView
                LearnLineDetailCardAdapter learnLineDetailCardAdapter = new LearnLineDetailCardAdapter(mainActivity, learnLineModel.getLearnLineMediaModelList());
                holder.rv_learn_line_media.setAdapter(learnLineDetailCardAdapter);

            }
        });
    }

    @Override
    public int getItemCount() {
        return learnLineModelList.size();
    }
}