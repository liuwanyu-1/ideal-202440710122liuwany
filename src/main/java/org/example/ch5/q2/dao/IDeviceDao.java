package org.example.ch5.q2.dao;

import org.example.ch5.q2.entity.Device;

import java.util.List;

public interface IDeviceDao {
    boolean add(Device device);

    boolean remove(String did);

    boolean modify(Device device);

    boolean scrap(Device device);

    Device getDeviceById(String did);

    List<Device> getAll(String... state);
}
