package br.ifpb.simba.ourdata.heideltime.treetagger;

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
