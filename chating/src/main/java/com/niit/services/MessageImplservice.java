package com.niit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.MessageDAO;
import com.niit.model.Message;

@Service("messageService")
public class MessageImplservice implements MessageService {
    
	 @Autowired
	 MessageDAO messageDAO;

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int insertRow(Message cat) {
	  return messageDAO.insertRow(cat);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public List getList() {
	  return messageDAO.getList();
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public Message getRowById(int id) {
	  return messageDAO.getRowById(id);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int updateRow(Message cat) {
	  return messageDAO.updateRow(cat);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int deleteRow(int id) {
	  return messageDAO.deleteRow(id);
	 }
}