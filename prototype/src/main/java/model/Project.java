package model;

public class Project {

    private String title;

    private String repoLink;

    private String filePath;

    public Project(String title, String repoLink, String filePath) {
        this.title = title;
        this.repoLink = repoLink;
        this.filePath = filePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRepoLink() {
        return repoLink;
    }

    public void setRepoLink(String repoLink) {
        this.repoLink = repoLink;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}