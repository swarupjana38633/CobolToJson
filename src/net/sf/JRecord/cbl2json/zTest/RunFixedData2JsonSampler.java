package net.sf.JRecord.cbl2json.zTest;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.io.Serializable;

public class RunFixedData2JsonSampler extends AbstractJavaSamplerClient implements Serializable {
    @Override
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        RunFixedData2Json runFixedData2Json = new RunFixedData2Json();
        SampleResult sampleResult = new SampleResult();
        sampleResult.sampleStart();

        try {
            runFixedData2Json.run();
            sampleResult.setSuccessful(true);
        } catch (Exception e) {
            sampleResult.setSuccessful(false);
        } finally {
            sampleResult.sampleEnd();
        }
        return sampleResult;
    }
}
