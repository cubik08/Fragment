package e.subsh.fragment.Fragments;

import android.content.Context;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

import e.subsh.fragment.Album;
import e.subsh.fragment.AlbumAdaptador;
import e.subsh.fragment.BaseDatos.GestorAlbums;
import e.subsh.fragment.R;


public class Fragment2 extends Fragment {

    ArrayList<Album> albums;
    RecyclerView listaAlbum;
    Button btnActualizar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                             @NonNull Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment2,container,false);

        btnActualizar = v.findViewById(R.id.btnActualizar);
        listaAlbum = v.findViewById(R.id.rcvListaAlbums);
        LinearLayoutManager ilm = new LinearLayoutManager(getActivity());
        ilm.setOrientation(LinearLayoutManager.VERTICAL);
        listaAlbum.setLayoutManager(ilm);
        InicializarListaAlbums();
        IniciarAdaptador();

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.detach(Fragment2.this).attach(Fragment2.this).commit();
            }
        });

        return v;
    }

    private void InicializarListaAlbums() {
        /*albums = new ArrayList<>();
        albums.add(new Album("Inktation","SquidSisters",R.drawable.dvlrpgavmamjoy5));*/
        GestorAlbums gesstorAlbums = new GestorAlbums(this.getActivity());
        albums = gesstorAlbums.AsignarAlbum();
    }

    private  void  IniciarAdaptador(){
        AlbumAdaptador miAdaptador = new AlbumAdaptador(albums);
        listaAlbum.setAdapter(miAdaptador);
    }
}
