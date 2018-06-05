package com.scsa.model.service;

import java.util.List;

import com.scsa.model.vo.RecycleBox;

public interface RecycleBoxService {
	List<RecycleBox> findRecycleBoxList();
	List<RecycleBox> findRecycleBoxListWithCurrentLocation(RecycleBox recycleBox);
	boolean addRecycleBox(RecycleBox recycleBox);
}
