package com.member.controller;

import java.util.List;
import java.util.Map;

import com.member.model.service.MemberService;
import com.member.model.vo.Member;
import com.member.view.MemberView;

//member 서비스를 관리하는 객체
//client에게 특정 서비스 기능을 요청받아서 처리
// 필요한 화면 (View)/DB를 가져오는 것(model)  > 이러한 것들의 사이에 있는 것이 컨트롤러 + 데이터를 필터링하기도 하고, 인코딩 처리도 하기도 하고
public class MemberController {
	
	
	private MemberService service = new MemberService();
	
		
		public void mainView() {
			//메인 화면을 보여달라는 요청을 하는 친구
			
			new MemberView().mainView(this);
			
			
		}
	
		public void queryAll() {
//			 db의 student 계정의 member 테이블 전체 데이터를 가져와 출력해주는 기능
			// DB에 접근할 때 Service객체에 요청
			List<Member> memList = service.queryAll();
			new MemberView().print(memList);
		}

		public void queryName() {
			String input = new MemberView().queryName();
			
			
			List<Member> memList = service.queryName(input);
			new MemberView().print(memList);
			//그냥 db다녀오면 반환형 있다고 생각해
		}
		
		
		public void queryDesire() {
			Map<String,String> param = new MemberView().queryDesire();
			List<Member> result = service.queryDesire(param);
			
			
			new MemberView().print(result);
		}

		public void queryId() {
			// TODO Auto-generated method stub
			String input = new MemberView().queryId();
			List<Member> result = service.queryId(input);
			new MemberView().print(result);
			
		}

}
