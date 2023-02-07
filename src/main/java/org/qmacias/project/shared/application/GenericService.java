package org.qmacias.project.shared.application;

import java.util.List;

public interface GenericService<T, ID> {

    List<T> all();

    T get(final ID id);

    T add(final T t);

    void remove(final ID id);

}
