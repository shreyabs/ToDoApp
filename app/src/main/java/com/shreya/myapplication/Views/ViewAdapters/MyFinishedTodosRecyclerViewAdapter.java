package com.shreya.myapplication.Views.ViewAdapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shreya.myapplication.DataSources.Note;
import com.shreya.myapplication.R;
import com.shreya.myapplication.Views.Fragments.FinishedTodosFragment;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Note} and makes a call to the
 * specified {@link FinishedTodosFragment.onFinTodosListFrag_InteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyFinishedTodosRecyclerViewAdapter extends RecyclerView.Adapter<MyFinishedTodosRecyclerViewAdapter.ViewHolder> {

    private final List<Note> mNotes;
    private final FinishedTodosFragment.onFinTodosListFrag_InteractionListener mListener;

    public MyFinishedTodosRecyclerViewAdapter(List<Note> items, FinishedTodosFragment.onFinTodosListFrag_InteractionListener listener) {
        mNotes = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_finishedtodos_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mNotes.get(position);
        holder.mIdView.setText((mNotes.get(position)).getIsCompleted()+""); //TODO: Fix
        holder.mContentView.setText(mNotes.get(position).getNoteData());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onFinTodoInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mIdView;
        final TextView mContentView;
        Note mItem;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
