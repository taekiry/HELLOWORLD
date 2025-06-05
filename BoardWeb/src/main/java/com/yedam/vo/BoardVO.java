package com.yedam.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oracle.jdbc.proxy.annotation.GetCreator;

/*
 * 필드. 생성자. 메소드. 게터&세터
 * lombok 사용(설치해야하고, 라이브러리 존재해야함) -> eclipse 파일찾아서 롬복 설치. 만약 롬복 실행안되면
 * cmd켜서 cd downloads -> dir -> java -jar lombok.jar
 * 라이브러리 설치 -> 메이븐 레퍼지토리 lombok검색 1.18.38 복사 -> pom.xml 에 붙여넣기
 */
//lombok 라이브러리 annotation 방식으로 getter,setter 추가
//@Getter
//@Setter
@NoArgsConstructor // argument가 없는 기본생성자.
@AllArgsConstructor // 전체생성자

@Data // 생성자, get, set, hashcode, tostring, equals 오버라이딩 되어있음 대신 전체생성자 x
public class BoardVO {
	
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private int readCnt;
	
}
