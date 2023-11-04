package com.example.coach.modele;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProfilTest {

    @Test
    public void getImg() {
    }

    @Test
    public void getMessage() {
    }

    // création d’un profil : femme de 67kg, 1m65, 35 ans
    private Profil profil = new Profil(67, 165, 35, 0);
    // résultat de l’img correspondant
    private float img = (float)32.4 ;
    // message correspondant
    private String message = "trop élevé" ;
}