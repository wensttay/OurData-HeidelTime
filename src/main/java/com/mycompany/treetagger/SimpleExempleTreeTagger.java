/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.treetagger;
import com.mycompany.treetagger.TreeTaggerTokenHandler;
import org.annolab.tt4j.TreeTaggerWrapper;


/**
 *
 * @author Fabio
 */
public class SimpleExempleTreeTagger {
    
    
    public static void main(String[] args){
        try{
            String text = "I worked there from 2012 to 2016";
            
            System.setProperty("treetagger.home", "/home/wensttay/Documentos/DevPrograms/tree-tagger-linux-3.2.1");
            TreeTaggerWrapper tt = new TreeTaggerWrapper();
            tt.setModel("/home/wensttay/Documentos/DevPrograms/tree-tagger-linux-3.2.1/lib/english.par");
            tt.setHandler(new TreeTaggerTokenHandler());
            tt.process(text.split(" "));
            tt.destroy();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
