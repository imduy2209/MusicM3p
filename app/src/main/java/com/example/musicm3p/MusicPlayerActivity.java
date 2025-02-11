//package com.example.musicm3p;
//
//import android.content.Intent;
//import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.SeekBar;
//import android.widget.TextView;
//import android.widget.Toast;
//import androidx.appcompat.app.AppCompatActivity;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//import java.util.Locale;
//import android.widget.ImageView;
//
//public class MusicPlayerActivity extends AppCompatActivity {
//    private MediaPlayer mediaPlayer;
//    private Button playButton, prevButton, nextButton;
//    private SeekBar seekBar;
//    private TextView lyricsTextView, timeTextView;
//    private int currentSongIndex = 0; // chỉ số của bài hát hiện tại
//    private List<Song> songs; // danh sách các bài hát
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_music_player);
//
//        Intent intent = getIntent();
//        if (intent != null) {
//            Song selectedSong = (Song) intent.getSerializableExtra("selected_song");
//            currentSongIndex = intent.getIntExtra("song_index", 0);
//            songs = (List<Song>) intent.getSerializableExtra("songs_list"); // Lấy danh sách các bài hát từ Intent
//            if (songs == null) {
//                Toast.makeText(this, "Không có dữ liệu bài hát.", Toast.LENGTH_SHORT).show();
//                finish();
//                return;
//            }
//            initializeMediaPlayer(selectedSong);
//        } else {
//            Toast.makeText(this, "Intent không tồn tại.", Toast.LENGTH_SHORT).show();
//            finish();
//        }
//    }
//
//
//    private void initializeMediaPlayer(Song song) {
//        TextView songTitleTextView = findViewById(R.id.songTitleTextView);
//        songTitleTextView.setText(song.getSongName());
//
//        TextView artistNameTextView = findViewById(R.id.artistNameTextView); // Thêm TextView mới cho tên ca sĩ
//        artistNameTextView.setText(song.getArtistName());
//
//        ImageView songImageView = findViewById(R.id.song_image_view);
//
//        // Thiết lập hình ảnh cho ImageView
//        songImageView.setImageResource(song.getSongImageResourceId());
//
//        lyricsTextView = findViewById(R.id.lyricsTextView);
//        lyricsTextView.setText(song.getLyrics());
//
//        mediaPlayer = MediaPlayer.create(this, song.getSongResourceId());
//
//        playButton = findViewById(R.id.playButton);
//        playButton.setBackgroundResource(R.drawable.ic_music_off);
//        prevButton = findViewById(R.id.prevButton);
//        nextButton = findViewById(R.id.nextButton);
//        seekBar = findViewById(R.id.seekBar);
//        timeTextView = findViewById(R.id.timeTextView);
//
//        playButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mediaPlayer != null) {
//                    if (!mediaPlayer.isPlaying()) {
//                        mediaPlayer.start();
//                        playButton.setBackgroundResource(R.drawable.ic_music_off);
//                        updateTimeTextView();
//                    } else {
//                        mediaPlayer.pause();
//                        playButton.setBackgroundResource(R.drawable.ic_play);
//                    }
//                }
//            }
//        });
//
//        prevButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                playPreviousSong();
//            }
//        });
//
//        nextButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                playNextSong();
//            }
//        });
//
//        mediaPlayer.setOnPreparedListener(mp -> {
//            seekBar.setMax(mediaPlayer.getDuration());
//            mediaPlayer.start();
//            updateTimeTextView();
//        });
//
//        mediaPlayer.setOnSeekCompleteListener(mp -> {
//            seekBar.setProgress(mediaPlayer.getCurrentPosition());
//        });
//
//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                if (fromUser) {
//                    mediaPlayer.seekTo(progress);
//                }
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//            }
//        });
//
//        mediaPlayer.setOnCompletionListener(mp -> {
//            playNextSong();
//        });
//        Button commentButton = findViewById(R.id.commentButton);
//        commentButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MusicPlayerActivity.this, CommentsActivity.class);
//                intent.putExtra("song_id", song.getSongResourceId()); // Truyền songResourceId thay vì songId
//                startActivity(intent);
//            }
//        });
//
//    }
//
//    private void playPreviousSong() {
//        if (currentSongIndex > 0) {
//            currentSongIndex--;
//            mediaPlayer.release();
//            initializeMediaPlayer(songs.get(currentSongIndex));
//        }
//    }
//
//    private void playNextSong() {
//        if (currentSongIndex < songs.size() - 1) {
//            currentSongIndex++;
//            mediaPlayer.release();
//            initializeMediaPlayer(songs.get(currentSongIndex));
//        }
//    }
//
//    private void updateTimeTextView() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (mediaPlayer != null && mediaPlayer.isPlaying()) {
//                    try {
//                        Thread.sleep(1000);
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                int currentPosition = mediaPlayer.getCurrentPosition();
//                                int totalDuration = mediaPlayer.getDuration();
//
//                                String currentTime = String.format(Locale.ENGLISH, "%02d:%02d",
//                                        TimeUnit.MILLISECONDS.toMinutes(currentPosition),
//                                        TimeUnit.MILLISECONDS.toSeconds(currentPosition) -
//                                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(currentPosition))
//                                );
//
//                                String totalTime = String.format(Locale.ENGLISH, "%02d:%02d",
//                                        TimeUnit.MILLISECONDS.toMinutes(totalDuration),
//                                        TimeUnit.MILLISECONDS.toSeconds(totalDuration) -
//                                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(totalDuration))
//                                );
//
//                                timeTextView.setText(currentTime + " / " + totalTime);
//                                seekBar.setProgress(currentPosition);
//                            }
//                        });
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//    }
//}

package com.example.musicm3p;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Locale;

public class MusicPlayerActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private Button playButton, prevButton, nextButton;
    private SeekBar seekBar;
    private TextView lyricsTextView, timeTextView;
    private int currentSongIndex = 0; // chỉ số của bài hát hiện tại
    private List<Song> songs; // danh sách các bài hát

    // SharedPreferences
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String SONG_POSITION_KEY = "song_position";
    private static final String SONG_PROGRESS_KEY = "song_progress";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();

        Intent intent = getIntent();
        if (intent != null) {
            Song selectedSong = (Song) intent.getSerializableExtra("selected_song");
            currentSongIndex = intent.getIntExtra("song_index", 0);
            songs = (List<Song>) intent.getSerializableExtra("songs_list"); // Lấy danh sách các bài hát từ Intent
            if (songs == null) {
                Toast.makeText(this, "Không có dữ liệu bài hát.", Toast.LENGTH_SHORT).show();
                finish();
                return;
            }
            initializeMediaPlayer(selectedSong);
        } else {
            Toast.makeText(this, "Intent không tồn tại.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void initializeMediaPlayer(Song song) {
        TextView songTitleTextView = findViewById(R.id.songTitleTextView);
        songTitleTextView.setText(song.getSongName());

        TextView artistNameTextView = findViewById(R.id.artistNameTextView); // Thêm TextView mới cho tên ca sĩ
        artistNameTextView.setText(song.getArtistName());

        ImageView songImageView = findViewById(R.id.song_image_view);
        songImageView.setImageResource(song.getSongImageResourceId());

        lyricsTextView = findViewById(R.id.lyricsTextView);
        lyricsTextView.setText(song.getLyrics());

        mediaPlayer = MediaPlayer.create(this, song.getSongResourceId());

        playButton = findViewById(R.id.playButton);
        playButton.setBackgroundResource(R.drawable.ic_music_off);
        prevButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);
        seekBar = findViewById(R.id.seekBar);
        timeTextView = findViewById(R.id.timeTextView);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    if (!mediaPlayer.isPlaying()) {
                        mediaPlayer.start();
                        playButton.setBackgroundResource(R.drawable.ic_music_off);
                        updateTimeTextView();
                    } else {
                        mediaPlayer.pause();
                        playButton.setBackgroundResource(R.drawable.ic_play);
                    }
                }
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playPreviousSong();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playNextSong();
            }
        });

        mediaPlayer.setOnPreparedListener(mp -> {
            seekBar.setMax(mediaPlayer.getDuration());
            mediaPlayer.start();
            updateTimeTextView();
        });

        mediaPlayer.setOnSeekCompleteListener(mp -> {
            seekBar.setProgress(mediaPlayer.getCurrentPosition());
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        mediaPlayer.setOnCompletionListener(mp -> {
            playNextSong();
        });

        Button commentButton = findViewById(R.id.commentButton);
        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MusicPlayerActivity.this, CommentsActivity.class);
                intent.putExtra("song_id", song.getSongResourceId()); // Truyền songResourceId thay vì songId
                startActivity(intent);
            }
        });

        // Restore previous position and progress
        int savedPosition = sharedPreferences.getInt(SONG_POSITION_KEY, 0);
        int savedProgress = sharedPreferences.getInt(SONG_PROGRESS_KEY, 0);
        if (currentSongIndex == savedPosition && mediaPlayer != null) {
            mediaPlayer.seekTo(savedProgress);
        }
    }

    private void playPreviousSong() {
        if (currentSongIndex > 0) {
            currentSongIndex--;
            mediaPlayer.release();
            initializeMediaPlayer(songs.get(currentSongIndex));
        }
    }

    private void playNextSong() {
        if (currentSongIndex < songs.size() - 1) {
            currentSongIndex++;
            mediaPlayer.release();
            initializeMediaPlayer(songs.get(currentSongIndex));
        }
    }

    private void updateTimeTextView() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    try {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                int currentPosition = mediaPlayer.getCurrentPosition();
                                int totalDuration = mediaPlayer.getDuration();

                                String currentTime = String.format(Locale.ENGLISH, "%02d:%02d",
                                        TimeUnit.MILLISECONDS.toMinutes(currentPosition),
                                        TimeUnit.MILLISECONDS.toSeconds(currentPosition) -
                                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(currentPosition))
                                );

                                String totalTime = String.format(Locale.ENGLISH, "%02d:%02d",
                                        TimeUnit.MILLISECONDS.toMinutes(totalDuration),
                                        TimeUnit.MILLISECONDS.toSeconds(totalDuration) -
                                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(totalDuration))
                                );

                                timeTextView.setText(currentTime + " / " + totalTime);
                                seekBar.setProgress(currentPosition);
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            editor.putInt(SONG_POSITION_KEY, currentSongIndex);
            editor.putInt(SONG_PROGRESS_KEY, mediaPlayer.getCurrentPosition());
            editor.apply();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

}
