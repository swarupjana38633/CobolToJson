/**
 * 
 */
package net.sf.cobolToJson;

import net.sf.JRecord.Common.RecordException;
import net.sf.cobolToJson.impl.ConvertOptions;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

/**
 * Convert Cobol Data File to Xml using a Cobol copybook
 * 
 * @author Bruce Martin
 *
 */
public class Data2Json {

	/**
	 * @param args program arguments
	 * 
	 */
	public static void main(String[] args) throws RecordException, IOException,  XMLStreamException {
		ConvertOptions opts = new ConvertOptions(args);
		
		if (opts.isOk()) {
			Cobol2Json.newJsonConverter(opts)
					 .cobol2json(opts.inputFile, opts.outputFile);
		}
	}
}
