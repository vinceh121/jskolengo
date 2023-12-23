package me.vinceh121.jskolengo;

import org.apache.hc.client5.http.impl.DefaultHttpRequestRetryStrategy;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.TimeValue;

/**
 * Certain endpoints like /evaluation-services return a 503 + Retry-After,
 * triggering the retry strategy. However, the value in the header is
 * erroneously specified in milliseconds instead of seconds
 */
public class SkolengoRetryStrategy extends DefaultHttpRequestRetryStrategy {
	public SkolengoRetryStrategy() {
		super(50, TimeValue.ofMilliseconds(500));
	}

	@Override
	public TimeValue getRetryInterval(HttpResponse response, int execCount, HttpContext context) {
		return super.getRetryInterval(response, execCount, context).divide(1000);
	}
}
