package com.budaev.orm.jpa.repository.user;

import com.budaev.orm.entity.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
}
