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
import com.shreya.myapplication.Views.ViewAdapters.MyTodoRecyclerViewAdapter;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link onTodoListFragInteractionListener}
 * interface.
 */
public class TodoFragment extends Fragment {

    private int mColumnCount = 1;
    private onTodoListFragInteractionListener mListener;
    private MyTodoRecyclerViewAdapter todoViewAdapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TodoFragment() {
    }

//In case we want specific params when fragment is recreated.

//    @SuppressWarnings("unused")
//    public static TodoFragment newInstance(int columnCount) {
//        TodoFragment fragment = new TodoFragment();
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
        View view = inflater.inflate(R.layout.fragment_todo_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            todoViewAdapter = new MyTodoRecyclerViewAdapter(DummyContent.TODO_ITEMS, mListener);
            recyclerView.setAdapter(todoViewAdapter);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onTodoListFragInteractionListener) {
            mListener = (onTodoListFragInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement onTodoListFragInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void deleteNote(Note note){
        DummyContent.deleteNote(note);
    }

    public void updateList(){
        todoViewAdapter.notifyDataSetChanged();
    }

    public void addTodo(String todoString){
        int noteId = DummyContent.TODO_ITEMS.size()+1;
        Note newNote = new Note(noteId, todoString+noteId);
        DummyContent.addNote(newNote);

        updateList();
    }

    /**
     * Listener for any interaction between the user and current fragment.
     */
    public interface onTodoListFragInteractionListener {
        void onTodoInteraction(Note note);
    }
}
