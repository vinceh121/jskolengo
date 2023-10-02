package me.vinceh121.jskolengo.test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import me.vinceh121.jskolengo.JSkolengo;
import me.vinceh121.jskolengo.entities.agenda.Agenda;

@Tag("online")
class TestOnline {
	static JSkolengo skolengo = new JSkolengo();

	@BeforeAll
	static void init() throws IOException {
		skolengo.setSchoolId(
				new String(TestOnline.class.getClassLoader().getResourceAsStream("schoolId").readAllBytes()));
		skolengo.setEmsCode(
				new String(TestOnline.class.getClassLoader().getResourceAsStream("emsCode").readAllBytes()));
		skolengo.setBearerToken(
				new String(TestOnline.class.getClassLoader().getResourceAsStream("accessToken").readAllBytes()));
	}
	
	@BeforeEach
	void clean(TestInfo testInfo) {
		System.out.println("\n---------- " + testInfo.getDisplayName());
	}

	@Tag("authenticated")
	@Nested
	class Authenticated {
		@Test
		void evaluationSettings() {
			skolengo.fetchEvaluationsSetting().forEach(System.out::println);
		}

		@Test
		void agendas() {
			List<Agenda> list = skolengo.fetchAgendas(LocalDate.now().minusMonths(1), LocalDate.now())
					.stream()
					.limit(3)
					.collect(Collectors.toUnmodifiableList());
			assertNotEquals(0, list.size());
			list.forEach(System.out::println);
		}

		@Test
		void userInfo() throws IOException {
			System.out.println(skolengo.fetchUserInfo().get());
		}
		
		@Test
		void schoolInfo() throws IOException {
			System.out.println(skolengo.fetchSchoolInfo().get());
		}
	}

	@Nested
	class Anonymous {
		@Test
		void schoolsText() {
			skolengo.searchSchools("France").stream().limit(3).forEach(System.out::println);
		}

		@Test
		void schoolsLoc() {
			skolengo.searchSchools(43.6044622, 1.4442469).stream().limit(3).forEach(System.out::println);
		}

		@Test
		void config() throws IOException {
			System.out.println(skolengo.fetchConfig().get());
		}
	}
}
