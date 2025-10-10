package CommentsTask;

public class Comment {
    private String name;
    private String comment;
    private int likesQty;

    public Comment(String name, String comment, int likesQty) {
        this.name = name;
        this.comment = comment;
        this.likesQty = likesQty;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public int getLikesQty() {
        return likesQty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setLikesQty(int likesQty) {
        this.likesQty = likesQty;
    }
}

