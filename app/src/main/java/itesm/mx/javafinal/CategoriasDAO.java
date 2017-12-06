/*
Copyright.© Instituto Tecnológico y de Estudios Superiores de Monterrey, México, 2016.
Nombre: Lengua de Señas Mexicana
Año: 2017
Descripción:
"Lengua de Señas Mexicana" es una aplicación que permite aprender la lengua de señas mexicana a través de un diccionario y un juego.
Por: Jorge Ávalos, César Alán Cantú, Jordi Rodriguez
*/

package itesm.mx.javafinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;


public class CategoriasDAO {

    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private Context dbContext;
    private String[] dbColumns = {DBHelper.COLUMN_CATEGORIAS_ID,DBHelper.COLUMN_CATEGORIAS_NOMBRE};

    public CategoriasDAO(Context context){
        this.dbContext = context;
        dbHelper = DBHelper.getsInstance(context);

        try{
            open();
        }catch (SQLException e){
            Log.e("","SQLException while opening database");
        }
    }

    public void open() throws SQLException{
        db = dbHelper.getWritableDatabase();
        db = dbHelper.getReadableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public CategoriaSenas createCategoria(CategoriaSenas categoriaSenas){
        ContentValues values = new ContentValues();

        values.put(DBHelper.COLUMN_CATEGORIAS_NOMBRE,categoriaSenas.getNombreCategoria());

        long newRowId = db.insert(DBHelper.TABLE_CATEGORIAS,null,values);
        Cursor cursor = db.query(DBHelper.TABLE_CATEGORIAS,dbColumns,
                        DBHelper.COLUMN_CATEGORIAS_ID + " = " + newRowId,null,null,null,null);

        cursor.moveToFirst();
        CategoriaSenas categoriaSenasFinal = cursorToCategoria(cursor);
        cursor.close();
        return categoriaSenasFinal;
    }

    //SELECT * FROM
    public ArrayList<CategoriaSenas> getCategorias(){
        ArrayList<CategoriaSenas> listaCategorias = new ArrayList<CategoriaSenas>();

        Cursor cursor = db.query(DBHelper.TABLE_CATEGORIAS,dbColumns,null,null,null,null,null);
        if (cursor != null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                CategoriaSenas categoriaSenas = cursorToCategoria(cursor);
                listaCategorias.add(categoriaSenas);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return listaCategorias;
    }

    public CategoriaSenas getCategoriaById(long id){
        Cursor cursor = db.query(DBHelper.TABLE_CATEGORIAS,dbColumns,DBHelper.COLUMN_CATEGORIAS_ID + " = ?",
                new String[]{String.valueOf(id)},null,null,null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        CategoriaSenas categoriaSenas = cursorToCategoria(cursor);
        cursor.close();
        return categoriaSenas;
    }

    public CategoriaSenas getCategoriaById2(long id){
        String query = "SELECT * FROM " + DBHelper.TABLE_CATEGORIAS +
                        " WHERE " + DBHelper.COLUMN_CATEGORIAS_ID +
                        " = \"" + id + "\"";

        CategoriaSenas categoriaSenas = null;

        try{
            Cursor cursor = db.rawQuery(query,null);

            if (cursor.moveToFirst()){
                categoriaSenas = new CategoriaSenas(Long.parseLong(cursor.getString(0)),cursor.getString(1));
            }
            cursor.close();
        }catch (SQLException e){
            Log.e("Hi",e.toString());
        }
        return categoriaSenas;
    }

    protected CategoriaSenas cursorToCategoria(Cursor cursor){

        CategoriaSenas categoriaSenas = new CategoriaSenas();

        categoriaSenas.setIdCategoriaDB(cursor.getLong(0));
        categoriaSenas.setNombreCategoria(cursor.getString(1));

        return categoriaSenas;
    }
}
