package me.vinceh121.jskolengo.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import me.vinceh121.jskolengo.SkolengoConstants;
import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;

class TestMapper {

	@Test
	@SuppressWarnings("unchecked")
	void testClassList() {
		Reflections ref = new Reflections("me.vinceh121.jskolengo.entities", Scanners.SubTypes);
		List<Class<? extends AbstractSkolengoEntity>> expected
				= new ArrayList<>(ref.getSubTypesOf(AbstractSkolengoEntity.class));
		List<Class<? extends AbstractSkolengoEntity>> actual = new ArrayList<>();
		for (Class<?> o : SkolengoConstants.ENTITY_CLASSES) {
			actual.add((Class<? extends AbstractSkolengoEntity>) o);
		}

		expected.sort((c1, c2) -> c1.getCanonicalName().compareTo(c2.getCanonicalName()));
		actual.sort((c1, c2) -> c1.getCanonicalName().compareTo(c2.getCanonicalName()));

		String expectedStr = classesToString(expected);
		String actualStr = classesToString(actual);

		Assertions.assertEquals(expectedStr, actualStr);
	}

	private static String classesToString(Collection<Class<? extends AbstractSkolengoEntity>> cls) {
		StringBuilder sb = new StringBuilder();
		for (Class<? extends AbstractSkolengoEntity> c : cls) {
			sb.append(c.getSimpleName());
			sb.append(".class,\n");
		}
		return sb.toString();
	}
}
