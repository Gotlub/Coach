package com.example.coach.controleur;

import com.example.coach.modele.Profil;

public final class Controle {
    private static Controle instance = null;

    private static Profil profil;

    private Controle(){
        super();
    }

    public static final Controle getInstance(){
        if(instance == null){
            Controle.instance = new Controle();
        }
        return instance;
    }

    public  void creerProfil(Integer poids, Integer taille, Integer age, Integer sexe){
        profil = new Profil(poids, taille, age, sexe);
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
}
