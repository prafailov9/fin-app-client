package com.project.main.io.csv;

import java.util.List;

/**
 *
 * @author prafailov
 */
public interface DataParser<T> {

    T parseData();

    List<T> parseAllData();
}
