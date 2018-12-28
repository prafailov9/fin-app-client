package com.project.main.io.printers;

import java.util.List;

/**
 *
 * @author prafailov
 */
public interface DataPrinter {

    boolean print(String data);

    boolean printAll(List<String> contents);

}
