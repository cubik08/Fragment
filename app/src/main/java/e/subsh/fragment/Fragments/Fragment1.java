package e.subsh.fragment.Fragments;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import e.subsh.fragment.BaseDatos.ConstantesBaseDatos;
import e.subsh.fragment.BaseDatos.GestorAlbums;
import e.subsh.fragment.BaseDatos.MotorBaseDatos;
import e.subsh.fragment.R;
import e.subsh.fragment.Fragments.Fragment2;

public class Fragment1 extends Fragment {

    private Button btnAgregar;
    private EditText edtArtista;
    private EditText edtAlbum;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                             @NonNull Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment1,container,false);

        context = container.getContext();
        btnAgregar = v.findViewById(R.id.btAgregar);
        edtArtista = v.findViewById(R.id.edtArtista);
        edtAlbum = v.findViewById(R.id.edtAlbum);



        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MotorBaseDatos db = new MotorBaseDatos(context);
                ContentValues contentValues = new ContentValues();
                contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_NOMBRE_ALBUM, edtAlbum.getText().toString());
                contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_ARTISTA, edtArtista.getText().toString());
                db.ActualizarDB(contentValues);
                }
        });

        return v;
    }

}

