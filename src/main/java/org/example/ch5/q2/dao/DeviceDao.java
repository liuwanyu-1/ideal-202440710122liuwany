package org.example.ch5.q2.dao;

import org.example.ch5.q2.entity.Device;
import org.example.ch5.q2.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeviceDao implements IDeviceDao {
    @Override
    public boolean add(Device device) {
        String sql = "insert into device(did,dname,price,buy_date,use_user,state) values(?,?,?,?,?,?)";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, device.getDid());
            ps.setString(2, device.getDname());
            ps.setDouble(3, device.getPrice());
            ps.setString(4, device.getBuyDate());
            ps.setString(5, device.getUseUser());
            ps.setString(6, device.getState());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(String did) {
        String sql = "delete from device where did=?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, did);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modify(Device device) {
        String sql = "update device set dname=?,price=?,buy_date=?,use_user=?,state=? where did=?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, device.getDname());
            ps.setDouble(2, device.getPrice());
            ps.setString(3, device.getBuyDate());
            ps.setString(4, device.getUseUser());
            ps.setString(5, device.getState());
            ps.setString(6, device.getDid());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean scrap(Device device) {
        device.setState("已报废");
        return modify(device);
    }

    @Override
    public Device getDeviceById(String did) {
        String sql = "select * from device where did=?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, did);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return toDevice(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Device> getAll(String... state) {
        List<Device> list = new ArrayList<Device>();
        String sql = "select * from device";
        if (state != null && state.length > 0) {
            sql = sql + " where state=?";
        }
        sql = sql + " order by did";

        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            if (state != null && state.length > 0) {
                ps.setString(1, state[0]);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(toDevice(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Device toDevice(ResultSet rs) throws SQLException {
        Device device = new Device();
        device.setDid(rs.getString("did"));
        device.setDname(rs.getString("dname"));
        device.setPrice(rs.getDouble("price"));
        device.setBuyDate(rs.getString("buy_date"));
        device.setUseUser(rs.getString("use_user"));
        device.setState(rs.getString("state"));
        return device;
    }
}
