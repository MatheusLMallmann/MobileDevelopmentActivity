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
import br.edu.uniritter.mobile.uniritterapp.model.Post;
import br.edu.uniritter.mobile.uniritterapp.model.Todo;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> listaPosts;

    public class PostViewHolder extends RecyclerView.ViewHolder{

        public View viewPost;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewPost = itemView;
        }
    }

    public PostAdapter(List<Post> posts){
        this.listaPosts = posts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_post_detalhado, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post objeto = this.listaPosts.get(position);
        TextView userId = holder.viewPost.findViewById(R.id.userId_Post);
        userId.setText(objeto.getUserId() + "");
        TextView id = holder.viewPost.findViewById(R.id.id_Post);
        id.setText(objeto.getId() + "");
        TextView title = holder.viewPost.findViewById(R.id.title_Post);
        title.setText(objeto.getTitle());
        TextView body = holder.viewPost.findViewById(R.id.body_Post);
        body.setText(objeto.getBody());
    }

    @Override
    public int getItemCount() {
        return this.listaPosts.size();
    }
}
