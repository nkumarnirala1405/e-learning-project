package com.amdocs.training.DAO;

import java.util.List;

import com.amdocs.training.model.Feedback;

public interface FeedbackDAO {
	List<Feedback> findAll();
	boolean addFeedback(Feedback feedback);
	Feedback getFeedbackById(int id);
	boolean delete(int id);
	void update(int id);
}
