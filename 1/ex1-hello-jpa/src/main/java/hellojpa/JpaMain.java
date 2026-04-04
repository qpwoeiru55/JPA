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
              //비영속
            Member member = new Member();
            member.setUsername("JIN1");
            member.setRoleType(RoleType.ADMIN);

            Member member2 = new Member();
            member2.setUsername("JIN2");
            member2.setRoleType(RoleType.ADMIN);

            Member member3 = new Member();
            member3.setUsername("JIN3");
            member3.setRoleType(RoleType.ADMIN);

            Member member4 = new Member();
            member4.setUsername("JIN4");
            member4.setRoleType(RoleType.ADMIN);
              //영속
            System.out.println("====================");
            em.persist(member);
            em.persist(member2);
            em.persist(member3);
            em.persist(member4);
            System.out.println("====================");

/*            Member findMember = em.find(Member.class, 1L);
            findMember.setUsername("수정4JIN");
            em.flush();
            em.detach(findMember);
            em.clear();*/


            /*
            List<Member> resultList = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();
            for(Member member : resultList){
                System.out.println(member.getName());
           }*/

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
