package net.sf.JRecord.cbl2json.zTest;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.io.Serializable;

public class RunJson2FixedDataSampler extends AbstractJavaSamplerClient implements Serializable {
    @Override
    public SampleResult runTest(JavaSamplerContext context) {
        RunJson2FixedData runJson2FixedData = new RunJson2FixedData();
        SampleResult sampleResult = new SampleResult();
        sampleResult.sampleStart();

        try {
            runJson2FixedData.run();
            sampleResult.setSuccessful(true);
        } catch (Exception e) {
            sampleResult.setSuccessful(false);
        }finally {
            sampleResult.sampleEnd();
        }
        return sampleResult;
    }
}
