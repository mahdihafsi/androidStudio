package com.example.coach.controlleur;

import android.content.Context;

import com.example.coach.modele.AccesLocal;
import com.example.coach.modele.Profil;


import java.util.Date;

public final class Control {
    private static Control instance = null;
    private static Profil profil;
    private static AccesLocal accesLocal;
    /**
     * constructeur private
     */
    private Control(){
        super();
    }

    /**
     * Creation de l'instance
     * @return instance
     */
    public static final Control getInstance(Context context){
        if (Control.instance == null){
            Control.instance = new Control();
            accesLocal = new AccesLocal(context);
            profil = accesLocal.recupDernier();
        }
        return  Control.instance;
    }

    /**
     * Creation de profile
     * @param poids
     * @param taille en cm
     * @param age
     * @param sexe 1 pour homme et 0 pour femme
     */
    public void creerProfil(Integer poids , Integer taille , Integer age , Integer sexe , Context context){
        profil = new Profil(new Date(), poids , taille , age , sexe );
        accesLocal.ajout(profil);
    }

    /**
     * recuperation img de profil
     * @return img
     */
    public float getImg(){
        return profil.getImg();
    }

    /**
     * recuperation de message de profil
     * @return message
     */
    public String getMessage(){
        return profil.getMessage();
    }



    public Integer getPoids(){
        if(profil == null){
            return null;
        }else
            return profil.getPoids();
    }

    public Integer getTaille(){
        if (profil==null){
            return null ;
        }else
            return profil.getTaille();
    }

    public Integer getAge(){
        if (profil==null){
            return null ;
        }else
            return profil.getAge();
    }

    public Integer getSexe(){
        if (profil==null){
            return null ;
        }else
            return profil.getSexe();
    }
}
