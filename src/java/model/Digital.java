
package model;

public class Digital {
    private int id ;
    private String title ;
    private String description ;
    private String image ;
    private String author ;
    private String timePost ;
    private String shortDescription ;
    //default constructor
    public Digital() {
    }
    // constructor contains param
    public Digital(int id, String title, String description, String image, String author, String timePost, String shortDescription) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.author = author;
        this.timePost = timePost;
        this.shortDescription = shortDescription;
    }
    //get and set 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTimePost() {
        return timePost;
    }

    public void setTimePost(String timePost) {
        this.timePost = timePost;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Override
    public String toString() {
        return "Digital{" + "id=" + id + ", title=" + title + ", description=" + description + ", image=" + image + ", author=" + author + ", timePost=" + timePost + ", shortDescription=" + shortDescription + '}';
    }
    
    
    
}
