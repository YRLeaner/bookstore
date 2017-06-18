package test;

import entity.Students;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.common.util.impl.Log;
import org.hibernate.cfg.Configuration;
import org.hibernate.persister.entity.Loadable;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import java.util.Date;


/**
 * Created by tyr on 2017/5/27.
 */
public class TestStudents {

    @Test
    public void testSchemaExport(){
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.getCurrentSession();

        SchemaExport export = new SchemaExport(configuration);
        export.create(true,true);
        // System.out.print("hhhhhhhhhh");

    }
    @Test
    public void testSaveStudents(){
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Students s1 = new Students("S0000001","张1","男",new Date(),"武汉","123456");
        Students s2 = new Students("S0000002","张2","男",new Date(),"长沙","123456");
        Students s3 = new Students("S0000003","张3","男",new Date(),"北京","234567");

        session.save(s1);
        session.save(s2);
        session.save(s3);

        tx.commit();
        sessionFactory.close();

    }
}
