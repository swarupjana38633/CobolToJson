package net.sf.JRecord.cbl2json.zTest;

import com.sun.codemodel.JCodeModel;
import net.sf.JRecord.Common.IFileStructureConstants;
import net.sf.JRecord.External.CopybookLoader;
import net.sf.JRecord.Option.IReformatFieldNames;
import net.sf.JRecord.cbl2json.zTest.json2cbl.Cbl2JsonCode;
import net.sf.cobolToJson.Cobol2Json;
import net.sf.cobolToJson.def.ICobol2Json;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

public class RunData2JavaPojo {

    public static void main(String[] args) throws IOException {

        ICobol2Json jsnBldr = Cobol2Json.newCobol2Json(Cbl2JsonCode.getFullName("cobol/amsPoDownload.cbl"))
                .setFileOrganization(IFileStructureConstants.IO_BIN_TEXT)
                .setPrettyPrint(true)
                .setSplitCopybook(CopybookLoader.SPLIT_01_LEVEL)
                .setTagFormat(IReformatFieldNames.RO_UNDERSCORE);
        StringWriter schemaWriter = new StringWriter();
        jsnBldr.jsonSchemaForCobol2json(schemaWriter);
        System.out.println(schemaWriter.toString());
        String jsonSchema = schemaWriter.toString();

        JCodeModel codeModel = getjCodeModel(jsonSchema);
        File file = new File("src");
        codeModel.build(file);

    }

    private static JCodeModel getjCodeModel(String jsonSchema) throws IOException {
        JCodeModel codeModel = new JCodeModel();
        GenerationConfig config = new DefaultGenerationConfig(){

            @Override
            public boolean isGenerateBuilders() {
                return true;
            }

            @Override
            public SourceType getSourceType() {
                return SourceType.JSONSCHEMA;
            }
        };
        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new NoopAnnotator(), new SchemaStore()), new SchemaGenerator());
        SchemaMapper m = new SchemaMapper();
        mapper.generate(codeModel, "jsonSchema", "net.sf.JRecord.cbl2json.zTest.pojo", jsonSchema);
        return codeModel;
    }
}
