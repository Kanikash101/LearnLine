package spark.planet.com.learnline.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import spark.planet.com.learnline.R;
import spark.planet.com.learnline.adapter.LearnLineAdapter;
import spark.planet.com.learnline.model.LearnLineMediaModel;
import spark.planet.com.learnline.model.LearnLineModel;
import spark.planet.com.learnline.utils.Constants;

/*
 * main content of the learnLine
 * launcher activity of the app
 *
 * Created by Sony on 1/6/2018.
 */

public class MainActivity extends AppCompatActivity{

    RecyclerView recyclerView;
    LearnLineAdapter learnLineAdapter;
    List<LearnLineModel> learnLineModelList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_learn_line_layout);

        // getting the reference of the recyclerView
        recyclerView = findViewById(R.id.rv_learn_line);

        learnLineModelList = new ArrayList<>();

        // initialise the list with data
        initialiseList();

        // initialising the adapter
        learnLineAdapter = new LearnLineAdapter(this,learnLineModelList);

        //setting the layout manager for the recyclerview
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        // attaching adapter to recyclerview
        recyclerView.setAdapter(learnLineAdapter);


    }

    /**
     * using it for initialising the list with some values
     */
    public void initialiseList(){

        List<LearnLineMediaModel> learnLineMediaModelList1 = new ArrayList<>();
        learnLineMediaModelList1.add(new LearnLineMediaModel("https://i.pinimg.com/736x/67/08/d6/6708d64f253a73a8539b2ff12191c705--go-math-maths-fun.jpg",Constants.PHOTO));
        learnLineMediaModelList1.add(new LearnLineMediaModel("_0NsV-tol7s",Constants.VIDEO));
        learnLineMediaModelList1.add(new LearnLineMediaModel("https://www.planetspark.in",Constants.WEBVIEW));

        learnLineModelList.add(new LearnLineModel("1","Addition without regrouping","100%", Constants.STATUS_COMPLETED, learnLineMediaModelList1));

        List<LearnLineMediaModel> learnLineMediaModelList2 = new ArrayList<>();
        learnLineMediaModelList2.add(new LearnLineMediaModel("https://s-media-cache-ak0.pinimg.com/originals/82/31/3d/82313dfbc0d86c59149b208872f29665.png",Constants.PHOTO));
        learnLineMediaModelList2.add(new LearnLineMediaModel("-QU8xG-molE",Constants.VIDEO));
        learnLineMediaModelList2.add(new LearnLineMediaModel("https://images-na.ssl-images-amazon.com/images/I/81zJFGnfJVL._SL1500_.jpg",Constants.PHOTO));
        learnLineMediaModelList2.add(new LearnLineMediaModel("https://www.google.co.in/",Constants.WEBVIEW));

        learnLineModelList.add(new LearnLineModel("2","Estimation","40%", Constants.STATUS_IN_PROGRESS, learnLineMediaModelList2));

        List<LearnLineMediaModel> learnLineMediaModelList3 = new ArrayList<>();
        learnLineMediaModelList3.add(new LearnLineMediaModel("https://cdn.turtlediary.com/worksheets/question/jumbled-words-to-form-a-sentence.png",Constants.PHOTO));
        learnLineMediaModelList3.add(new LearnLineMediaModel("uL6L74o-buw",Constants.VIDEO));
        learnLineMediaModelList3.add(new LearnLineMediaModel("https://image.slidesharecdn.com/tienganh2-131014212552-phpapp02/95/problems-and-solutions-in-learning-english-6-638.jpg?cb=1381786048",Constants.PHOTO));
        learnLineMediaModelList3.add(new LearnLineMediaModel("4-507VSAFLM",Constants.VIDEO));

        learnLineModelList.add(new LearnLineModel("3","Word problems 1","10%", Constants.STATUS_IN_PROGRESS, learnLineMediaModelList3));

        List<LearnLineMediaModel> learnLineMediaModelList4 = new ArrayList<>();
        learnLineMediaModelList4.add(new LearnLineMediaModel("http://www.exploringbinary.com/wp-content/uploads/BinaryMultiplicationExample.png",Constants.PHOTO));

        learnLineModelList.add(new LearnLineModel("4","Word problems 2","0%", Constants.STATUS_NOT_STARTED, learnLineMediaModelList4));


    }


}
