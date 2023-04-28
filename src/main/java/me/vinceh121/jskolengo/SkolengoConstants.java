package me.vinceh121.jskolengo;

import me.vinceh121.jskolengo.entities.School;
import me.vinceh121.jskolengo.entities.SkoAppConfig;
import me.vinceh121.jskolengo.entities.info.News;
import me.vinceh121.jskolengo.entities.info.SchoolInfoAuthor;
import me.vinceh121.jskolengo.entities.info.SchoolInfoFile;
import me.vinceh121.jskolengo.entities.info.SchoolInfoTechnicalUser;
import me.vinceh121.jskolengo.entities.people.NonTeachingStaff;
import me.vinceh121.jskolengo.entities.people.OtherPerson;
import me.vinceh121.jskolengo.entities.people.Teacher;

public final class SkolengoConstants {
	public static final String BASE_URL = "https://api.skolengo.com/api/v1/bff-sko-app", PROD_VIRT_HOST = "bff-prod-ha",
			PROD_HOST = "api.skolengo.com";
	public static final Class<?>[] ENTITY_CLASSES = new Class<?>[] {
			School.class,
			SkoAppConfig.class,
			News.class,
			OtherPerson.class,
			NonTeachingStaff.class,
			Teacher.class,
			SchoolInfoAuthor.class,
			SchoolInfoTechnicalUser.class,
			SchoolInfoFile.class };
}
