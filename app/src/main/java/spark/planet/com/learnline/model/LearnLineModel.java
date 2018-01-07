package spark.planet.com.learnline.model;

/*
 * used for the adapter of the recyclerView
 * contains fields for storing the list of images, videos, webViews etc
 * and the title, status and progress.
 * using it in LearnLineAdapter
 *
 * Created by Sony on 1/6/2018.
 */

import java.util.List;

public class LearnLineModel {

    private String id;
    private String title;
    private String progress;
    private String status;
    private List<LearnLineMediaModel> learnLineMediaModelList;

    public LearnLineModel(String id,String title, String progress, String status, List<LearnLineMediaModel> learnLineMediaModelList) {
        this.id = id;
        this.title = title;
        this.progress = progress;
        this.status = status;
        this.learnLineMediaModelList = learnLineMediaModelList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<LearnLineMediaModel> getLearnLineMediaModelList() {
        return learnLineMediaModelList;
    }

    public void setLearnLineMediaModelList(List<LearnLineMediaModel> learnLineMediaModelList) {
        this.learnLineMediaModelList = learnLineMediaModelList;
    }

}
