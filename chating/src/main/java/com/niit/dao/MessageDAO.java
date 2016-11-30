package com.niit.dao;

import java.util.List;

import com.niit.model.Message;



public interface MessageDAO {
 public int insertRow(Message cat);

 public List getList();

 public Message getRowById(int id);

 public int updateRow(Message cat);

 public int deleteRow(int id);

}