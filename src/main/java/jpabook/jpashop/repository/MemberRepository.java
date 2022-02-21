package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository
{
    @PersistenceContext
    private EntityManager em;

    public void save(Member member)
    {
        em.persist(member);
    }

    public Member findOne(Long id)
    {
        return em.find(Member.class, id);
    }

    public List<Member> findAll()
    {
        //기능적으로 동일하지만 sql은 테이블대상 얘는 엔티티대상(객체 대상)
        // 멤버를 조회 하라는 문법
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public List<Member> findByName(String name)
    {
        return em.createQuery("select m from Member m where m.name = :name", Member.class).setParameter("name",name).getResultList();
    }
}
