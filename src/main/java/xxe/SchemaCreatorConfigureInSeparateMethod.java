package xxe;

import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.net.MalformedURLException;
import java.net.URI;

public class SchemaCreatorConfigureInSeparateMethod {

    public static Schema createSchema() throws SAXException,
                                               MalformedURLException {

        var schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        safelyConfigureSchemaFactory(schemaFactory);

        var schemaFile = URI.create("some-file.xsd")
                            .toURL();
        return schemaFactory.newSchema(schemaFile);
    }

    private static void safelyConfigureSchemaFactory(SchemaFactory schemaFactory) throws SAXNotSupportedException,
                                                                                         SAXNotRecognizedException {
        schemaFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
    }

}
