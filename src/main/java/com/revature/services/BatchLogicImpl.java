package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.domain.Batch;
import com.revature.domain.Person;
import com.revature.repositories.BatchRepository;

@Service
@Transactional(readOnly=false, isolation=Isolation.READ_COMMITTED)
public class BatchLogicImpl implements BatchLogic {

	@Autowired
	private BatchRepository dao;
	
	@Override
	public Batch getBatchByName(String batchName) {
		Batch batch = dao.findByNameIgnoreCase(batchName);
		return batch;
	}

	@Override
	public Batch getBatchById(int batchId) {
		Batch batch = dao.findOne(batchId);
		return batch;
		}

	@Override
	public void deleteBatch(Batch batchName) {
		dao.delete(batchName);	
	}
	

	@Override
	public Page<Batch> getAllBatches(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public void createBatch(Batch batchName) {
		dao.save(batchName);
		
	}

	@Override
	public void updateBatch(Batch batchName) {
		dao.save(batchName);
		
	}

	@Override
	public Page<Person> getAllPeopleByBatchId(Pageable pageable, Integer id) {
		 Batch batch = dao.findOne(id);
		 List<Person> personList = batch.getPersons();
		Page<Person> personPage = new PageImpl<Person>(personList, pageable, personList.size());
		return personPage;
	}

}