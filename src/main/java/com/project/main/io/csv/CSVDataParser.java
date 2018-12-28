package com.project.main.io.csv;

import com.project.main.io.csv.actions.DataAction;
import java.util.List;

/**
 *
 * @author prafailov
 * @param <T>
 */
public class CSVDataParser<T> implements DataParser<T> {

    private DataAction<T> dataAction;

    public CSVDataParser(DataAction dataAction) {
        this.dataAction = dataAction;
    }

    public void setDataAction(DataAction dataAction) {
        this.dataAction = dataAction;
    }

    @Override
    public T parseData() {
        return dataAction.parseLine();
    }

    @Override
    public List<T> parseAllData() {
        return dataAction.parseAll();
    }

}
