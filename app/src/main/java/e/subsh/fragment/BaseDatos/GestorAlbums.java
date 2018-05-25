package e.subsh.fragment.BaseDatos;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import e.subsh.fragment.Album;
import e.subsh.fragment.R;

public class GestorAlbums {

    private Context context;

    public GestorAlbums (Context context)
    {
        this.context = context;
    }

    public ArrayList<Album> AsignarAlbum ()
    {
        MotorBaseDatos db = new MotorBaseDatos(context);
        InsertarDosAlbums(db);
        return db.extraerAlbumDataBase();
    }

    private void InsertarDosAlbums(MotorBaseDatos db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_NOMBRE_ALBUM, "Calamari inktation");
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_ARTISTA, "SquidSisters");
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_FOTO, R.drawable.dvlrpgavmamjoy5);
        db.InsertarAlbum(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_NOMBRE_ALBUM, "Bomb Rush Blush");
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_ARTISTA, "Callie");
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_FOTO, R.drawable.calliesempai);
        db.InsertarAlbum(contentValues);
    }
}
