package com.localizestock.util;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;

import java.util.Collections;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class GoogleAuthUtil {

    private static final String CLIENT_ID = "622950579838-97mkq86628q3meeeancen23tv2bkfp0j.apps.googleusercontent.com";

    public static GoogleIdToken verificarToken(String tokenString) throws GeneralSecurityException, IOException {
        
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
                .setAudience(Collections.singletonList(CLIENT_ID))
                .build();

        return verifier.verify(tokenString);
    }
}