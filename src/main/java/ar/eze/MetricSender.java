package ar.eze;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;

public class MetricSender {

	public static void main(String[] args) throws InterruptedException {
		OpenTelemetry openTelemetry = ExampleConfiguration.initOpenTelemetry();

		Meter meter = openTelemetry.getMeter("io.opentelemetry.example");
		LongCounter counter = meter.counterBuilder("example_counter").build();

		// Incrementar la métrica
		for (int i = 0; i < 10; i++) {
			counter.add(1);
			Thread.sleep(1000);
		}
	}

}
