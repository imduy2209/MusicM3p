package com.example.musicm3p;

public class CommentRating {
    private int songId; // ID của bài hát
    private float rating; // Điểm đánh giá
    private String comment; // Nội dung bình luận
    private String userName; // Tên của người dùng

    public CommentRating(int songId, float rating, String comment, String userName) {
        this.songId = songId;
        this.rating = rating;
        this.comment = comment;
        this.userName = userName;
    }

    // Getters và setters cho các thuộc tính
    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
