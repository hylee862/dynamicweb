package edu.autocar.tour.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.autocar.domain.Board;
import edu.autocar.domain.PageInfo;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService {
	private List<Board> boardList;
	final static private int PER_PAGE_COUNT = 10;
	int maxId = 0;
	
	public BoardServiceImpl() {
		// TODO Auto-generated constructor stub
		boardList = Collections.synchronizedList(new LinkedList<>());
		for(maxId=1;maxId<=45;maxId++) {
			boardList.add(0, new Board(maxId));
		}
	}
	
	@Override
	public Board getboard(int boardId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public PageInfo<Board> getPage(int page) throws Exception {
		// TODO Auto-generated method stub
		List<Board> list = new ArrayList<Board>();
		
		int start = (page-1)*PER_PAGE_COUNT;
		int end = start + PER_PAGE_COUNT;
		int totalCount = boardList.size();
		if(end > totalCount) {
			end = totalCount;
		}
		
		for(int i=start; i<end; i++) {
			list.add(boardList.get(i));
		}
		
		
		return new PageInfo<>(
				totalCount,
				(int)Math.ceil(totalCount/(double)PER_PAGE_COUNT),
				page, PER_PAGE_COUNT, list);
	}
	
	@Override
	public void create(Board board) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean update(Board board) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean delete(int boardId, String password) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}