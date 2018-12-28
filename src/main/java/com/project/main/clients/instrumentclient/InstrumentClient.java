package com.project.main.clients.instrumentclient;

import com.project.main.clients.AbstractClient;
import com.project.main.data.instrument.Instrument;
import java.util.List;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class InstrumentClient extends AbstractClient {

    private final static String BASE_INSTRUMENT_PATH = "instruments";

    public InstrumentClient() {
    }

    public Instrument getInstrument(Long id) {
//        Invocation.Builder inv = getTarget().path(BASE_INSTRUMENT_PATH + "/").queryParam("id", id).request(MediaType.APPLICATION_JSON);
        Invocation.Builder inv = getTarget().path(BASE_INSTRUMENT_PATH + "/" + id).request(MediaType.APPLICATION_JSON);
        Instrument ins = inv.get(Instrument.class);
        return ins;
    }

    public Instrument postInstrument(Instrument instrument) {

        Invocation.Builder inv = getTarget().path(BASE_INSTRUMENT_PATH + "/add").request(MediaType.APPLICATION_JSON);
        Instrument s;
        s = inv.post(Entity.entity(instrument, MediaType.APPLICATION_JSON), Instrument.class);
        return s;
    }

    public List<Instrument> getAllInstruments() {
        Invocation.Builder inv = getTarget().path(BASE_INSTRUMENT_PATH + "/all").request(MediaType.APPLICATION_JSON);
        List<Instrument> inst = inv.get(new GenericType<List<Instrument>>() {
        });
        return inst;
    }

    public Instrument updateInstrument(Instrument inst) {
        Invocation.Builder inv = getTarget().path(BASE_INSTRUMENT_PATH + "/update").request(MediaType.APPLICATION_JSON);
        Instrument updatedInst = inv.put(Entity.entity(inst, MediaType.APPLICATION_JSON), new GenericType<Instrument>() {
        });
        return updatedInst;
    }

    public Instrument deleteInstrument(Long id) {

        Invocation.Builder inv = getTarget().path(BASE_INSTRUMENT_PATH + "/delete/" + id).request(MediaType.APPLICATION_JSON);
        Instrument deletedInst = inv.delete(Instrument.class);
        return deletedInst;
    }

}
