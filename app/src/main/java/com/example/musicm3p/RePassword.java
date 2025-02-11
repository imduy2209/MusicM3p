package com.example.musicm3p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RePassword extends AppCompatActivity {
    private EditText editTextNewPassword;
    private EditText editTextConfirmPassword;
    private Button buttonChangePassword;
    private DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_password);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        editTextNewPassword = findViewById(R.id.edit_text_new_password);
        editTextConfirmPassword = findViewById(R.id.edit_text_confirm_password);
        buttonChangePassword = findViewById(R.id.button_change_password);
        myDB = new DBHelper(this);

        buttonChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newPassword = editTextNewPassword.getText().toString();
                String confirmPassword = editTextConfirmPassword.getText().toString();

                if (newPassword.equals(confirmPassword)) {
                    boolean isPasswordChanged = myDB.changePassword(username, newPassword);

                    if (isPasswordChanged) {
                        Toast.makeText(RePassword.this, "Password changed successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RePassword.this, MainMusicPlayerActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(RePassword.this, "Error changing password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RePassword.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}