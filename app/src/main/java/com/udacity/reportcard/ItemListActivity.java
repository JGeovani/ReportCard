package com.udacity.reportcard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.udacity.reportcard.dummy.DummyContent;
import com.udacity.reportcard.model.ReportCard;

import java.util.List;


/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ItemListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet device.
     */
    private boolean mTwoPane;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setupToolbar(toolbar);

        View recyclerView = findViewById(R.id.item_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        if (findViewById(R.id.item_detail_container) != null) {
            mTwoPane = true;
        }

        Snackbar.make(recyclerView, getString(R.string.snackbar_welcome) + getString(R.string.app_name), Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }


    private void setupToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());
    }


    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(DummyContent.ITEMS));
    }



    public class SimpleItemRecyclerViewAdapter extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>
    {
        private final List<ReportCard> mValues;

        public SimpleItemRecyclerViewAdapter(List<ReportCard> items)
        {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mIdView.setText(mValues.get(position).id);
            holder.mContentView.setText(mValues.get(position).content);
            holder.mGradeText.setText(mValues.get(position).grade);

            startActivityOnClick(holder);
        }

        private void startActivityOnClick(final ViewHolder holder) {
            holder.mView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    if (mTwoPane)
                    {
                        Bundle arguments = new Bundle();
                        arguments.putString(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                        ItemDetailFragment fragment = new ItemDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction().replace(R.id.item_detail_container, fragment).commit();
                    } else {
                        Context context = view.getContext();
                        Intent intent = new Intent(context, ItemDetailActivity.class);
                        intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                        context.startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount()
        {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder
        {
            public final View mView;
            public final TextView mIdView;
            public final ImageView mImageView;
            public final TextView mContentView;
            public final TextView mGradeText;
            public ReportCard mItem;

            public ViewHolder(View view)
            {
                super(view);
                mView        = view;
                mIdView      = (TextView) view.findViewById(R.id.id);
                mImageView   = (ImageView) view.findViewById(R.id.imageView);
                mContentView = (TextView) view.findViewById(R.id.contentText);
                mGradeText   = (TextView) view.findViewById(R.id.gradeText);
            }

            @Override
            public String toString()
            {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }



}
