package com.example.coach.modele;

import java.io.Serializable;
import java.util.Date;

public class Profil implements Serializable {
    // constantes
    private static final Integer minFemme = 15; // maigre si en dessous
    private static final Integer maxFemme = 30; // gros si au dessus
    private static final Integer minHomme = 10; // maigre si en dessous
    private static final Integer maxHomme = 25; // gros si au dessus
    private Integer poids;
    private Integer taille;
    private Integer age;
    private Integer sexe;
    private Float img = (float) 0;
    private String message = "";

    public Date getDateMesure() {
        return dateMesure;
    }

    private Date dateMesure;

    public Profil(Integer poids, Integer taille, Integer age, Integer sexe, Date dateMesure) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
        this.dateMesure = dateMesure;
    }

    public Integer getPoids() {
        return poids;
    }

    public Integer getTaille() {
        return taille;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSexe() {
        return sexe;
    }

    public Float getImg() {
        if(img == 0) {
            float tailleMettre = ((float)taille)/100;
            img = (float) (1.2 * poids / (tailleMettre * tailleMettre) + (0.23 * age) - (10.83 * sexe) - 5.4);
        }
        return img;
    }

    public String getMessage() {
        img = getImg();
        if(message == "") {
            if (img != 0) {
                if ((img < (float) minFemme && sexe == 0) || (img < (float) minHomme && sexe == 1))
                    message = "trop faible";
                if ((img <= (float) maxFemme && sexe == 0) || (img <= (float) maxHomme && sexe == 1))
                    message = "normal";
                if ((img > (float) maxFemme && sexe == 0) || (img > (float) maxHomme && sexe == 1))
                    message = "trop élevé";
            }
        }
        return message;
    }
}
