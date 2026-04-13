package jpabook.jpashop;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setName("JPA");

            em.persist(member);
            em.flush();
            em.clear();

            OrderItem find = em.find(OrderItem.class, 1L);

            OrderItem find2 = em.find(OrderItem.class, 1L);



            tx.commit();
        } catch (Exception e) {
            System.out.println("롤백");
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
