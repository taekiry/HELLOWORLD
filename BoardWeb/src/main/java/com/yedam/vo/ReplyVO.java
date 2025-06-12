package com.yedam.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ReplyVO {
	private int replyNo;
	private int boardNo;
	private String reply;
	private String replyer;
	private Date replyDate;
	
	
}
