package br.ifpb.simba.ourdata.heideltime;

import de.unihd.dbs.heideltime.standalone.DocumentType;
import de.unihd.dbs.heideltime.standalone.HeidelTimeStandalone;
import de.unihd.dbs.heideltime.standalone.OutputType;
import de.unihd.dbs.heideltime.standalone.POSTagger;
import de.unihd.dbs.heideltime.standalone.components.impl.TimeMLResultFormatter;
import de.unihd.dbs.heideltime.standalone.exceptions.DocumentCreationTimeMissingException;
import de.unihd.dbs.uima.annotator.heideltime.resources.Language;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 *
 * @version 1.0
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
 */
public class TimeMLReader {

    public static final String DEFAULT_CONFIGPROPS_PATH
            = "/home/wensttay/Documentos/DevWorkspace/Projetos de Pesquisa/OurData/Projects/HeidelTime/config.props";

    private SAXBuilder builder;
    private HeidelTimeStandalone heidelTimeStandalone;
    private String configPropsPath;
    private Reader reader;
    TimeMLResultFormatter timeMLResultFormatter;

    public TimeMLReader() {
        this.configPropsPath = DEFAULT_CONFIGPROPS_PATH;
        this.builder = new SAXBuilder();
        this.heidelTimeStandalone = new HeidelTimeStandalone(Language.PORTUGUESE,
                DocumentType.NEWS,
                OutputType.TIMEML, this.configPropsPath, POSTagger.NO, false);
        this.timeMLResultFormatter = new TimeMLResultFormatter();
    }

    public TimeMLReader(String configPropsPath) {
        this.configPropsPath = configPropsPath;
        this.builder = new SAXBuilder();
        this.heidelTimeStandalone = new HeidelTimeStandalone(Language.PORTUGUESE,
                DocumentType.NEWS,
                OutputType.TIMEML, this.configPropsPath, POSTagger.NO, false);
        this.timeMLResultFormatter = new TimeMLResultFormatter();
    }

    public List<Result> read(String text, Date currentData) throws JDOMException, IOException, DocumentCreationTimeMissingException {

        List<Result> list = new ArrayList<>();
        List listtimevalues = ListFromXml(text, currentData);
        Iterator i = listtimevalues.iterator();

        while (i.hasNext()) {
            Element timevalue = (Element) i.next();
            Result stv = new Result();
            stv.setData(timevalue.getText());
            stv.setId(timevalue.getAttributeValue("tid"));
            stv.setType(timevalue.getAttributeValue("type"));
            stv.setValue(timevalue.getAttributeValue("value"));
            list.add(stv);
        }

        return Collections.unmodifiableList(list);
    }

    public List ListFromXml(String text, Date currentData) throws JDOMException, IOException, DocumentCreationTimeMissingException {

        if (text == null) {
            return Collections.EMPTY_LIST;
        }

        String xml = "";
        
        if (currentData != null) {
            xml = heidelTimeStandalone.process(text, currentData, timeMLResultFormatter);
        } else {
            
            HeidelTimeStandalone hts = new HeidelTimeStandalone(Language.PORTUGUESE,
                DocumentType.NARRATIVES,
                OutputType.TIMEML, this.configPropsPath, POSTagger.NO, false);
            
            xml = hts.process(text, timeMLResultFormatter);
        }
        
        reader = new StringReader(xml);
        Document doc = builder.build(reader);
        Element root = (Element) doc.getRootElement();
        List result = root.getChildren();

        reader.close();
        return result;
    }

}
