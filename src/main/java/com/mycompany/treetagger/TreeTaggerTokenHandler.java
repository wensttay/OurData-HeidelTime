/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.treetagger;

import org.annolab.tt4j.TokenHandler;

/**
 *
 * @author Fabio
 */
public class TreeTaggerTokenHandler implements TokenHandler{

    @Override
    public void token(Object token, String pos, String lemma) {
        System.out.println("Token -> "+token);
        System.out.println("Pos -> "+pos);
        System.out.println("Lemma -> "+lemma);
        System.out.println("");
        
    }
    
}
