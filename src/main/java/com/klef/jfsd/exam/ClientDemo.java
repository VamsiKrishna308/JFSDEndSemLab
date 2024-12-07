package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class ClientDemo {
	public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            String hql = "UPDATE Department SET name = ?1, location = ?2 WHERE deptId = ?3";
            Query query = session.createQuery(hql);
            query.setParameter(1, "CSE");
            query.setParameter(2, "C Block");
            query.setParameter(3, 1); 

            int rowsAffected = query.executeUpdate();
            System.out.println("Rows updated: " + rowsAffected);

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
}
