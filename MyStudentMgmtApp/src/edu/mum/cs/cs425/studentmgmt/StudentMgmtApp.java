package edu.mum.cs.cs425.studentmgmt;

import java.util.Calendar;
import java.util.Date;

import edu.mum.cs.cs425.studentmgmt.model.Student;

public class StudentMgmtApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = new Student(1,"000-61-0001", "Anna", "Lynn", "Smith",3.45, new Date(2019,5,24));
		saveStudent(student);

		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyStudentMgmtApp");
	        EntityManager em = emf.createEntityManager();

	        Student student = createSampleStudent();

	        EntityTransaction transaction = em.getTransaction();
	        transaction.begin();

	        em.persist(student);

	        transaction.commit();

	        em.close();
	        emf.close();
	}
	public static Student  saveStudent(Student std){
		Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, Calendar.MAY);
        calendar.set(Calendar.DAY_OF_MONTH, 24);
        Student student = new Student("000-61-0001",
                "Anna", "Lynn",
                "Smith",3.45, calendar.getTime()
        );

        Transcript transcript = new Transcript();
        transcript.setDegreeTitle("BS Computer Science");

        Classroom classroom = new Classroom();
        classroom.setBuildingName("McLaughlin building");
        classroom.setRoomNumber("M105");

        student.setTranscript(transcript);
        student.setClassroom(classroom);

        return student;
	}

}
