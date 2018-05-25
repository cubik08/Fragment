package e.subsh.fragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AlbumAdaptador extends RecyclerView.Adapter<AlbumAdaptador.AlbumViewHolder>{

    private ArrayList<Album> albums;

    public AlbumAdaptador(ArrayList<Album> albums) {
        this.albums = albums;
    }


    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_album,parent,false);
        return new AlbumViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        final Album album = albums.get(position);
        holder.txtvNombreArtista.setText(album.getArtista());
        holder.txtvNombreAlbum.setText(album.getNombre());
        holder.imgAlbum.setImageResource(album.getFoto());

        holder.imgAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Nombre Album " + album.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgAlbum;
        private TextView txtvNombreAlbum;
        private TextView txtvNombreArtista;

        public AlbumViewHolder(View itemView) {
            super(itemView);
            imgAlbum = itemView.findViewById(R.id.imgFoto);
            txtvNombreAlbum = itemView.findViewById(R.id.txtvNombreAlbum);
            txtvNombreArtista = itemView.findViewById(R.id.txtvNombreArtista);
        }
    }
}
