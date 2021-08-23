package com.andryanstgkr.parsamosir.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.andryanstgkr.parsamosir.api.constant.ParamConstant;
import com.andryanstgkr.parsamosir.api.repository.BaseRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseService<T, ID> {

	Logger logger = LoggerFactory.getLogger(BaseService.class);

	@Autowired
	private BaseRepository<T, ID> baseRepository;

	public void delete(T t) {

	}

	public Optional<T> getDetail(ID id) {
		Optional<T> t = baseRepository.findById(id);
		return t;
	}

	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param sortBy
	 * @return
	 */
	public Map<String, Object> getAllByPagination(int pageNo, int pageSize, Sort sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, sortBy);

		Page<T> pagedResult = baseRepository.findAll(paging);

		Map<String, Object> resultMap = new HashMap<>();
		List<T> resultList = new ArrayList<>();

		if (pagedResult.hasContent()) {
			resultList = pagedResult.getContent();
		} else {
			resultList = new ArrayList<T>();
		}
		resultMap.put(ParamConstant.RESULT_LIST, resultList);
		resultMap.put(ParamConstant.TOTAL_PAGES, pagedResult.getTotalPages());
		resultMap.put(ParamConstant.TOTAL_ELEMENTS, pagedResult.getTotalElements());

		return resultMap;
	}

	public List<T> findAll() {
		List<T> listT = new ArrayList<T>();
		Iterator<T> iteratorT = baseRepository.findAll().iterator();
		iteratorT.forEachRemaining(listT::add);
		return listT;
	}

	public T save(T t) {
		T t1 = baseRepository.save(t);
		return t1;
	}

	public boolean existsById(ID id) {

		return false;
	}

	public abstract T update(T t, String activity, ID id);


}
