package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.StudentBean;
import in.co.rays.proj4.model.RoleModel;
import in.co.rays.proj4.model.StudentModel;

public class TestStudentModel {

	public static void main(String[] args) throws Exception {
//	testAdd();
//		testDelete();
//		testUpdate();
//		 testNextPk();
//		testFindByPk();
//		testFindByEmail();
		testSearch();
		}

	public static void testAdd() throws Exception {
		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		bean.setId(1);
		bean.setFirstName("komal");
		bean.setLastName("rajpoot");
		bean.setDob(sdf.parse("2005-02-09"));
		bean.setGender("female");
		bean.setMobileNo("9303028129");
		bean.setEmailId("komal@gmail.com");
		bean.setCollegeId(12);
		bean.setCollegeName("VRG");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));


	model.add(bean);
	}
	private static void testDelete() throws Exception {
		StudentModel model = new StudentModel();
		model.delete(1);
		
	}
	private static void testUpdate() throws Exception {
		StudentModel model = new StudentModel();
		StudentBean bean = new StudentBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		bean.setId(1);
		bean.setFirstName("Amit");
		bean.setLastName("Kirar");
		bean.setDob(sdf.parse("2002-02-15"));
		bean.setGender("Male");
		bean.setMobileNo("8120891470");
		bean.setEmailId("amit@gmail.com");
		bean.setCollegeId(4);
		bean.setCollegeName("jiwaji");
		bean.setCreatedBy("root");
		bean.setModifiedBy("Chetan");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.update(bean);
		

	}
	private static void testNextPk() {

		StudentModel model = new StudentModel();

		int i = model.nextPk();

		System.out.println("nexPk is: " + i);

}
	private static void testFindByPk() throws Exception {
		StudentModel model = new StudentModel();
		StudentBean bean =new StudentBean();
		 bean=model.findByPk(1);
		
		if (bean != null) {
			
		    System.out.println("valid pk");
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmailId());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {
			System.out.println("invalid pk");
		}
	}
	private static void testFindByEmail() throws Exception {
		StudentModel model = new StudentModel();
		StudentBean bean = model.findByEmail("amit@gmail.com");
		
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmailId());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {
			System.out.println("Student email not found");
		}
		
	}
	private static void testSearch() throws Exception {
		StudentModel model = new StudentModel();
		StudentBean bean = new StudentBean();
		bean.setFirstName("komal");

		List list = model.search(bean);
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			bean =(StudentBean) it.next();
			
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmailId());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}
		
	}
}