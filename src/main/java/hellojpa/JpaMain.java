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

            //영속
            //Member member1 = new Member(150L, "A");
            //Member member2 = new Member(160L, "B");

            //변경 감지: jpa는 값을 바꾸면 트랜잭션이 커밋되는 시점에 변경을 반영한다.
            Member member = new Member(200L, "member200");
            em.persist(member);

            //영속성 컨텍스트를 비우지 않고, 변경 내용을 데이터베이스에 동기화
            em.flush();

            System.out.println("=====================");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
