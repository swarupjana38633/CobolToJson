package net.sf.JRecord.cbl2json.zExample;

import java.io.IOException;

import net.sf.JRecord.Common.IFileStructureConstants;
import net.sf.JRecord.External.CopybookLoader;
import net.sf.JRecord.Option.IReformatFieldNames;
import net.sf.JRecord.cbl2json.zTest.json2cbl.Cbl2JsonCode;
import net.sf.cobolToJson.Cobol2Json;

public class JsonToCobol01 {

	public static void main(String[] args) throws IOException {
		Cobol2Json.newCobol2Json(Cbl2JsonCode.getFullName("cobol/cbl2xml_Test112.cbl"))
		  .setFont("cp037")
		  .setFileOrganization(IFileStructureConstants.IO_FIXED_LENGTH) 
		  .setSplitCopybook(CopybookLoader.SPLIT_NONE)

		  .jsonArrayToCobolFile("/Users/swarup.jana/Documents/HLI/projects/POC/CobolToJson/src/net/sf/JRecord/cbl2json/zTest/ms_PODownload_20041231_batch.json", "/Users/swarup.jana/Documents/HLI/projects/POC/CobolToJson/src/net/sf/JRecord/cbl2json/zExampleGen/StoreSales5.bin")
		  
		  .setTagFormat(IReformatFieldNames.RO_UNDERSCORE)
		  .jsonArrayToCobolFile("/Users/swarup.jana/Documents/HLI/projects/POC/CobolToJson/src/net/sf/JRecord/cbl2json/zTest/ms_PODownload_20041231_batch.json", "/Users/swarup.jana/Documents/HLI/projects/POC/CobolToJson/src/net/sf/JRecord/cbl2json/zExampleGen/StoreSales5.bin")
		  ;

		/*Cobol2Json.newCobol2Json(Cbl2JsonCode.getFullName("cobol/cbl2xml_Test112.cbl"))
				.setFont("cp037")
				.setFileOrganization(2)
				.setSplitCopybook(0)
				.jsonArrayToCobolFile("/Users/swarup.jana/Documents/HLI/projects/POC/CobolToJson/src/net/sf/JRecord/cbl2json/zTest/ms_PODownload_20041231_batch.json", "/Users/swarup.jana/Documents/HLI/projects/POC/CobolToJson/src/net/sf/JRecord/cbl2json/zExampleGen/StoreSales5.bin")
				.setTagFormat(1)
				.jsonArrayToCobolFile("/Users/swarup.jana/Documents/HLI/projects/POC/CobolToJson/src/net/sf/JRecord/cbl2json/zTest/ms_PODownload_20041231_batch.json", "/Users/swarup.jana/Documents/HLI/projects/POC/CobolToJson/src/net/sf/JRecord/cbl2json/zExampleGen/StoreSales5.bin");
*/
	}

}
