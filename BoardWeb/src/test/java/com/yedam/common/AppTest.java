package com.yedam.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.mapper.BoardMapper;

public class AppTest {
	public static void main(String[] args) {
//		//Reply Test
//		ReplyService svc = new ReplyServiceImpl();
//		
//		// 목록.
//		List<ReplyVO> list = svc.replyList(239,1);
//		for(ReplyVO reply : list) {
//			System.out.println(reply.toString());
//		}
//		//한건 조회
//		ReplyVO repl = svc.getReply(1);
//		System.out.println(repl);
//		
//		//등록
//		ReplyVO reple = new ReplyVO();
//		
//		reple.setBoardNo(239);
//		reple.setReply("호로로롤ㄹ로로롤");
//		reple.setReplyer("user01");
//		
//		svc.addReply(reple);
//		//삭제
//		
//		svc.removeReply(6);
		
		SqlSession sqlSession = DataSource.getInstance().openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		List<Map> list = mapper.selectUserByCount();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(list);
		
		System.out.println(json);
		
		
	}
}
