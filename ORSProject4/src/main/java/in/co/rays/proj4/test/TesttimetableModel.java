package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.TimetableBean;
import in.co.rays.proj4.model.TimetableModel;

public class TesttimetableModel {

	public static void main(String[] args) throws Exception {
//		testAdd();
//	testDelete();
//		testUpdate();
//		Nextpk();
//		testFindByPK();
		testSearch();
	}

	public static void testAdd() throws Exception {
		TimetableBean bean = new TimetableBean();
		TimetableModel model = new TimetableModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

//		bean.setId(1);
		bean.setSemester("third");
		bean.setDescription("komal");
		bean.setExamDate(sdf.parse("2025-08-09"));
		bean.setExamTime("9 to 12");
		bean.setCourseId(11);
		bean.setCourseName("core java");
		bean.setSubjectId(11);
		bean.setSubjectName("evs");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);
	}

	public static void testDelete() throws Exception {
		TimetableBean bean = new TimetableBean();
		TimetableModel model = new TimetableModel();
		bean.setId(7);
		model.delete(bean);
	}

	public static void testUpdate() throws Exception {
		TimetableBean bean = new TimetableBean();
		TimetableModel model = new TimetableModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setSemester("second");
		bean.setDescription("amit");
		bean.setExamDate(sdf.parse("2025-08-09"));
		bean.setExamTime("10 to 12");
		bean.setCourseId(11);
		bean.setCourseName("advance java");
		bean.setSubjectId(11);
		bean.setSubjectName("evs");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		bean.setId(1);

		model.update(bean);

	}

	public static void Nextpk() {

		TimetableModel model = new TimetableModel();
		int i = model.nextPk();

		System.out.println("nexPk is: " + i);
	}

	public static void testFindByPK() throws Exception {
		TimetableBean bean = new TimetableBean();
		TimetableModel model = new TimetableModel();
		bean= model.findbypk(1);
		if(bean!=null) { 
			System.out.print("\t"+bean.getId());
			System.out.print("\t"+bean.getSemester());
			System.out.print("\t"+bean.getDescription());
			System.out.print("\t"+bean.getExamDate());
			System.out.print("\t"+bean.getExamTime());
			System.out.print("\t"+bean.getCourseId());
			System.out.print("\t"+bean.getCourseName());
			System.out.print("\t"+bean.getSubjectId());
			System.out.print("\t"+bean.getSubjectName());
			System.out.print("\t"+bean.getCreatedBy());
			System.out.print("\t"+bean.getModifiedBy());
			System.out.print("\t"+bean.getCreatedDatetime());
			System.out.print("\t"+bean.getModifiedDatetime());
			
			
		}else { 
			System.out.println("invalid record ");
		}
		
		
		
	}
	public static void testSearch() throws Exception { 
		TimetableBean bean = new TimetableBean();
		TimetableModel model = new TimetableModel();
//		bean.setSemester("third");
//		bean.setDescription("amit");
		
		List list=model.search(bean);
		Iterator it= list.iterator();
		
		
		while(it.hasNext()) { 
			bean=(TimetableBean)it.next();
			
			System.out.print("\t"+bean.getId());
			System.out.print("\t"+bean.getSemester());
			System.out.print("\t"+bean.getDescription());
			System.out.print("\t"+bean.getExamDate());
			System.out.print("\t"+bean.getExamTime());
			System.out.print("\t"+bean.getCourseId());
			System.out.print("\t"+bean.getCourseName());
			System.out.print("\t"+bean.getSubjectId());
			System.out.print("\t"+bean.getSubjectName());
			System.out.print("\t"+bean.getCreatedBy());
			System.out.print("\t"+bean.getModifiedBy());
			System.out.print("\t"+bean.getCreatedDatetime());
			System.out.print("\t"+bean.getModifiedDatetime());
			
			
		}
	}

}
