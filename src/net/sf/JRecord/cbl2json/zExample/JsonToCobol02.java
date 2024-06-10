package net.sf.JRecord.cbl2json.zExample;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;

import net.sf.JRecord.Common.IFileStructureConstants;
import net.sf.JRecord.External.CopybookLoader;
import net.sf.JRecord.Option.IReformatFieldNames;
import net.sf.JRecord.cbl2json.zTest.json2cbl.Cbl2JsonCode;
import net.sf.cobolToJson.Cobol2Json;

public class JsonToCobol02 {

	public static void main(String[] args) throws JsonParseException, IOException {

		Cobol2Json.newCobol2Json(Cbl2JsonCode.getFullName("cobol/copybook.cbl"))
				.setFileOrganization(IFileStructureConstants.IO_FIXED_LENGTH_CHAR)
				.setSplitCopybook(CopybookLoader.SPLIT_01_LEVEL)
				.setTagFormat(IReformatFieldNames.RO_UNDERSCORE)
				.setRecordSelection("PO-Record", Cobol2Json.newFieldSelection("Record-Type","H1"))
				.setRecordSelection("Product-Record", Cobol2Json.newFieldSelection("Record-Type","D1"))
				.setRecordSelection("Location-Record", Cobol2Json.newFieldSelection("Record-Type","S1"))
				.jsonArrayToCobolFile("src/net/sf/JRecord/cbl2json/zTest/output.json",
						"src/net/sf/JRecord/cbl2json/zTest/output.txt");


	}

}
