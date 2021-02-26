package com.budaev.orm.jpa.repository.order;

import com.budaev.orm.entity.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
