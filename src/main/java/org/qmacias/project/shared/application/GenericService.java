package org.qmacias.project.shared.application;

import java.util.List;

public interface GenericService<T, K> {

    List<T> all();

    T get(final K id);

    T add(final T t);

    void remove(final K id);

}
