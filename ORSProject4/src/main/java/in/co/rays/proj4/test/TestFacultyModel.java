package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.FacultyBean;
import in.co.rays.proj4.model.FacultyModel;
import in.co.rays.proj4.model.RoleModel;

public class TestFacultyModel {

	public static void main(String[] args) throws Exception {
//		testAdd();
//		testDelete();
//		testUpdate();
//		testNextPk();
//	testFindByPK();
//		testFindByEmail();
		testSearch();
	}

	public static void testAdd() throws Exception {
		FacultyBean bean = new FacultyBean();
		FacultyModel model = new FacultyModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		bean.setId(2);
		bean.setFirstName("kiran");
		bean.setLastName("rajpoot");
		bean.setDob(sdf.parse("2005-01-23"));
		bean.setGender("female");
		bean.setMobileNo("9179016753");
		bean.setEmailId("kiran@gmail.com");
		bean.setCollegeId(11);
		bean.setCollegeName("vrg");
		bean.setCourseId(12);
		bean.setCourseName("phythan corporate");
		bean.setSubjectId(1);
		bean.setSubjectName("maths");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);

	}

	public static void testDelete() throws Exception {
		FacultyBean bean = new FacultyBean();
		FacultyModel model = new FacultyModel();
		bean.setId(2);
		model.delete(bean);
	}

	public static void testUpdate() throws Exception {
		FacultyBean bean = new FacultyBean();
		FacultyModel model = new FacultyModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setFirstName("amit");
		bean.setLastName("kirar");
		bean.setDob(sdf.parse("2001-01-03"));
		bean.setGender("male");
		bean.setMobileNo("8120891470");
		bean.setEmailId("lucky@gmail.com");
		bean.setCollegeId(11);
		bean.setCollegeName("jiwaji");
		bean.setCourseId(12);
		bean.setCourseName("java corporate");
		bean.setSubjectId(1);
		bean.setSubjectName("maths");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		bean.setId(1);

		model.Update(bean);
	}

	private static void testNextPk() {

		RoleModel model = new RoleModel();

		int i = model.nextPk();

		System.out.println("nexPk is: " + i);
	}

	public static void testFindByPK() throws Exception {
		FacultyBean bean = new FacultyBean();
		FacultyModel model = new FacultyModel();
		bean = model.findbypk(1);
		if (bean != null) {
			
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getDob());
			System.out.println(bean.getGender());
			System.out.println(bean.getMobileNo());
			System.out.println(bean.getEmailId());
			System.out.println(bean.getCollegeId());
			System.out.println(bean.getCollegeName());
			System.out.println(bean.getCourseId());
			System.out.println(bean.getCourseName());
			System.out.println(bean.getSubjectId());
			System.out.println(bean.getSubjectName());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());
			
		}else { 
			System.out.println("invalid pk");
		}
	}
	private static void testFindByEmail() throws Exception {
		FacultyModel model = new FacultyModel();

		FacultyBean bean = model.findByEmail("kiran@gmail.com");

		if (bean != null) {

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getEmailId());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {
			System.out.println("login id not found");
		}

	}
	private static void testSearch() throws Exception {
		FacultyBean bean = new FacultyBean();
		FacultyModel model = new FacultyModel();
		bean.setMobileNo("8120891470");

		List list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (FacultyBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getEmailId());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}

	}


}