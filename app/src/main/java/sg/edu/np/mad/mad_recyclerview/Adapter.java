package sg.edu.np.mad.mad_recyclerview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder>{
    ArrayList<ToDo> data;

    public Adapter(ArrayList<ToDo> inputData){
        data = inputData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.to_do_list,parent,false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ToDo toDo = data.get(position); //get the data  model based on position
        holder.toDoTxtView.setText(toDo.toDoText);
        //(toDo.getToDoText())

        holder.view.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                View view = LayoutInflater.from(v.getContext()).inflate(R.layout.alert_dialog,null);
                TextView toDoTxt = view.findViewById(R.id.textView3);
                toDoTxt.setText(toDo.toDoText+"?");
                builder.setTitle("Delete")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                data.remove(toDo);
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //dialog.dismiss();
                            }
                        })
                        .setView(view);


                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });


    }
    @Override
    public int getItemCount() {

        return data.size();
    }


}

