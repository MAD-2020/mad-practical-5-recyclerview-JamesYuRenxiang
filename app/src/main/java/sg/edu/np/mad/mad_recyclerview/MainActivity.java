package sg.edu.np.mad.mad_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerview;
    ArrayList<ToDo> todolist;
    EditText input;
    Button addbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = findViewById(R.id.recyclerview);



        input = findViewById(R.id.todo);
        addbutton = findViewById(R.id.button);
        todolist = new ArrayList<>();

        final Adapter Adapter = new Adapter(todolist);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

        recyclerview.setLayoutManager(mLayoutManager);

        recyclerview.setAdapter(Adapter);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toDoInput = input.getText().toString();
                ToDo todo = new ToDo(toDoInput);
                todolist.add(todo);
                Adapter.notifyDataSetChanged();
                input.setText("");
                showNewEntry(recyclerview,todolist);
            }
        });
    }


    /**
     * Upon calling this method, the keyboard will retract
     * and the recyclerview will scroll to the last item
     *
     * @param rv RecyclerView for scrolling to
     * @param data ArrayList that was passed into RecyclerView
     */
    private void showNewEntry(RecyclerView rv, ArrayList data){
        //scroll to the last item of the recyclerview
        rv.scrollToPosition(data.size() - 1);

        //auto hide keyboard after entry
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(rv.getWindowToken(), 0);
    }
}
