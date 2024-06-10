package net.sf.JRecord.cbl2json.zTest;

import net.sf.JRecord.Common.IFileStructureConstants;
import net.sf.JRecord.External.CopybookLoader;
import net.sf.JRecord.Option.IReformatFieldNames;
import net.sf.JRecord.cbl2json.zTest.json2cbl.Cbl2JsonCode;
import net.sf.cobolToJson.Cobol2Json;

import java.io.IOException;
import java.net.URISyntaxException;

public class RunJson2FixedData {

    public static void main(String[] args) throws IOException, URISyntaxException {
        RunJson2FixedData runJson2FixedData = new RunJson2FixedData();
        runJson2FixedData.runCmd();
    }

    public void runCmd() throws IOException {
        Cobol2Json.newCobol2Json(Cbl2JsonCode.getFullName("/copybook.cbl"))
                .setFileOrganization(IFileStructureConstants.IO_FIXED_LENGTH_CHAR)
                .setSplitCopybook(CopybookLoader.SPLIT_01_LEVEL)
                .setTagFormat(IReformatFieldNames.RO_UNDERSCORE)
                .setRecordSelection("PO-Record", Cobol2Json.newFieldSelection("Record-Type","H1"))
                .setRecordSelection("Product-Record", Cobol2Json.newFieldSelection("Record-Type","D1"))
                .setRecordSelection("Location-Record", Cobol2Json.newFieldSelection("Record-Type","S1"))
                .jsonArrayToCobolFile(Cbl2JsonCode.getFullName("/output.json"),
                        "output.txt");
    }

    public  void run() throws URISyntaxException, IOException {
        Cobol2Json.newCobol2Json(Cbl2JsonCode.getFileNameFromJar("/copybook.cbl"))
                .setFileOrganization(IFileStructureConstants.IO_FIXED_LENGTH_CHAR)
                .setSplitCopybook(CopybookLoader.SPLIT_01_LEVEL)
                .setTagFormat(IReformatFieldNames.RO_UNDERSCORE)
                .setRecordSelection("PO-Record", Cobol2Json.newFieldSelection("Record-Type","H1"))
                .setRecordSelection("Product-Record", Cobol2Json.newFieldSelection("Record-Type","D1"))
                .setRecordSelection("Location-Record", Cobol2Json.newFieldSelection("Record-Type","S1"))
                .jsonArrayToCobolFile(Cbl2JsonCode.getFileNameFromJar("/output.json"),
                        "output.txt");
    }
}
