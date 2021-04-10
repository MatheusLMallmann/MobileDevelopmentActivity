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
import br.edu.uniritter.mobile.uniritterapp.model.Album;
import br.edu.uniritter.mobile.uniritterapp.model.Post;
import br.edu.uniritter.mobile.uniritterapp.model.Todo;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private List<Album> listaAlbum;

    public class AlbumViewHolder extends RecyclerView.ViewHolder{

        public View viewAlbum;

        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewAlbum = itemView;
        }
    }

    public AlbumAdapter(List<Album> albums){
        this.listaAlbum = albums;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_album_detalhado, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album objeto = this.listaAlbum.get(position);
        TextView postId = holder.viewAlbum.findViewById(R.id.userId_Album);
        postId.setText(objeto.getPostId() + "");
        TextView id = holder.viewAlbum.findViewById(R.id.id_Album);
        id.setText(objeto.getId() + "");
        TextView name = holder.viewAlbum.findViewById(R.id.title_Album);
        name.setText(objeto.getTitle());
    }

    @Override
    public int getItemCount() {
        return this.listaAlbum.size();
    }
}