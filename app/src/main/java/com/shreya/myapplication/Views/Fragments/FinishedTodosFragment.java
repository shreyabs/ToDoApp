package com.shreya.myapplication.Views.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shreya.myapplication.DataSources.DummyContent;
import com.shreya.myapplication.DataSources.Note;
import com.shreya.myapplication.R;
import com.shreya.myapplication.Views.ViewAdapters.MyFinishedTodosRecyclerViewAdapter;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link onFinTodosListFrag_InteractionListener}
 * interface.
 */
public class FinishedTodosFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private onFinTodosListFrag_InteractionListener mListener;
    private MyFinishedTodosRecyclerViewAdapter myFinTodoAdapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FinishedTodosFragment() {
    }

//In case we want specific params when fragment is recreated.

//    @SuppressWarnings("unused")
//    public static FinishedTodosFragment newInstance(int columnCount) {
//        FinishedTodosFragment fragment = new FinishedTodosFragment();
//        Bundle args = new Bundle();
//        args.putInt(ARG_COLUMN_COUNT, columnCount);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_finishedtodos_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            myFinTodoAdapter = new MyFinishedTodosRecyclerViewAdapter(DummyContent.DONE_ITEMS, mListener);
            recyclerView.setAdapter(myFinTodoAdapter);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onFinTodosListFrag_InteractionListener) {
            mListener = (onFinTodosListFrag_InteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement onFinTodosListFrag_InteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void deleteDoneNote(Note note){
        DummyContent.deleteDoneNote(note);
    }

    public void updateList(){
        myFinTodoAdapter.notifyDataSetChanged();
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface onFinTodosListFrag_InteractionListener {
        void onFinTodoInteraction(Note item);
    }
}
