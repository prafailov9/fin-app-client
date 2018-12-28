/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.main.clients.positionclient;

import com.project.main.clients.AbstractClient;
import com.project.main.data.position.Position;
import java.util.List;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author user
 */
public class PositionClient extends AbstractClient {

    private final static String BASE_POSITION_PATH = "positions";

    public Position getPosition(Long id) {
        Invocation.Builder inv = getTarget().path(BASE_POSITION_PATH + "/" + id).request(MediaType.APPLICATION_JSON);

        Position pos = inv.get(Position.class);
        return pos;
    }

    public List<Position> getAllPositions() {
        Invocation.Builder inv = getTarget().path(BASE_POSITION_PATH + "/all").request(MediaType.APPLICATION_JSON);
        List<Position> list = inv.get(new GenericType<List<Position>>() {
        });
        return list;
    }

    public Position postPosition(Position pos) {
        Invocation.Builder inv = getTarget().path(BASE_POSITION_PATH + "/add").request(MediaType.APPLICATION_JSON);
        Position receivedPos = inv.post(Entity.entity(pos, MediaType.APPLICATION_JSON), Position.class);
        return receivedPos;

    }

    public Position deletePosition(Long id) {
        Invocation.Builder inv = getTarget().path(BASE_POSITION_PATH + "/delete/" + id).request(MediaType.APPLICATION_JSON);
        Position deletedPos = inv.delete(Position.class);
        return deletedPos;
    }

    public Position updatePosition(Position pos) {
        Invocation.Builder inv = getTarget().path(BASE_POSITION_PATH + "/update").request(MediaType.APPLICATION_JSON);
        Position updatedPos = inv.put(Entity.entity(pos, MediaType.APPLICATION_JSON), new GenericType<Position>() {
        });
        return updatedPos;
    }

}
