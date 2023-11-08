package com.example.coach.controleur;

import android.content.Context;

import com.example.coach.modele.AccesLocal;
import com.example.coach.modele.Profil;
import com.example.coach.outils.Serializer;

import java.io.Serializable;
import java.util.Date;

public final class Controle {
    private static Controle instance = null;

    private static Profil profil;

    private static String nomFic = "saveprofil";

    private AccesLocal accesLocal;

    private Controle(Context context){
        super();
        this.accesLocal = AccesLocal.getInstance(context);
        profil = this.accesLocal.recupDernier();
        //recupSerialize(context);
    }

    public static final Controle getInstance(Context context){
        if(instance == null){
            Controle.instance = new Controle(context);
        }
        return instance;
    }

    public void creerProfil(Integer poids, Integer taille, Integer age, Integer sexe, Context context){
        profil = new Profil(poids, taille, age, sexe, new Date());
        this.accesLocal.ajout(profil);
        //Serializer.serialize(nomFic, profil, context);
    }

    /**
     * Retourne le poids si le profil existe
     * @return
     */
    public Integer getPoid(){
        if(profil == null){
            return null;
        }else{
            return profil.getPoids();
        }
    }

    /**
     * Retourne la taille si le profil existe
     * @return
     */
    public Integer getTaille(){
        if(profil == null){
            return null;
        }else{
            return profil.getTaille();
        }
    }

    /**
     * Retourne l'âge si le profil existe
     * @return
     */
    public Integer getAge(){
        if(profil == null){
            return null;
        }else{
            return profil.getAge();
        }
    }

    /**
     * Retourne le sexe si le profil existe
     * @return
     */
    public Integer getSexe(){
        if(profil == null){
            return null;
        }else{
            return profil.getSexe();
        }
    }

    public Float getImg(){
        if(this.profil.getImg() != null)
            return this.profil.getImg();
        else
            return (float)0;
    }

    public String getMessage(){
        if(this.profil.getMessage() != null)
            return this.profil.getMessage();
        else
            return "";
    }

    private static void recupSerialize(Context context){
        profil = (Profil)Serializer.deSerialize(nomFic, context);
    }
}
