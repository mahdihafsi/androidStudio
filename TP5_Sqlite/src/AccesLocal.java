package com.example.coach.modele;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.coach.tools.MySQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AccesLocal {
    // proprietes
    private String nomBase = "bdCoach.sqlite";
    private Integer versionBase = 1 ;
    private MySQLiteOpenHelper accesBD;
    private SQLiteDatabase bd;

    public AccesLocal(Context context) {
        accesBD = new MySQLiteOpenHelper(context,nomBase,null,versionBase);
    }

    /**
     * ajout d'un profile dans la BD
     * @param profil
     */
    public void ajout(Profil profil){
        bd = accesBD.getWritableDatabase();
        String req = "INSERT INTO profil (datemesure , poids , taille , age , sexe ) VALUES ";
        req += "(\""+profil.getDateMesure()+"\","+profil.getPoids()+","+profil.getTaille()+","+profil.getAge()+","+profil.getSexe()+")";
        try {
            bd.execSQL(req);
        } catch (Exception e) {
            Log.e("AccesLocal", "Erreur lors de l'exécution de la requête SQL : " + req, e);
        }

    }

    /**
     * recuperation de dernier Profile de la BD
     * @return
     */

    public Profil recupDernier(){
        bd = accesBD.getReadableDatabase();
        Profil profil = null;
        String req = "select * from profil";
        Cursor cursor = bd.rawQuery(req, null);
        cursor.moveToLast();
        if(!cursor.isAfterLast()){
            Date date = new Date();
            Integer poids = cursor.getInt(1);
            Integer taille = cursor.getInt(2);
            Integer age = cursor.getInt(3);
            Integer sexe = cursor.getInt(4);

            profil = new Profil(date,poids,taille,age,sexe);

        }
        cursor.close();
        return profil;
    }
}
