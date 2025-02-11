package com.example.musicm3p;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CommentsActivity extends AppCompatActivity {

    private TextView commentsTextView;
    private EditText commentEditText;
    private RatingBar ratingBar;
    private int songId;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        databaseHelper = new DatabaseHelper(this);

        Intent intent = getIntent();
        if (intent != null) {
            songId = intent.getIntExtra("song_id", -1);
        }

        commentsTextView = findViewById(R.id.commentsTextView);
        commentEditText = findViewById(R.id.commentEditText);
        ratingBar = findViewById(R.id.ratingBar);
        Button submitButton = findViewById(R.id.submitBtn);

        loadComments(songId); // Load chỉ các bình luận của bài hát có songId tương ứng

        // Gán sự kiện click cho nút gửi
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCommentAndRating();
            }
        });
    }

    private void loadComments(int songId) {
        List<CommentRating> comments = databaseHelper.getAllCommentsForSong(songId);

        StringBuilder sb = new StringBuilder();
        for (CommentRating comment : comments) {
            sb.append("Ẩn danh: ").append(comment.getUserName())
                    .append(", Rating: ").append(comment.getRating())
                    .append(", Bình luận: ").append(comment.getComment())
                    .append("\n\n");
        }
        commentsTextView.setText(sb.toString());
    }

    // Phương thức để gửi comment và rating mới vào Database
    private void sendCommentAndRating() {
        String commentText = commentEditText.getText().toString().trim();
        float ratingValue = ratingBar.getRating(); // Lấy giá trị đánh giá từ RatingBar

        if (!commentText.isEmpty()) {
            String userName = AnimalNameGenerator.getRandomAnimalName();

            // Thêm comment mới vào Database
            CommentRating commentRating = new CommentRating(songId, ratingValue, commentText, userName);
            databaseHelper.addComment(commentRating);

            // Hiển thị thông báo gửi thành công
            Toast.makeText(this, "Bình luận và đánh giá đã được gửi.", Toast.LENGTH_SHORT).show();

            // Reload các comments và clear EditText
            loadComments(songId);
            commentEditText.setText("");
            // Cập nhật rating trong dữ liệu bài hát
            // (nếu bạn muốn, bạn có thể lưu rating trung bình của tất cả các đánh giá cho mỗi bài hát)
        } else {
            // Hiển thị thông báo khi EditText trống
            Toast.makeText(this, "Vui lòng nhập bình luận trước khi gửi.", Toast.LENGTH_SHORT).show();
        }
    }
    public void goBack(View view) {
        finish();
    }
}
