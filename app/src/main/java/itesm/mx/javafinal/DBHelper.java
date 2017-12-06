/*
Copyright.© Instituto Tecnológico y de Estudios Superiores de Monterrey, México, 2016.
Nombre: Lengua de Señas Mexicana
Año: 2017
Descripción:
"Lengua de Señas Mexicana" es una aplicación que permite aprender la lengua de señas mexicana a través de un diccionario y un juego.
Por: Jorge Ávalos, César Alán Cantú, Jordi Rodriguez
*/

package itesm.mx.javafinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    private static DBHelper sInstance;

    //columnas de tabla categorías
    public static final String TABLE_CATEGORIAS = "categorias";
    public static final String COLUMN_CATEGORIAS_ID = "_id";
    public static final String COLUMN_CATEGORIAS_NOMBRE = "nombre";

    //columnas de tabla senas
    public static final String TABLE_SENAS = "senas";
    public static final String COLUMN_SENAS_ID  = COLUMN_CATEGORIAS_ID;
    public static final String COLUMN_SENAS_PALABRA = "palabra";
    public static final String COLUMN_SENAS_RESOURCE = "resource";
    public static final String COLUMN_SENA_CATEGORIA_ID = "categoria_id";

    private static final String DATABASE_NAME = "senas.db";
    private static final int DATABASE_VERSION = 1;

    //crear tabla senas
    private static final String SQL_CREATE_TABLE_SENAS = "CREATE TABLE " + TABLE_SENAS +
            "("
                + COLUMN_SENAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_SENAS_PALABRA + " TEXT, "
                + COLUMN_SENAS_RESOURCE + " INTEGER, "
                + COLUMN_SENA_CATEGORIA_ID + " INTEGER,"
                + "FOREIGN KEY (" + COLUMN_SENA_CATEGORIA_ID +") REFERENCES " + TABLE_CATEGORIAS
                + "(" + COLUMN_CATEGORIAS_ID +")" +
                ");";

    //crear tabla categorias
    private static final String SQL_CREATE_TABLE_CATEGORIAS = "CREATE TABLE " + TABLE_CATEGORIAS +
            "("
            + COLUMN_CATEGORIAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_CATEGORIAS_NOMBRE + " TEXT " +
            ");";

    public static synchronized DBHelper getsInstance(Context context){
        if (sInstance == null){
            sInstance = new DBHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_CATEGORIAS);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_SENAS);

        //CATEGORIA ABECEDARIO
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_CATEGORIAS + "(" +
                COLUMN_CATEGORIAS_ID + "," + COLUMN_CATEGORIAS_NOMBRE + ") VALUES (1,'ABECEDARIO')");

        //SEÑAS DE ABECEDARIO
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (1,'A', " + R.drawable.a + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (2,'B', " + R.drawable.b + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (3,'C', " + R.drawable.c + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (4,'D', " + R.drawable.d + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (5,'E', " + R.drawable.e + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (6,'F', " + R.drawable.f + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (7,'G', " + R.drawable.g + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (8,'H', " + R.drawable.h + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (9,'I', " + R.drawable.i + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (10,'J', " + R.raw.j + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (11,'K', " + R.raw.k + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (12,'L', " + R.drawable.l + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (13,'Ll', " + R.raw.ll + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (14,'M', " + R.drawable.m + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (15,'N', " + R.drawable.n + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (16,'O', " + R.drawable.o + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (17,'P', " + R.drawable.p + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (18,'Q', " + R.raw.q + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (19,'R', " + R.drawable.r + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (20,'Rr', " + R.raw.rr + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (21,'S', " + R.drawable.s + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (22,'T', " + R.drawable.t + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (23,'U', " + R.drawable.u + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (24,'V', " + R.drawable.v + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (25,'W', " + R.drawable.w + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (26,'X', " + R.raw.x + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (27,'Y', " + R.drawable.y + ",1)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (28,'Z', " + R.raw.z + ",1)");

        //CATEGORIA ANIMALES
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_CATEGORIAS + "(" +
                COLUMN_CATEGORIAS_ID + "," + COLUMN_CATEGORIAS_NOMBRE + ") VALUES (2,'ANIMALES')");

        //SEÑAS DE ANIMALES
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (29,'Abeja', " + R.raw.abeja + ",2)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (30,'Águila', " + R.raw.aguila + ",2)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (31,'Araña', " + R.raw.arana + ",2)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (32,'Ardilla', " + R.raw.ardilla + ",2)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (33,'Burro', " + R.raw.burro + ",2)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (34,'Caballo', " + R.raw.caballo + ",2)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (35,'Cerdo', " + R.raw.cerdo + ",2)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (36,'Conejo', " + R.raw.conejo + ",2)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (37,'Gato', " + R.raw.gato + ",2)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (38,'Gusano', " + R.raw.gusano + ",2)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (39,'León', " + R.raw.leon + ",2)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (40,'Oso', " + R.raw.oso + ",2)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (41,'Pájaro', " + R.raw.pajaro + ",2)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (42,'Paloma', " + R.raw.paloma + ",2)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (43,'Pato', " + R.raw.pato + ",2)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (44,'Perro', " + R.raw.perro + ",2)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (45,'Pez', " + R.raw.pez + ",2)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (46,'Ratón', " + R.raw.raton + ",2)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (47,'Tigre', " + R.raw.tigre + ",2)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (48,'Toro', " + R.raw.toro + ",2)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (49,'Tortuga', " + R.raw.tortuga + ",2)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (50,'Vaca', " + R.raw.vaca + ",2)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (51,'Víbora', " + R.raw.vibora + ",2)");

        //CATEGORIA COLORES
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_CATEGORIAS + "(" +
                COLUMN_CATEGORIAS_ID + "," + COLUMN_CATEGORIAS_NOMBRE + ") VALUES (3,'COLORES')");

        //SEÑAS DE COLORES
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (52,'Amarillo', " + R.raw.amarillo + ",3)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (53,'Azul', " + R.raw.azul + ",3)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (54,'Blanco', " + R.raw.blanco + ",3)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (55,'Café (Color)', " + R.raw.cafe_color + ",3)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (56,'Gris', " + R.raw.gris + ",3)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (57,'Morado', " + R.raw.morado + ",3)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (58,'Naranja (Color)', " + R.raw.naranja_color + ",3)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (59,'Negro', " + R.raw.negro + ",3)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (60,'Oro', " + R.raw.oro + ",3)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (61,'Plata', " + R.raw.plata + ",3)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (62,'Rojo', " + R.raw.rojo + ",3)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (63,'Rosa', " + R.raw.rosa + ",3)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (64,'Verde', " + R.raw.verde + ",3)");

        //CATEGORIA COMIDA
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_CATEGORIAS + "(" +
                COLUMN_CATEGORIAS_ID + "," + COLUMN_CATEGORIAS_NOMBRE + ") VALUES (4,'COMIDA')");

        //SEÑAS DE COMIDA
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (65,'Aceite', " + R.raw.aceite + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (66,'Agua', " + R.raw.agua + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (67,'Arroz', " + R.raw.arroz + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (68,'Azúcar', " + R.raw.azucar + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (69,'Café (Comida)', " + R.raw.cafe + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (70,'Caldo', " + R.raw.caldo + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (71,'Carne', " + R.raw.carne + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (72,'Cerveza', " + R.raw.cerveza + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (73,'Chile', " + R.raw.chile + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (74,'Chocolate', " + R.raw.chocolate + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (75,'Coca-cola', " + R.raw.cocacola + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (76,'Dulce', " + R.raw.dulce + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (77,'Ensalada', " + R.raw.ensalada + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (78,'Frijol', " + R.raw.frijol + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (79,'Fruta', " + R.raw.fruta + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (80,'Galleta', " + R.raw.galleta + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (81,'Hamburguesa', " + R.raw.hamburguesa + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (82,'Huevo', " + R.raw.huevo + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (83,'Leche', " + R.raw.leche + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (84,'Pan', " + R.raw.pan + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (85,'Pastel', " + R.raw.pastel + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (86,'Pescado', " + R.raw.pescado + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (87,'Pizza', " + R.raw.pizza + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (88,'Pollo', " + R.raw.pollo + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (89,'Queso', " + R.raw.queso + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (90,'Refresco', " + R.raw.refresco + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (91,'Sopa', " + R.raw.sopa + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (92,'Taco', " + R.raw.taco + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (93,'Tortilla', " + R.raw.tortilla + ",4)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (94,'Verdura', " + R.raw.verdura + ",4)");

        //CATEGORIA DÍAS-MESES
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_CATEGORIAS + "(" +
                COLUMN_CATEGORIAS_ID + "," + COLUMN_CATEGORIAS_NOMBRE + ") VALUES (5,'FECHA')");

        //SEÑAS DE DÍAS-MESES
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (95,'Lunes', " + R.raw.lunes + ",5)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (96,'Martes', " + R.raw.martes + ",5)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (97,'Miércoles', " + R.raw.miercoles + ",5)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (98,'Jueves', " + R.raw.jueves + ",5)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (99,'Viernes', " + R.raw.viernes + ",5)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (100,'Sábado', " + R.raw.sabado + ",5)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (101,'Domingo', " + R.raw.domingo + ",5)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (102,'Enero', " + R.raw.enero + ",5)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (103,'Febrero', " + R.raw.febrero + ",5)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (104,'Marzo', " + R.raw.marzo + ",5)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (105,'Abril', " + R.raw.abril + ",5)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (106,'Mayo', " + R.raw.mayo + ",5)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (107,'Junio', " + R.raw.junio + ",5)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (108,'Julio', " + R.raw.julio + ",5)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (109,'Agosto', " + R.raw.agosto + ",5)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (110,'Septiembre', " + R.raw.septiembre + ",5)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (111,'Octubre', " + R.raw.octubre + ",5)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (112,'Noviembre', " + R.raw.noviembre + ",5)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (113,'Diciembre', " + R.raw.diciembre + ",5)");

        //CATEGORIA FAMILIA
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_CATEGORIAS + "(" +
                COLUMN_CATEGORIAS_ID + "," + COLUMN_CATEGORIAS_NOMBRE + ") VALUES (6,'FAMILIA')");

        //SEÑAS DE FAMILIA
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (114,'Abuela', " + R.raw.abuela + ",6)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (115,'Abuelo', " + R.raw.abuelo + ",6)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (116,'Amiga', " + R.raw.amiga + ",6)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (117,'Amigo', " + R.raw.amigo + ",6)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (118,'Bebé', " + R.raw.bebe + ",6)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (119,'Hermana', " + R.raw.hermana + ",6)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (120,'Hermano', " + R.raw.hermano + ",6)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (121,'Hija', " + R.raw.hija + ",6)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (122,'Hijo', " + R.raw.hijo + ",6)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (123,'Mamá', " + R.raw.mama + ",6)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (124,'Papá', " + R.raw.padre + ",6)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (125,'Nieta', " + R.raw.nieta + ",6)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (126,'Nieto', " + R.raw.nieto + ",6)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (127,'Prima', " + R.raw.prima + ",6)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (128,'Primo', " + R.raw.primo + ",6)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (129,'Sobrina', " + R.raw.sobrina + ",6)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (130,'Sobrino', " + R.raw.sobrino + ",6)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (131,'Tía', " + R.raw.tia + ",6)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (132,'Tío', " + R.raw.tio + ",6)");

        //CATEGORIA NÚMEROS
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_CATEGORIAS + "(" +
                COLUMN_CATEGORIAS_ID + "," + COLUMN_CATEGORIAS_NOMBRE + ") VALUES (7,'NÚMEROS')");

        //SEÑAS DE NÚMEROS
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (133,'Cero', " + R.drawable.n0 + ",7)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (134,'Uno', " + R.drawable.n1 + ",7)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (135,'Dos', " + R.drawable.n2 + ",7)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (136,'Tres', " + R.drawable.n3 + ",7)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (137,'Cuatro', " + R.drawable.n4 + ",7)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (138,'Cinco', " + R.drawable.n5 + ",7)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (139,'Seis', " + R.drawable.n6 + ",7)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (140,'Siete', " + R.drawable.n7 + ",7)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (141,'Ocho', " + R.drawable.n8 + ",7)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (142,'Nueve', " + R.raw.n9 + ",7)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (143,'Diez', " + R.raw.n10 + ",7)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (144,'Once', " + R.raw.n11 + ",7)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (145,'Doce', " + R.raw.n12 + ",7)");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_SENAS + "(" +
                COLUMN_SENAS_ID + "," + COLUMN_SENAS_PALABRA + "," + COLUMN_SENAS_RESOURCE + "," +
                COLUMN_SENA_CATEGORIA_ID + ") VALUES (146,'Trece', " + R.raw.n13 + ",7)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_SENAS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORIAS);
        onCreate(sqLiteDatabase);
    }

    /*public void insertCategoria(CategoriaSenas categoriaSenas){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CATEGORIAS_NOMBRE,categoriaSenas.getNombreCategoria());
        db.insert(TABLE_CATEGORIAS,null,values);
        Log.e("","Hola");
    }

    public void insertSena(Senas senas){
        SQLiteDatabase db = this.getWritableDatabase();
    }*/
}
