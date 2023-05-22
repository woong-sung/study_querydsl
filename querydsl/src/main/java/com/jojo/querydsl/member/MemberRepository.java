package com.jojo.querydsl.member;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("select distinct m from Member m left join fetch m.reviews")
    List<Member> findAllJPQLFetch();

    @EntityGraph(attributePaths = {"reviews"}, type = EntityGraph.EntityGraphType.FETCH)
    @Query("select distinct m from Member m left join m.reviews")
    List<Member> findAllJPQLFetch2();

}
