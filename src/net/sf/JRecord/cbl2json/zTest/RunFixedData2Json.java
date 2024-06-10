package net.sf.JRecord.cbl2json.zTest;

import net.sf.JRecord.cbl2json.zTest.json2cbl.Cbl2JsonCode;
import net.sf.cobolToJson.Data2Json;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.net.URISyntaxException;

public class RunFixedData2Json {

    public static void main(String[] args) throws XMLStreamException, IOException, URISyntaxException {

        RunFixedData2Json runFixedData2Json = new RunFixedData2Json();
        runFixedData2Json.run();
    }

    public void runCmd() throws XMLStreamException, IOException {


        String cbl1 = Cbl2JsonCode.getFullName("/copybook.cbl");
        String forgText = "text";
        String poRec = "PO-Record";
        String recType = "Record-Type";
        String productRec = "Product-Record";
        String locationRec = "Location-Record";
        String poValue = "H1";
        String productValue = "D1";
        String storeValue = "S1";


        String in= Cbl2JsonCode.getFullName("/fixedLengthData.txt");
        String out = "output.json";
        String[] arg = {
                "-cobol", cbl1, "-fileOrganisation", forgText,
                "-recordSelection", poRec, recType + "=" + poValue,
                "-recordSelection", productRec, recType + "=" + productValue,
                "-recordSelection", locationRec, recType + "=" + storeValue,
                "-input", in,
                "-output", out,
        };
        Data2Json.main(arg);
    }

    public void run() throws XMLStreamException, IOException, URISyntaxException {
        String cbl1 = Cbl2JsonCode.getFileNameFromJar("copybook.cbl");
        String forgText = "text";
        String poRec = "PO-Record";
        String recType = "Record-Type";
        String productRec = "Product-Record";
        String locationRec = "Location-Record";
        String poValue = "H1";
        String productValue = "D1";
        String storeValue = "S1";

        String in = Cbl2JsonCode.getFileNameFromJar("fixedLengthData.txt");
        String out = "output.json";
        String[] arg = {
                "-cobol", cbl1, "-fileOrganisation", forgText,
                "-recordSelection", poRec, recType + "=" + poValue,
                "-recordSelection", productRec, recType + "=" + productValue,
                "-recordSelection", locationRec, recType + "=" + storeValue,
                "-input", in,
                "-output", out,
        };
        Data2Json.main(arg);
    }

}
