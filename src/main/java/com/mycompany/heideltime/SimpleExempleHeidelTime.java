/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.heideltime;

import de.unihd.dbs.heideltime.standalone.DocumentType;
import de.unihd.dbs.heideltime.standalone.HeidelTimeStandalone;
import de.unihd.dbs.uima.annotator.heideltime.resources.Language;
import de.unihd.dbs.heideltime.standalone.OutputType;
import de.unihd.dbs.heideltime.standalone.POSTagger;
import de.unihd.dbs.heideltime.standalone.components.impl.TimeMLResultFormatter;
import java.util.Date;
import java.util.List;
import org.jdom.input.SAXBuilder;

/**
 *
 * @author Fabio
 */
public class SimpleExempleHeidelTime {

    public static void main(String[] args) {
        try {
            String path = "/home/wensttay/Documentos/DevWorkspace/Projetos de Pesquisa/OurData/Projects/HeidelTime/config.props";
            HeidelTimeStandalone hts = new HeidelTimeStandalone(Language.PORTUGUESE,
                    DocumentType.NEWS,
                    OutputType.TIMEML, path, POSTagger.NO, false);

            Date currentData;
            String xml = "";
//            Period htPeriod, segundohtPeriod;
            TimeMLResultFormatter timeMLResultFormatter = new TimeMLResultFormatter();

            String text = "may";
            currentData = new Date(System.currentTimeMillis());
            xml = hts.process(text, currentData, timeMLResultFormatter);

//            List<Date> readStringDates = timeMLReader.readDates(xml);
//            readStringDates.forEach(System.out::println);
//            htPeriod = timeMLReader.findPeriod(xml);
//            if (htPeriod != null) {
//                System.out.println("\nPrimeiro Texto:");
//                System.out.println("Data de inicio: " + htPeriod.getStartDate().toString());
//                System.out.println("Data de Termino: " + htPeriod.getEndDate().toString());
//                System.out.println("");
//            }
//            String vaiIntersectar = "20/12/2000, 2/02/2001";
//            String naoVaiIntersectar = "20/12/2000, 2/02/1999";
//
//            currentData = new Date(System.currentTimeMillis());
//            xml = hts.process(naoVaiIntersectar, currentData, timeMLResultFormatter);
//            segundohtPeriod = timeMLReader.findPeriod(xml);
//            System.out.println("\nSegundo Texto:");
//            System.out.println("Data de inicio: " + segundohtPeriod.getStartDate().toString());
//            System.out.println("Data de Termino: " + segundohtPeriod.getEndDate().toString());
//            System.out.println("");
//
//            if (htPeriod != null) {
//                System.out.println("Intersectou?: " + htPeriod.intersect(segundohtPeriod));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
