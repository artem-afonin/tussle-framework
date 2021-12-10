package org.benchmarks.tools.processors;

import java.io.InputStream;
import java.util.logging.Logger;

import org.benchmarks.metrics.MetricData;

public interface DataLogProcessor {
    boolean processData(MetricData metricData, InputStream inputStream, String host, Logger logger);
}
