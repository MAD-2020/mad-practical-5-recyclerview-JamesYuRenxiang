package sg.edu.np.mad.mad_recyclerview;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder  {
    TextView toDoTxtView;
    CheckBox checkBox;
    View view;


    public ViewHolder(View itemView){
        super(itemView);
        view = itemView;
        toDoTxtView = itemView.findViewById(R.id.todothing);
        checkBox = itemView.findViewById(R.id.checkBox);
    }

}
