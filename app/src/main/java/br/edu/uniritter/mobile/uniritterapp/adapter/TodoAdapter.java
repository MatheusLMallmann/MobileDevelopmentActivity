package br.edu.uniritter.mobile.uniritterapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.uniritter.mobile.uniritterapp.R;
import br.edu.uniritter.mobile.uniritterapp.model.Todo;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

    private List<Todo> listaTodos;

    public class TodoViewHolder extends RecyclerView.ViewHolder{

        public View viewTodo;

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewTodo = itemView;
        }
    }

    public TodoAdapter(List<Todo> todos){
        this.listaTodos = todos;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Todo objeto = this.listaTodos.get(position);
        TextView textView = holder.viewTodo.findViewById(R.id.tvId);
        textView.setText(objeto.getId()+"");
        textView = holder.viewTodo.findViewById(R.id.tvIdUser);
        textView.setText(objeto.getUserId()+"");
        textView = holder.viewTodo.findViewById(R.id.tvTitle);
        textView.setText(objeto.getTitle());
        CheckBox checkBox = holder.viewTodo.findViewById(R.id.cbCompleted);
        checkBox.setChecked(objeto.isCompleted());
    }

    @Override
    public int getItemCount() {
        return this.listaTodos.size();
    }
}
