package gr.aueb.cf;

import gr.aueb.cf.model.Course;
import gr.aueb.cf.model.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import java.util.List;
import java.util.Objects;

public class App 
{
    public static void main (String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school2PU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //select All Teachers
//        String sql = "SELECT t FROM Teacher t";
//        TypedQuery<Teacher> query = em.createQuery(sql, Teacher.class);
//        List<Teacher> teachers = query.getResultList();

//        //Select All courses
//        String sql2 = "SELECT c FROM Course c";
//        TypedQuery<Course> query2 = em.createQuery(sql2, Course.class);
//        List<Course> courses = query2.getResultList();

//        //Select courses from teacher
//        String sql3 = "SELECT c FROM Course c WHERE c.teachers.firstname = :firstname";
//        TypedQuery<Course> query = em.createQuery(sql3, Course.class);
//        query.setParameter("firstname", "Αθανάσιος");
//        List<Course> courses = query.getResultList();

//        //Select  courses & teacher
//        String sql2 = "SELECT t,c.title FROM Teacher t JOIN t.courses c";
//        TypedQuery<Object[]> query2 = em.createQuery(sql2, Object[].class);
//        List<Object[]> teacherCoursesTitels = query2.getResultList();

//        //Select  courses & teacher
//        String sql2 = "SELECT t FROM Teacher t JOIn t.courses c WHERE c.title = :courseTitle";
//        TypedQuery<Teacher> query2 = em.createQuery(sql2, Teacher.class);
//        query2.setParameter("courseTitle", "Java");
//        List<Teacher> teacherCoursesJava = query2.getResultList();

//        //Select teacher.firstname,lastname , count of courses they teach
//        String sql6 = "SELECT t.firstname, COUNT(c) FROM Teacher t JOIN t.courses c GROUP BY t.firstname";
//        TypedQuery<Object[]> query6 = em.createQuery(sql6, Object[].class);
//        List<Object[]> teacherCourseCount = query6.getResultList();
//
//        em.getTransaction().commit();

//        //Select teacher.firstname count>1 of courses they teach
//        String sql6 = "SELECT t.firstname, COUNT(c) FROM Teacher t JOIN t.courses c GROUP BY t.firstname HAVING COUNT(c) > 1";
//        TypedQuery<Object[]> query6 = em.createQuery(sql6, Object[].class);
//        List<Object[]> teacherCourseCount = query6.getResultList();

        //Select teacher courses order by lasname
//        String sql7 = "SELECT t, c FROM Teacher t JOIN t.courses c order by t.firstname ASC, c.title ASC";
//        TypedQuery<Object[]> query6 = em.createQuery(sql7, Object[].class);
//        List<Object[]> teacherCourseOrder = query6.getResultList();

        //me critiria builder
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<String> cq = cb.createQuery(String.class);
//        Root<Course> course = cq.from(Course.class);
//        cq.select(course.get("title"));
//        List<String> titles = em.createQuery(cq).getResultList();

        //me filtro sigecrimeno onoma
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Teacher> cq = cb.createQuery(Teacher.class);
//        Root<Teacher> teacherRoot = cq.from(Teacher.class);
//        ParameterExpression<String> lastnameParam = cb.parameter(String.class, "lastname");
//        cq.select(teacherRoot).where(cb.equal(teacherRoot.get("lastname"), lastnameParam));
//        List<Teacher> teachers = em.createQuery(cq).setParameter("lastname", "Ανδρούτσος").getResultList();


        //find courses by specific teacher
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
//        Root<Course> courseRoot = cq.from(Course.class);
//        Join<Course, Teacher> teacherJoin = courseRoot.join("teachers");
//
//        ParameterExpression<String> lastnameParam = cb.parameter(String.class, "lastname");
//        cq.select(courseRoot).where(cb.equal(teacherJoin.get("lastname"), lastnameParam));
//        List<Course> courses = em.createQuery(cq).setParameter("lastname", "Ανδρούτσος").getResultList();

        //teachers with more than one courses
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Teacher> query = cb.createQuery(Teacher.class);
//        Root<Teacher> teacherRoot = query.from(Teacher.class);
//        query.select(teacherRoot).where(cb.greaterThan(cb.size(teacherRoot.get("courses")),1));
//        List<Teacher> teachers = em.createQuery(query).getResultList();

        //List of courses and teachers
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
//        Root<Course> course = cq.from(Course.class);
//        Join<Course, Teacher> teacherJoin = course.join("teachers");
//        cq.multiselect(course.get("title"), teacherJoin.get("lastname"), teacherJoin.get("firstname"));
//        List<Object[]> listCoursesTeachers = em.createQuery(cq).getResultList();

        // 6 List of teachers who dont have courses
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Teacher> query = cb.createQuery(Teacher.class);
//        Root<Teacher> teacherRoot = query.from(Teacher.class);
//        query.select(teacherRoot).where(cb.isEmpty(teacherRoot.get("courses")));
//        List<Teacher> teachers = em.createQuery(query).getResultList();


        //7 List teachers with course count
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
//        Root<Teacher> teacherRoot = query.from(Teacher.class);
//        Join<Teacher, Course> courseJoin = teacherRoot.join("courses", JoinType.LEFT);
//        query.multiselect(teacherRoot, cb.count(courseJoin)).groupBy(teacherRoot);
//        List<Object[]> list = em.createQuery(query).getResultList();

//        8 //find teachers with SQL
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Teacher> query = cb.createQuery(Teacher.class);
//        Root<Teacher> courseRoot = query.from(Teacher.class);
//        ParameterExpression<String> courseParam = cb.parameter(String.class, "courseName");
//        query.select(courseRoot).where(cb.equal(courseRoot.get("courses").get("title"), courseParam));
//        List<Teacher> coursesSQL = em.createQuery(query).setParameter("courseName", "SQL").getResultList();

   //9     //Find teachers with firstaname and more than one query
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Teacher> query = cb.createQuery(Teacher.class);
        Root<Teacher> teacherRoot = query.from(Teacher.class);
        ParameterExpression<String> val = cb.parameter(String.class, "lastname");
        query.select(teacherRoot).where(cb.like(teacherRoot.get("lastname"), val), cb.gt(cb.size(teacherRoot.get("courses")), 1));
        List<Teacher> teachersLastname = em.createQuery(query).setParameter("lastname", "Α%").getResultList();



        em.getTransaction().commit();


        teachersLastname.forEach(System.out::println);

       //8 coursesSQL.forEach(System.out::println);


//  7      for(Object[] row:list){
//            for(Object item: row){
//                System.out.println(item + " ");
//            }
//            System.out.println();
//        }


            //6  teachers.forEach(System.out::println);

//   5     for(Object[] row:listCoursesTeachers){
//            for(Object item: row){
//                System.out.println(item + " ");
//            }
//            System.out.println();
//        }



     //4   teachers.forEach(System.out::println);

       // 3 courses.forEach(System.out::println);

//   2     teachers.forEach(System.out::println);

       //1  titles.forEach(System.out::println);

//                for(Object[] row:teacherCourseOrder){
//            for(Object item: row){
//                System.out.println(item + " ");
//            }
//            System.out.println();
//        }

//        for(Object[] row:teacherCourseCount){
//            for(Object item: row){
//                System.out.println(item + " ");
//            }
//            System.out.println();
//        }

//        for(Object[] row: teacherCoursesTitels){
//            for(Object item: row){
//                System.out.println(item + " ");
//            }
//            System.out.println();
//        }
        //teacherCoursesJava.forEach(System.out::println);

      //  courses.forEach(System.out::println);

//        teachers.forEach(System.out::println);

        em.close();
        emf.close();
    }
}
