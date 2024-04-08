package me.vinceh121.jskolengo;

import me.vinceh121.jskolengo.entities.Attachment;
import me.vinceh121.jskolengo.entities.School;
import me.vinceh121.jskolengo.entities.SkoAppConfig;
import me.vinceh121.jskolengo.entities.StudentUserInfo;
import me.vinceh121.jskolengo.entities.agenda.Agenda;
import me.vinceh121.jskolengo.entities.agenda.Audio;
import me.vinceh121.jskolengo.entities.agenda.CorrectedWork;
import me.vinceh121.jskolengo.entities.agenda.Homework;
import me.vinceh121.jskolengo.entities.agenda.Lesson;
import me.vinceh121.jskolengo.entities.agenda.LessonContent;
import me.vinceh121.jskolengo.entities.agenda.PedagogicContent;
import me.vinceh121.jskolengo.entities.agenda.Subject;
import me.vinceh121.jskolengo.entities.evaluation.Evaluation;
import me.vinceh121.jskolengo.entities.evaluation.EvaluationResult;
import me.vinceh121.jskolengo.entities.evaluation.EvaluationService;
import me.vinceh121.jskolengo.entities.evaluation.EvaluationsSetting;
import me.vinceh121.jskolengo.entities.evaluation.Period;
import me.vinceh121.jskolengo.entities.evaluation.SkillAcquisitionColors;
import me.vinceh121.jskolengo.entities.evaluation.SkillsSetting;
import me.vinceh121.jskolengo.entities.evaluation.SubSkill;
import me.vinceh121.jskolengo.entities.evaluation.SubSkillEvaluationResult;
import me.vinceh121.jskolengo.entities.info.Announcement;
import me.vinceh121.jskolengo.entities.info.News;
import me.vinceh121.jskolengo.entities.info.SchoolInfoAuthor;
import me.vinceh121.jskolengo.entities.info.SchoolInfoFile;
import me.vinceh121.jskolengo.entities.info.SchoolInfoTechnicalUser;
import me.vinceh121.jskolengo.entities.people.AbstractPerson;
import me.vinceh121.jskolengo.entities.people.NonTeachingStaff;
import me.vinceh121.jskolengo.entities.people.OtherPerson;
import me.vinceh121.jskolengo.entities.people.Student;
import me.vinceh121.jskolengo.entities.people.Teacher;

public final class SkolengoConstants {
	public static final String BASE_URL = "https://api.skolengo.com/api/v1/bff-sko-app",
			STAGING_BASE_URL = "https://api-recette.skolengo.com/api/v1/bff-sko-app",
			PROD_VIRT_HOST = "bff-prod-ha", // we can also get `bff` is this a problem?
			PROD_HOST = "api.skolengo.com",
			STAGING_HOST = "api-recette.skolengo.com",
			OIDC_CLIENT_ID = "SkoApp.Prod.0d349217-9a4e-41ec-9af9-df9e69e09494",
			OIDC_CLIENT_SECRET = "7cb4d9a8-2580-4041-9ae8-d5803869183f",
			OIDC_CALLBACK = "skoapp-prod://sign-in-callback";

	public static final Class<?>[] ENTITY_CLASSES = new Class<?>[] {
			Attachment.class,
			School.class,
			SkoAppConfig.class,
			StudentUserInfo.class,
			Agenda.class,
			Audio.class,
			CorrectedWork.class,
			Homework.class,
			Lesson.class,
			LessonContent.class,
			PedagogicContent.class,
			Subject.class,
			Evaluation.class,
			EvaluationResult.class,
			EvaluationService.class,
			EvaluationsSetting.class,
			Period.class,
			SkillAcquisitionColors.class,
			SkillsSetting.class,
			SubSkill.class,
			SubSkillEvaluationResult.class,
			Announcement.class,
			News.class,
			SchoolInfoAuthor.class,
			SchoolInfoFile.class,
			SchoolInfoTechnicalUser.class,
			AbstractPerson.class,
			NonTeachingStaff.class,
			OtherPerson.class,
			Student.class,
			Teacher.class, };
}
