package com.saber.start;

import com.saber.models.Instructor;
import com.saber.models.InstructorDetail;
import com.saber.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApp {
    public static void main(String[] args) {
       // addInstructorAndInstructorDetail();
       // Instructor instructor =findInstructorById(4);
       // System.out.println(instructor);
       // deleteInstructorDetail(1);
    }

    private static void deleteInstructorDetail(Integer id){
        Session session= HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        InstructorDetail instructorDetail=session.find(InstructorDetail.class,id);
        instructorDetail.getInstructor().setInstructorDetail(null);
        session.remove(instructorDetail);
        transaction.commit();

    }
    private static Instructor findInstructorById(Integer id){
        Session session= HibernateUtil.openSession();
        Instructor instructor=session.find(Instructor.class,id);
        session.close();
        return instructor;
    }
    private static void addInstructorAndInstructorDetail(){
        Session session= HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        Instructor instructor= new Instructor();
        instructor.setFirstName("saber66");
        instructor.setLastName("Azizi");
        instructor.setEmail("saber66@yahoo.com");

        InstructorDetail detail= new InstructorDetail();
        detail.setYoutubeChannel("saber66@youtube.com");
        detail.setHobby("Java Channel");


        instructor.setInstructorDetail(detail);


        session.save(instructor);
        transaction.commit();

        System.out.println("add to DataBase ...............");

        session.close();

    }
}