package com.example.m0d1x.miwokappwithfragments;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link DictionaryAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Dictionary} objects.
 */
public class DictionaryAdapter extends ArrayAdapter<Dictionary> {

    /**
     * Resource ID for the background color for this list of Dictionarys
     */
    private int mColorResourceId;

    /**
     * Create a new {@link DictionaryAdapter} object.
     *
     * @param context         is the current context (i.e. Activity) that the adapter is being created in.
     * @param Dictionarys     is the list of {@link Dictionary}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of Dictionarys
     */
    public DictionaryAdapter(Context context, ArrayList<Dictionary> Dictionarys, int colorResourceId) {
        super(context, 0, Dictionarys);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.costom_layout, parent, false);
        }

        // Get the {@link Dictionary} object located at this position in the list
        Dictionary currentDictionary = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.txt_word);
        // Get the Miwok translation from the currentDictionary object and set this text on
        // the Miwok TextView.
        miwokTextView.setText(currentDictionary.getWord());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.txt_translation);
        // Get the default translation from the currentDictionary object and set this text on
        // the default TextView.
        defaultTextView.setText(currentDictionary.getTranslate());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.img_pic);
        // Check if an image is provided for this Dictionary or not

        // If an image is available, display the provided image based on the resource ID
        imageView.setImageResource(currentDictionary.getPicID());
        // Make sure the view is visible
        imageView.setVisibility(View.VISIBLE);

        ImageView img_play = (ImageView) listItemView.findViewById(R.id.img_play);
        img_play.setImageResource(R.drawable.ic_play_arrow_white_24dp);

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}