package org.qmacias.project.shared.application;

import java.util.List;

public interface GenericService<T> {

    List<T> all();

    T get(final Long id);

    T add(final T t);

    void remove(final Long id);

}
