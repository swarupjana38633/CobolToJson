package net.sf.cobolToJson.def.annotation;

import com.sun.codemodel.JDefinedClass;
import org.jsonschema2pojo.AbstractTypeInfoAwareAnnotator;
import org.jsonschema2pojo.GenerationConfig;

public class CamelBindyAnnotator extends AbstractTypeInfoAwareAnnotator {

    public CamelBindyAnnotator(GenerationConfig generationConfig) {
        super(generationConfig);
    }

    @Override
    protected void addJsonTypeInfoAnnotation(JDefinedClass jClass, String propertyName) {

//        clazz.annotate(JsonProperty.class).param("value", propertyName);
    }
}
