package com.sunbeam.beans;

import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class ResultBean {
	List<Candidate> candList;
	
	public ResultBean(List<Candidate> candList) {
		this.candList = candList;
	}

	public ResultBean() {
		
	}

	public List<Candidate> getCandList() {
		return candList;
	}

	public void setCandList(List<Candidate> candList) {
		this.candList = candList;
	}

	public void fetchCandidates() {
		try(CandidateDao candDao = new CandidateDaoImpl()){
			candList = candDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

}
