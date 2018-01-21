package chatting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import chatting.daoInter.WeatherDaoInter;
import chatting.util.DBUtil;
import chatting.vo.Weather;

public class WeatherDao implements WeatherDaoInter {

	@Override
	public boolean addRecord(Weather weather) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getconnection();
		String sql = "insert into weather values(?,?,?,?)";
		int i = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, weather.getCityID());
			ps.setString(2, weather.getCityName());
			ps.setDate(3, (java.sql.Date) weather.getDate());
			ps.setString(4, weather.getStatus());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.releaseConnection(conn);

		return i > 0;
	}

	@Override
	public boolean delRecord(Date date) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getconnection();
		String sql = "delete from weather where date=?";
		int i = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDate(1, (java.sql.Date) date);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(conn);
		}
		return i > 0;
	}

	@Override
	public ArrayList<Weather> getRecord(String cityID) {
		// TODO Auto-generated method stub
		ArrayList<Weather> list = new ArrayList<Weather>();
		Weather w = null;
		String sql = "select * from weather where cityID = ?";
		Connection conn = DBUtil.getconnection();
		ResultSet rs = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cityID);
			rs = ps.executeQuery();
			while (rs.next()) {

				w = new Weather(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4));
				list.add(w);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(conn);
		}
		return list;
	}

}
