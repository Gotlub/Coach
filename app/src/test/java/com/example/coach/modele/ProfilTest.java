package com.example.coach.modele;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Date;

public class ProfilTest {

    @Test
    public void getImg() {
    }

    @Test
    public void getMessage() {
    }

    @Test
    public void testGetMessage(){
        assertEquals(message, profil.getMessage());
    }

    @Test
    public void testGetImg(){
        assertEquals(img, profil.getImg(), (float)0.1);
    }
    // création d’un profil : femme de 67kg, 1m65, 35 ans
    private Profil profil = new Profil(67, 165, 35, 0, new Date());
    // résultat de l’img correspondant
    private float img = (float)32.2 ;
    // message correspondant
    private String message = "trop élevé" ;
}