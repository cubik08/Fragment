package e.subsh.fragment.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import e.subsh.fragment.Album;
import e.subsh.fragment.AlbumAdaptador;
import e.subsh.fragment.R;


public class Fragment2 extends Fragment {

    ArrayList<Album> albums;
    private RecyclerView listaAlbum;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                             @NonNull Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment1,container,false);

        listaAlbum = v.findViewById(R.id.rcvListaAlbums);
        LinearLayoutManager ilm = new LinearLayoutManager(getActivity());
        ilm.setOrientation(LinearLayoutManager.VERTICAL);
        listaAlbum.setLayoutManager(ilm);
        InicializarListaAlbums();
        IniciarAdaptador();

        return v;
    }

    private void InicializarListaAlbums() {
        albums = new ArrayList<>();
        albums.add(new Album("Inktation","SquidSisters",R.drawable.dvlrpgavmamjoy5));
    }

    private  void  IniciarAdaptador(){
        AlbumAdaptador miAdaptador = new AlbumAdaptador(albums);
        listaAlbum.setAdapter(miAdaptador);
    }
}
