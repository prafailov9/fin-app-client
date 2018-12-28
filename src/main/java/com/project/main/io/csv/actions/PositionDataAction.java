/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.main.io.csv.actions;

import com.project.main.data.position.Position;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author prafailov
 */
public class PositionDataAction extends DataAction<Position> {

    public PositionDataAction(String filePath, Reader reader, CSVParser parser, List<CSVRecord> records) {
        super(filePath, reader, parser, records);
    }

    @Override
    public Position parseLine() {
        Position position = new Position();
        List<CSVRecord> records = getRecords();
//        "startDate", "payer", "receiver", "principal"
        for (CSVRecord record : records) {
            position = getSingleRecord(record);
        }
        return position;
    }

    @Override
    public List<Position> parseAll() {
        List<Position> pos = new ArrayList<>();
        List<CSVRecord> records = getRecords();

        for (CSVRecord record : records) {
            pos.add(getSingleRecord(record));
        }
        return pos;
    }

    private Position getSingleRecord(final CSVRecord record) {
        Position position = new Position();
        position.setPayer(record.get("payer"));
        position.setReceiver(record.get("receiver"));
        position.setStartingDateOfDeal(LocalDateTime.parse(record.get("startDate"), getDTF()));
        position.setPrincipal(Double.parseDouble(record.get("principal")));
        position.setPositionVolume(Double.parseDouble(record.get("positionVolume")));

        return position;
    }

}
