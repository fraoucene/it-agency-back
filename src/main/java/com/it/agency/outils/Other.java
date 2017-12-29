package com.it.agency.outils;

import com.it.agency.beans.Candidat;

public class Other {
    public static final String DATEBASE_NAME = "it_agency";

    private Other() {
        super();
    }

    public static Candidat mockClient() {
        Candidat candidat = new Candidat();
        return candidat;
    }
}
