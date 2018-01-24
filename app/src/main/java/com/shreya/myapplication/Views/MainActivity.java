package com.shreya.myapplication.Views;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.shreya.myapplication.DataSources.Note;
import com.shreya.myapplication.R;
import com.shreya.myapplication.Views.Fragments.FinishedTodosFragment;
import com.shreya.myapplication.Views.Fragments.TodoFragment;

public class MainActivity extends AppCompatActivity
        implements TodoFragment.onTodoListFragInteractionListener,
                    FinishedTodosFragment.onFinTodosListFrag_InteractionListener{

    TodoFragment mTodoFragment;
    FinishedTodosFragment mFinishedTodosFragment;
    EditText mNewTodoET;
    Button mNewTodoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showToDosFragment();
        showFinishedToDosFragment();
        initViews();

    }

    private void initViews(){
        mNewTodoET = (EditText) findViewById(R.id.newtodo_edittext);
        mNewTodoButton = (Button) findViewById(R.id.newtodo_button);
    }

    private void showToDosFragment(){
        // Create a new fragment and transaction
        mTodoFragment = new TodoFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // Replace the frame with this fragment
        transaction.replace(R.id.todo_frame, mTodoFragment);

        // Commit the transaction
        transaction.commit();
    }

    private void showFinishedToDosFragment(){
        // Create a new fragment and transaction
        mFinishedTodosFragment = new FinishedTodosFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // Replace the frame with this fragment
        transaction.replace(R.id.done_frame, mFinishedTodosFragment);

        // Commit the transaction
        transaction.commit();
    }


    @Override
    public void onTodoInteraction(Note note) {
        mTodoFragment.deleteNote(note);
        mTodoFragment.updateList();
        mFinishedTodosFragment.updateList();
    }

    @Override
    public void onFinTodoInteraction(Note item) {
        mFinishedTodosFragment.deleteDoneNote(item);
        mTodoFragment.updateList();
        mFinishedTodosFragment.updateList();
    }

    private void addTodo(String todoString){
        mTodoFragment.addTodo(todoString);
    }

    public void addNewTodo(View view) {

        //Get new note text from the edit text
        if(null != mNewTodoET.getText()) {
            String noteString = mNewTodoET.getText().toString();
            addTodo(noteString);
        }

    }
}
