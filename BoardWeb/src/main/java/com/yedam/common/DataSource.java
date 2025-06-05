package com.yedam.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * DAO역할. sql session factory builder 생성. 
 * error - > import, try/catch
 * inputstream = null 초기값지정 
 * return sqlSessionFactory;
 * 이해못해도 이대로 쓰면됨. 답답하긴하겠지만;
 * 경로 org. ... -> config폴더에
 * xml파일안에 공백도 에러에 영향미침. 정확한 규칙중요.
 */
public class DataSource {
	public static SqlSessionFactory getInstance() {
		String resource = "config/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
}
