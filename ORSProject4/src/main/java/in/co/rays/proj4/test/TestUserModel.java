package in.co.rays.proj4.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.model.UserModel;
import in.co.rays.proj4.util.JDBCDataSource;

public class TestUserModel {

	public static void main(String[] args) throws Exception {
//	testAdd();
//		testDelete();
//		testUpdate();
//	testNextPk();
//		testfindByPk();
//		testFindByLogin();
//		testFindByAuthenticate();
		testSearch();
		
	}

	public static void testAdd() throws Exception {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

//		bean.setId(1);
		bean.setFirstName("lucky");
		bean.setLastName("rajpoot");
		bean.setLogin("lucky@gamil.com");
		bean.setPassword("12345");
		bean.setDob(sdf.parse("2002-01-03"));
		bean.setMobileNo("8120891470");
		bean.setRoleId(11);
		bean.setGender("male");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.testadd(bean);
	}

	private static void testDelete() throws Exception {
		UserModel model = new UserModel();
		model.delete(1);
	}

	private static void testUpdate() throws Exception {
		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setId(1);
		bean.setFirstName("Nitin");
		bean.setLastName("Patidar");
		bean.setLogin("nitin@gmail.com");
		bean.setPassword("1234asdf");
		bean.setDob(sdf.parse("2005-12-15"));
		bean.setMobileNo("9755058601");
		bean.setRoleId(2l);
		bean.setGender("male");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		UserModel model = new UserModel();
		model.update(bean);

	}

	private static void testNextPk() {
		UserModel model = new UserModel();
		System.out.println("Next Pk: " + model.nextPk());
	}
	private static void testfindByPk() throws Exception {
		UserModel model = new UserModel();

		UserBean bean = model.findByPk(1);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t"+bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getRoleId());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {
			System.out.println("record not found");
		}

	}
	private static void testFindByLogin() throws Exception {
		UserModel model = new UserModel();

		UserBean bean = model.findByLogin("lucky@gamil.com");

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.print(bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getRoleId());
			System.out.println("\t" + bean.getGender());
			System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {
			System.out.println("login id not found");
		}

	}
	private static void testFindByAuthenticate() throws Exception {
		UserModel model = new UserModel();

		UserBean bean = model.findByAuthenticate("nitin@gmail.com", "1234asdf");

		if (bean != null) {
			System.out.println(bean.getId());
			System.out.print(bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getRoleId());
			System.out.println("\t" + bean.getGender());
			System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {
			System.out.println("loginid pr password is invalid");
		}

	}
	private static void testSearch() throws Exception {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
      bean.setFirstName("lucky");

		List list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (UserBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getRoleId());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}

	}

	


}
