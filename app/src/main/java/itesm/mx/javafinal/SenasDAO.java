package itesm.mx.javafinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by alanc on 13/11/2017.
 */

public class SenasDAO {

    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private Context dbContext;
    private String[] dbColumns = {DBHelper.COLUMN_SENAS_ID,DBHelper.COLUMN_SENAS_PALABRA,
            DBHelper.COLUMN_SENAS_RESOURCE,DBHelper.COLUMN_SENA_CATEGORIA_ID};

    public SenasDAO(Context context){
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

    public Senas createSena(Senas senas){
        ContentValues values = new ContentValues();

        values.put(DBHelper.COLUMN_SENAS_PALABRA,senas.getNombreSena());
        values.put(DBHelper.COLUMN_SENAS_RESOURCE,senas.getResourceSena());
        values.put(DBHelper.COLUMN_SENA_CATEGORIA_ID,senas.getIdSena());

        long newRowId = db.insert(DBHelper.TABLE_SENAS,null,values);

        Cursor cursor = db.query(DBHelper.TABLE_SENAS,dbColumns,
                        DBHelper.COLUMN_SENAS_ID + " = " + newRowId,null,null,null,null);

        cursor.moveToFirst();
        Senas senasFinal = cursorToSena(cursor);
        cursor.close();
        return senasFinal;
    }

    public Senas findSena(String senaName){
        String query = "SELECT * FROM " +
                        DBHelper.TABLE_SENAS +
                        " WHERE " + DBHelper.COLUMN_SENAS_PALABRA +
                        " = \"" + senaName + "\"";
        Senas senas = null;
        try{
            Cursor cursor = db.rawQuery(query,null);
            if (cursor.moveToFirst()){
                senas = cursorToSena(cursor);
            }
            cursor.close();
        }catch (SQLException e){
            Log.e("Find Seña",e.toString());
        }
        return senas;
    }

    public ArrayList<Senas> getSenas(){
        ArrayList<Senas> listaSenas = new ArrayList<>();

        Cursor cursor = db.query(DBHelper.TABLE_SENAS,dbColumns,null,null,null,null,DBHelper.COLUMN_SENAS_PALABRA);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Senas senas = cursorToSena(cursor);
            listaSenas.add(senas);
            cursor.moveToNext();
        }
        cursor.close();
        return listaSenas;
    }

    public ArrayList<Senas> getSenas2(){
        ArrayList<Senas> listaSenas = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + DBHelper.TABLE_SENAS + " ORDER BY " + DBHelper.COLUMN_SENAS_PALABRA;
        /*String selectQuery2 = "SELECT " + DBHelper.COLUMN_SENAS_ID + "," +
                "REPLACE('Águila','Á','A'),"+
                DBHelper.COLUMN_SENAS_RESOURCE + "," + DBHelper.COLUMN_SENA_CATEGORIA_ID + " FROM" +
                DBHelper.TABLE_SENAS + " ORDER BY " + DBHelper.COLUMN_SENAS_PALABRA;*/

        try{
            Cursor cursor = db.rawQuery(selectQuery,null);

            if (cursor.moveToFirst()){
                do{
                    Senas senas = new Senas(Long.parseLong(cursor.getString(0)),
                                    cursor.getString(1),
                                    Integer.parseInt(cursor.getString(2)));
                    long categoriaId = Long.parseLong(cursor.getString(3));
                    CategoriasDAO categoriasDAO = new CategoriasDAO(dbContext);
                    CategoriaSenas categoriaSenas = categoriasDAO.getCategoriaById2(categoriaId);
                    if (categoriaSenas != null){
                        senas.setCategoriaSenas(categoriaSenas);
                    }
                    listaSenas.add(senas);
                }while (cursor.moveToNext());
            }
            cursor.close();
        }catch (SQLException e){
            Log.e("Lista",e.toString());
        }
        return listaSenas;
    }

    public ArrayList<Senas> getSenasFromCategoria(long idCategoria){
        ArrayList<Senas> listaSenas = new ArrayList<>();

        Cursor cursor = db.query(DBHelper.TABLE_SENAS,dbColumns,DBHelper.COLUMN_SENA_CATEGORIA_ID + " = ?",
                        new String[]{String.valueOf(idCategoria)},null,null,null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Senas senas = cursorToSena(cursor);
            listaSenas.add(senas);
            cursor.moveToNext();
        }
        cursor.close();
        return listaSenas;
    }

    private Senas cursorToSena(Cursor cursor){
        Senas senas = new Senas();
        senas.setIdSena(Long.parseLong(cursor.getString(0)));
        senas.setNombreSena(cursor.getString(1));
        senas.setResourceSena(Integer.parseInt(cursor.getString(2)));

        long categoriaId = Long.parseLong(cursor.getString(3));
        CategoriasDAO categoriasDAO = new CategoriasDAO(dbContext);
        CategoriaSenas categoriaSenas = categoriasDAO.getCategoriaById(categoriaId);
        if (categoriaSenas != null){
            senas.setCategoriaSenas(categoriaSenas);
        }
        return senas;
    }

}
