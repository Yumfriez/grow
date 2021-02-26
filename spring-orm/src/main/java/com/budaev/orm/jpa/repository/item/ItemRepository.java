package com.budaev.orm.jpa.repository.item;

import com.budaev.orm.entity.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public interface ItemRepository extends JpaRepository<Item, Long>, ItemRepositoryCustom {

}
