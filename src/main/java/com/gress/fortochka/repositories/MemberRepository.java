package com.gress.fortochka.repositories;

import com.gress.fortochka.model.Member;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Roman_Radetskiy.
 */
public interface MemberRepository extends CrudRepository<Member, Long> {
    Member findByLastName(String lastName);
}