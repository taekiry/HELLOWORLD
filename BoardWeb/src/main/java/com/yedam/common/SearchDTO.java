package com.yedam.common;
/*
 * 검색조건 (boardList의 파라미터 3개가 되버려서)
 * page, searchCondition, keyword
 */

import lombok.Data;

@Data
public class SearchDTO {
	private int page;
	private String searchCondition;
	private String keyword;
	
}
