package com.itmuch.cloud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/1/10.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
