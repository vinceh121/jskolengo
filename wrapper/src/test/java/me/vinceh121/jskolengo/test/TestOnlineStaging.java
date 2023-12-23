package me.vinceh121.jskolengo.test;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import me.vinceh121.jskolengo.JSkolengo;
import me.vinceh121.jskolengo.SkolengoConstants;

@Tag("online")
class TestOnlineStaging {
	static JSkolengo skolengo = new JSkolengo();

	@BeforeAll
	static void setup() {
		skolengo.setBaseUrl(SkolengoConstants.STAGING_BASE_URL);
	}

	@BeforeEach
	void clean(TestInfo testInfo) {
		System.out.println("\n---------- " + testInfo.getDisplayName());
	}

	@Test
	void schoolsText() {
		skolengo.searchSchools("France").stream().limit(3).forEach(System.out::println);
	}

	@Test
	void schoolsLoc() {
		skolengo.searchSchools(47.2134260d, -1.5542333d).stream().limit(3).forEach(System.out::println);
	}

	@Test
	void config() throws IOException {
		System.out.println(skolengo.fetchConfig().get());
	}
}
