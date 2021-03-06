package unit04.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import unit04.domain.Member;
import unit04.domain.PageInfo;

public class MemberServiceImpl implements MemberService {
	private List<Member> memberList;
	final private int PER_PAGE_COUNT = 10;

	//	싱글톤 패턴
	static private MemberService service = new MemberServiceImpl();
	
	private MemberServiceImpl() {
		memberList = Collections.synchronizedList(new ArrayList<>());
		for(int i=1; i<45; i++) {
			memberList.add(new Member("hong"+i, "1234", "홍"+i,
					"hong"+i+"@gmail.com", "010", "M", new Date()));
		}
	}
	
	static public MemberService getInstance() {
		return service;
	}
	
//	***	페이지네이션 ***
	@Override
	public PageInfo<Member> getPage(int page) {
		List<Member> list = new ArrayList<>();

		int start = (page-1)*PER_PAGE_COUNT;
		int end = start + PER_PAGE_COUNT;
		if(end > memberList.size()) {
			end = memberList.size();
		}
		
		for (int i =start ; i < end; i++) {
			list.add(memberList.get(i));
		}
		return new PageInfo<>(memberList.size(), getTotalPage(), page, PER_PAGE_COUNT, list);
	}
	@Override
	public int getTotalCount() {
		int totalCount = memberList.size();
		return totalCount;
	}
	@Override
	public int getTotalPage() {
		int totalPage = (int)Math.ceil(memberList.size()/ (double)PER_PAGE_COUNT);
		return totalPage;
	}
	
}
