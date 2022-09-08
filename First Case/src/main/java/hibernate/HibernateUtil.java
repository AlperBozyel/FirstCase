package hibernate;

import com.example.first_case.model.product;
import com.example.first_case.model.productComment;
import com.example.first_case.model.user;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static final SessionFactory buildSessionFactory() {

        try{
            Configuration cfg = new Configuration();
            cfg.addAnnotatedClass(user.class);
            cfg.addAnnotatedClass(product.class);
            cfg.addAnnotatedClass(productComment.class);

            SessionFactory sessionFactory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();

            return sessionFactory;

        } catch (Exception e){
            System.out.println("Session Factory couldn't build correctly!");
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
