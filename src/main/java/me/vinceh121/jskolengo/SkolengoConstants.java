package me.vinceh121.jskolengo;

import me.vinceh121.jskolengo.entities.News;
import me.vinceh121.jskolengo.entities.NonTeachingStaff;
import me.vinceh121.jskolengo.entities.OtherPerson;
import me.vinceh121.jskolengo.entities.School;
import me.vinceh121.jskolengo.entities.SchoolInfoAuthor;
import me.vinceh121.jskolengo.entities.SchoolInfoFile;
import me.vinceh121.jskolengo.entities.SchoolInfoTechnicalUser;
import me.vinceh121.jskolengo.entities.SkoAppConfig;
import me.vinceh121.jskolengo.entities.Teacher;

public final class SkolengoConstants {
	public static final String BASE_URL = "https://api.skolengo.com/api/v1/bff-sko-app";
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
