package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//          Member findMember = em.find(Member.class, 1L);
//          System.out.println("findMember.id = " + findMember.getId());
//          System.out.println("findMember.name = " + findMember.getName());
//          List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");

            //영속
            System.out.println("=== BEFORE ===");
            em.persist(member); //db에 저장되지 않은 상태
            //em.detach(member); //영속성 컨텍스트에서 분리
            System.out.println("=== AFTER ===");


            Member findMember1 = em.find(Member.class, 101L);
            Member findMember2 = em.find(Member.class, 101L);

            //동일성 보장
            System.out.println("findMember1 == findMember2: " + (findMember1 == findMember2));

            //select 쿼리가 나가지 않음, 1차 캐시에서 조회
            //System.out.println(findMember.getId());
            //System.out.println(findMember.getName());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
