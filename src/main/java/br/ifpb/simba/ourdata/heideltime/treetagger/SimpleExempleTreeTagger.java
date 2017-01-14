package br.ifpb.simba.ourdata.heideltime.treetagger;

import org.annolab.tt4j.TreeTaggerWrapper;

/**
 *
 * @author Fabio
 */
public class SimpleExempleTreeTagger {

    public static void main(String[] args) {
        try {
            System.out.println(System.getProperty("user.dir"));
            String text = "I worked there from 2012 to 2016";
            String treetageerHome = "/home/wensttay/Program Files/Treetagger";

            System.setProperty("treetagger.home", treetageerHome);
            TreeTaggerWrapper tt = new TreeTaggerWrapper();
            tt.setModel(treetageerHome + "/lib/english-utf8.par");
            tt.setHandler(new TreeTaggerTokenHandler());
            tt.process(text.split(" "));
            tt.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
