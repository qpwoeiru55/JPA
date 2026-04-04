package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
/*              //비영속
            Member member = new Member();
            member.setId(4L);
            member.setName("JIN4");
              //영속
            em.persist(member);

            Member member1 = em.find(Member.class, 4L);
            System.out.println("member1 = " + member1);*/


            Member findMember = em.find(Member.class, 1L);
            findMember.setName("수정2JIN1");

/*            List<Member> resultList = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();
            for(Member member : resultList){
                System.out.println(member.getName());
           }*/

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
