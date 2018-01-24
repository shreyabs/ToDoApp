package com.shreya.myapplication.DataSources;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for providing sample content.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    // Sample (dummy) todos.

    public static final List<Note> TODO_ITEMS = new ArrayList<>();
    public static final List<Note> DONE_ITEMS = new ArrayList<>();

    private static final int TODO_COUNT = 3;
    private static final int DONE_COUNT = 5;

    static {
        // Add some sample todos
        for (int i = 0; i <= TODO_COUNT; i++) {
            addNote(createDummyNote(i));
        }
        for(int i = 0; i <= DONE_COUNT; i++){
            addDoneNote(createDummyNote(i, 1));
        }
    }

    public static void addNote(Note item) {
        TODO_ITEMS.add(item);
    }

    private static void addDoneNote(Note item) {
        DONE_ITEMS.add(item);
    }

    public static void deleteNote(Note item) {
        TODO_ITEMS.remove(item);
        DONE_ITEMS.add(item);
    }

    public static void deleteDoneNote(Note item) {
        DONE_ITEMS.remove(item);
        TODO_ITEMS.add(item);
    }

    private static Note createDummyNote(int position, int isCompleted) {
        Note newNote = new Note(position, "ToDo item number - "+position);
        newNote.setIsCompleted(isCompleted);
        return newNote;
    }

    private static Note createDummyNote(int position) {
        return new Note(position, "ToDo item number - "+position);
    }

}
