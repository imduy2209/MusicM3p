package com.example.musicm3p;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(Context context, List<Song> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Song song = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.song_item, parent, false);
        }

        // Lookup view for data population
        ImageView songImageView = convertView.findViewById(R.id.song_image_view);
        TextView songTitleTextView = convertView.findViewById(R.id.song_title_text_view);
        TextView artistNameTextView = convertView.findViewById(R.id.artist_name_text_view); // Đổi ID thành artist_name_text_view

        // Populate the data into the template view using the data object
        songImageView.setImageResource(song.getSongImageResourceId());
        songTitleTextView.setText(song.getSongName());
        artistNameTextView.setText(song.getArtistName()); // Hiển thị tên ca sĩ

        // Return the completed view to render on screen
        return convertView;
    }
}