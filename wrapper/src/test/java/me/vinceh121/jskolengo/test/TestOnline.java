package me.vinceh121.jskolengo.test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import me.vinceh121.jskolengo.JSkolengo;
import me.vinceh121.jskolengo.entities.agenda.Agenda;
import me.vinceh121.jskolengo.entities.agenda.Lesson;
import me.vinceh121.jskolengo.entities.evaluation.EvaluationsSetting;
import me.vinceh121.jskolengo.entities.evaluation.Period;

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
	@TestMethodOrder(OrderAnnotation.class)
	@Nested
	@Timeout(value = 10, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	class Authenticated {

		@Test
		@Order(1)
		void evaluationSettings() {
			skolengo.fetchEvaluationsSetting().forEach(System.out::println);
		}

		@Test
		@Order(2)
		void evaluations() {
			EvaluationsSetting evaluationsSetting = skolengo.fetchEvaluationsSetting().stream().findAny().get();
			Period p = evaluationsSetting.getPeriods().get(0);

			skolengo.fetchEvaluations(p.getId()).stream().limit(3).forEach(System.out::println);
		}

		@Test
		@Order(1)
		void agendas() {
			List<Agenda> list = skolengo.fetchAgendas(LocalDate.now().minusMonths(1), LocalDate.now())
					.stream()
					.limit(3)
					.collect(Collectors.toUnmodifiableList());
			assertNotEquals(0, list.size());
			list.forEach(System.out::println);
		}

		@Test
		@Order(2)
		void lessons() throws IOException {
			for (Agenda a : skolengo.fetchAgendas(LocalDate.now().minusMonths(1), LocalDate.now())) {
				for (Lesson l : a.getLessons()) {
					System.out.println(skolengo.fetchLesson(l.getId()).get());
				}
			}
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
