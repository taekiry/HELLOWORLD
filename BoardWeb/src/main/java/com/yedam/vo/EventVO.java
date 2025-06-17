package com.yedam.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor // argument가 없는 기본생성자.
@AllArgsConstructor // 전체생성자
@Data
public class EventVO {
	public String title;
	public String start;
	public String end;
}
