package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Date;

import in.co.rays.proj4.bean.StudentBean;
import in.co.rays.proj4.bean.SubjectBean;
import in.co.rays.proj4.model.StudentModel;
import in.co.rays.proj4.model.SubjectModel;

public class TestSubjectModel {

	public static void main(String[] args) throws Exception {
//	 testAdd();
//		 testDelete();
//	 testUpdate();
//		testNextPk();
//		testFindByPk();
		
	}
	private static void testAdd() throws Exception {
		SubjectModel model = new SubjectModel();
		SubjectBean bean = new SubjectBean();
//        bean.setId(1);
		bean.setSubjectName("SST");
		bean.setCourseId(3l);
		bean.setCourseName("computer science");
		bean.setDescription("Maths");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);
	}
	private static void testDelete() throws Exception {
		SubjectModel model = new SubjectModel();
		model.delete(2);
	}
	private static void testUpdate() throws Exception {
		SubjectModel model = new SubjectModel();
		SubjectBean bean = new SubjectBean();

		
		bean.setSubjectName("EVS");
		bean.setCourseId(4l);
		bean.setDescription("database");
		bean.setCreatedBy("root");
		bean.setModifiedBy("chetan");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		bean.setId(1);
		model.update(bean);
	}
	private static void testNextPk() {
		SubjectModel model = new SubjectModel();

		System.out.println("Next Pk: " + model.nextPk());

	}
	private static void testFindByPk() throws Exception {
		SubjectModel model = new SubjectModel();
		SubjectBean bean = model.findByPk(2);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {
			System.out.println("record not found");
		}
	}
}