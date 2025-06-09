package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.CourseBean;
import in.co.rays.proj4.model.CourseModel;

public class TestCourseModel {

	public static void main(String[] args) throws Exception {
//		testAdd();
//testDelete();
//		testUpdate();
//testNextPk();
//		testFindByPK();
//		testFindByName();
		testSearch();
	}

	public static void testAdd() throws Exception {
		CourseBean bean = new CourseBean();
		CourseModel model = new CourseModel();
//		bean.setId(2);
		bean.setName("komal");
		bean.setDuration("200");
		bean.setDescription("komal");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.add(bean);
	}

	public static void testDelete() throws Exception {
		CourseBean bean = new CourseBean();
		CourseModel model = new CourseModel();
		bean.setId(1);
		model.delete(bean);
	}

	public static void testUpdate() throws Exception {
		CourseBean bean = new CourseBean();
		CourseModel model = new CourseModel();
		bean.setId(2);
		bean.setName("divyanshu");
		bean.setDuration("200");
		bean.setDescription("divyanshu");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.update(bean);
	}

	public static void testNextPk() {
		CourseModel model = new CourseModel();
		int i = model.nextpk();
		System.out.println("nexPk is: " + i);

	}

	public static void testFindByPK() throws Exception {
		CourseBean bean = new CourseBean();
		CourseModel model = new CourseModel();
		bean = model.findbypk(2);
		if (bean != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getDuration());
			System.out.println(bean.getDescription());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());
		}

	}
	private static void testFindByName() throws Exception {
		CourseModel model = new CourseModel();
		CourseBean bean = model.findByName("komal");

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t"+bean.getName());
			System.out.print("\t" + bean.getDuration());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {
			System.out.println("course not found");
		}

}
	private static void testSearch() throws Exception {
		CourseBean bean = new CourseBean();
		CourseModel model = new CourseModel();
		bean.setName("komal");

		List list = model.search(bean);
		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (CourseBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t"+bean.getName());
			System.out.print("\t" + bean.getDuration());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}

	}

}