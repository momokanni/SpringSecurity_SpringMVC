package com.caishen91.jupiter.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 所有Service的基类，用来注入sqlSession
 *
 */
public class BaseService
{
	/**
	 * 可写的sqlSession
	 */
	@Autowired
	@Qualifier("writableSQLSession")
	protected SqlSession writableSQLSession;
	
	/**
	 * 只读的sqlSession
	 */
	@Autowired
	@Qualifier("readonlySQLSession")
	protected SqlSession readonlySQLSession;


}
