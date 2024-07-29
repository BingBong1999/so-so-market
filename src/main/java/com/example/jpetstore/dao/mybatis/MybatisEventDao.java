package com.example.jpetstore.dao.mybatis;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.scheduler.dao.EventDao;
import com.example.jpetstore.dao.mybatis.mapper.EventMapper;

@Repository
public class MybatisEventDao implements EventDao {

	@Autowired
	private EventMapper eventMapper;

	public void insertNewEvent(HashMap<String, Date> map) {
		eventMapper.insertNewEvent(map);
	}

	public void closeEvent(Date curTime) {
		eventMapper.closeEvent(curTime);
	}
}