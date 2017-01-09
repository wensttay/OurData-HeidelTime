package br.ifpb.simba.ourdata.heideltime;

import de.unihd.dbs.heideltime.standalone.exceptions.DocumentCreationTimeMissingException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.jdom.JDOMException;

/**
 *
 * @version 1.0
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
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
