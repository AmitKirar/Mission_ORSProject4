package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.MarksheetBean;
import in.co.rays.proj4.model.MarksheetModel;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {
// testAdd();
//		testDelete();
//		testUpdate();
//	 testNextPk();
//	testFindByPk();
//		testFindByRollNo();
		testSearch();

	}
	private static void testAdd() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();
//        bean.setId(1);
		bean.setRollNo("r5");
		bean.setStudentId(12);
		bean.setName("amit");
		bean.setPhysics(76);
		bean.setChemistry(85);
		bean.setMaths(71);
		bean.setStudentId(1L);																											
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);
	}
	private static void testDelete() throws Exception {
		MarksheetModel model = new MarksheetModel();
		model.delete(1);

	}
	private static void testUpdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();
		bean.setId(1);
		bean.setRollNo("r3");
		bean.setPhysics(96);
		bean.setChemistry(55);
		bean.setMaths(41);
		bean.setStudentId(3L);
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.update(bean);



}
	private static void testNextPk() {
		MarksheetModel model = new MarksheetModel();

		System.out.println("Next Pk: " + model.nextPk());

	}
	private static void testFindByPk() throws Exception {
		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = model.findByPk(2);

		if (bean != null) {
			System.out.print(bean.getId());

			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getStudentId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {
			System.out.println("record not found");
		}

	}
	private static void testFindByRollNo() throws Exception {
		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = model.findByRollNo("r5");

		if (bean != null) {
			System.out.print(bean.getId());

			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getStudentId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {
			System.out.println("student roll not found");
		}

	}
	private static void testSearch() throws Exception {
		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();
//       bean.setRollNo("r4");
    bean.setName("amit");
       
//       bean.setChemistry(85);
       
       
		

	  List	list = model.search(bean);
//		if (list.size() < 0) {
//			System.out.println("Test search fail");
//		}
		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (MarksheetBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}

	}
}
