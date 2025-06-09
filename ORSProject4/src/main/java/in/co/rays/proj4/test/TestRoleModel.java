package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.model.RoleModel;

public class TestRoleModel {

	public static void main(String[] args) throws Exception {
//		testAdd();
//	testDelete();
//		testUpdate();
//		testNextPk();
//		testFindByPK();
//		testfindByName();
		testSearch();
	}

	public static void testAdd() throws Exception {
		RoleBean bean = new RoleBean();
		RoleModel model = new RoleModel();

//		bean.setId(3);
		bean.setName("sonu");
		bean.setDescription("student");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);

	}

	public static void testDelete() throws Exception {
		RoleBean bean = new RoleBean();
		RoleModel model = new RoleModel();
		bean.setId(1);
		model.delete(bean);

	}

	public static void testUpdate() throws Exception {
		RoleBean bean = new RoleBean();
		RoleModel model = new RoleModel();

		bean.setId(2);
		bean.setName("akbar");
		bean.setDescription("akbar");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.update(bean);

	}

	private static void testNextPk() {

		RoleModel model = new RoleModel();

		int i = model.nextPk();

		System.out.println("nexPk is: " + i);

	}

	public static void testFindByPK() throws Exception {
		RoleBean bean = new RoleBean();
		RoleModel model = new RoleModel();
		bean = model.findbypk(2);

		if (bean != null) {
			System.out.println("  user pk valid");
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getDescription());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());
		} else {
			System.out.println("invalid pk");
		}

	}
	private static void testfindByName() throws Exception {

		RoleModel model = new RoleModel();

		RoleBean bean = model.findByName("akbar");

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("name not found");
		}
	}
	private static void testSearch() throws Exception {

		RoleModel model = new RoleModel();
		RoleBean bean = new RoleBean();
//		bean.setName("sonu");


		List list = model.search(bean);
		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (RoleBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}
	}


}
