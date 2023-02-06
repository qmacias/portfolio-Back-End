package org.qmacias.project.shared.application;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(
        propagation = Propagation.REQUIRED,
        isolation = Isolation.SERIALIZABLE
)
public interface GenericService<T> {

    List<T> all();

    T get(final Long id);

    T add(final T t);

    void remove(final Long id);

}
