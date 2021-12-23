package com.aliozdemir.springsecurity0.repository;

import com.aliozdemir.springsecurity0.entity.DigitalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<DigitalUser,Long> {

    DigitalUser findByIdentityNo(String identityNo);
}
