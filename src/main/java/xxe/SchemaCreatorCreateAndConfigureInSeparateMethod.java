package xxe;

import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.net.MalformedURLException;
import java.net.URI;

public class SchemaCreatorCreateAndConfigureInSeparateMethod {

    public static Schema createSchema() throws SAXException,
                                               MalformedURLException {
        var schemaFactory = getSafeSchemaFactory();

        var schemaFile = URI.create("some-file.xsd")
                            .toURL();
        return schemaFactory.newSchema(schemaFile);
    }

    private static SchemaFactory getSafeSchemaFactory() throws SAXNotSupportedException,
                                                               SAXNotRecognizedException {
        var schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        schemaFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
        return schemaFactory;
    }

}
