package com.udacity.reportcard;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.udacity.reportcard.dummy.DummyContent;
import com.udacity.reportcard.model.ReportCard;


/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {

    /**
     * The fragment argument representing the item ID that this fragment represents.
     */
    public static final String ARG_ITEM_ID = "item_id";
    /**
     * The dummy content this fragment is presenting.
     */
    private ReportCard mItem;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            String position = getArguments().getString(ARG_ITEM_ID);
            mItem = DummyContent.ITEM_MAP.get(position);
            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content);
            }
            ImageView imageHead = (ImageView) activity.findViewById(R.id.imageHead);
            showHeaderBackgroud(getResources().getStringArray(R.array.urls)[Integer.valueOf(position)], imageHead);

            TextView circuleText = (TextView) activity.findViewById(R.id.circleTextView);
            circuleText.setText(mItem.grade);
        }
    }


    public void showHeaderBackgroud(String url, ImageView image) {
        try {
            Picasso.with(getContext()).load(url).into(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);
        if (mItem != null) {
            TextView textView = (TextView) rootView.findViewById(R.id.item_detail);
            textView.setText(mItem.details);
        }
        return rootView;
    }



}
