package in.co.rays.proj4.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.model.CollegeModel;
import in.co.rays.proj4.util.JDBCDataSource;

public class TestCollegeModel {

	public static void main(String[] args) throws Exception {
//		testAdd();
//		testDelete();
//		testUpdate();
//		testNextPk() ;
//		testFindByPk();
//		testFindByName();
		testSearch();
	}

	public static void testAdd() throws Exception {
		CollegeBean bean = new CollegeBean();
		CollegeModel model = new CollegeModel();
//		bean.setId(1);
		bean.setName("AMIT");
		bean.setAddress("Trichy");
		bean.setState("TamilNadu");
		bean.setCity("Tiruchirappali");
		bean.setPhoneNo("777898989");
		bean.setCreatedBy("Admin");
		bean.setModifiedBy("Admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);
	}

	public static void testDelete() throws Exception {

		CollegeModel model = new CollegeModel();
		model.delete(1);

	}

	public static void testUpdate() {

		try {
			CollegeBean bean = new CollegeBean();
			CollegeModel model = new CollegeModel();
			bean.setName("LUCKY");
			bean.setAddress("Mandsaur");
			bean.setState("TamilNadu");
			bean.setCity("Tiruchirappali");
			bean.setPhoneNo("777898989");
			bean.setModifiedBy("Manager");
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			bean.setId(1);

			model.update(bean);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void testNextPk() {
		CollegeModel model = new CollegeModel();

		int i = model.nextPk();

		System.out.println("Next Pk : " + i);
	}
	private static void testFindByPk() throws Exception {
		CollegeModel model = new CollegeModel();

		CollegeBean bean = model.findByPk(2);

		if (bean != null) {

			System.out.print(bean.getName());
			System.out.print("\t" + bean.getAddress());
			System.out.print("\t" + bean.getState());
			System.out.print("\t" + bean.getCity());
			System.out.print("\t" + bean.getPhoneNo());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("record not found");
		}

	}
	private static void testFindByName() throws Exception {
		CollegeModel model = new CollegeModel();

		CollegeBean bean = model.findByName("LUCKY");

		if (bean != null) {

			System.out.print(bean.getName());
			System.out.print("\t" + bean.getAddress());
			System.out.print("\t" + bean.getState());
			System.out.print("\t" + bean.getCity());
			System.out.print("\t" + bean.getPhoneNo());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("name not found");
		}

	}
	private static void testSearch() throws Exception {
		CollegeModel model = new CollegeModel();
		CollegeBean bean = new CollegeBean();
		bean.setName("AMIT");

		List list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (CollegeBean)it.next();

			System.out.print(bean.getName());
			System.out.print("\t" + bean.getAddress());
			System.out.print("\t" + bean.getState());
			System.out.print("\t" + bean.getCity());
			System.out.print("\t" + bean.getPhoneNo());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}
	}
	
}
