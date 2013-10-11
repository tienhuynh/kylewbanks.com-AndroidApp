package com.kylewbanks.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.kylewbanks.model.Post;

import java.util.List;

/**
 * Created by kylewbanks on 2013-10-09.
 */
public class PostListAdapter extends ArrayAdapter<Post> {

    private int viewResourceId;
    private LayoutInflater inflater;
    private List<Post> postList;

    /**
     * Constructs a PostListAdapter with a list of Post objects, that will generate Views for each Post
     * as required.
     *
     * @param context
     * @param viewResourceId
     * @param postList
     */
    public PostListAdapter(Context context, int viewResourceId, List<Post> postList) {
        super(context, viewResourceId, postList);

        this.viewResourceId = viewResourceId;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.postList = postList;
    }

    /**
     * Loads and populates a View object with the post at the specified position.
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(position > postList.size()) {
            return null;
        }

        if(convertView == null) {
            convertView = inflater.inflate(viewResourceId, parent, false);
        }

        PostListItem postListItem = new PostListItem(postList.get(position));
        postListItem.bindToView(convertView);

        return convertView;
    }
}
