/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.heideltime;

import de.unihd.dbs.heideltime.standalone.exceptions.DocumentCreationTimeMissingException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.jdom.JDOMException;

/**
 *
 * @author wensttay
 */
public class Main {

    public static void main(String[] args) {
        TimeMLReader lReader = new TimeMLReader();

        try {
            int i = 0;
            while (i < 10) {
                System.out.println("Caso " + i);
                List<Result> read = lReader.read("", new Date());
                for (Result object : read) {
                    System.out.println(object.toString());
                }
                i++;
                System.in.read();
            }
        } catch (JDOMException | IOException | DocumentCreationTimeMissingException ex) {
            ex.printStackTrace();
        }
    }
}
