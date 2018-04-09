/*
 * Copyright 1999-2011 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.chnghx.core.monitor.filter;

import java.sql.SQLException;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.filter.stat.StatFilterContext;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.druid.proxy.jdbc.StatementProxy;
import com.alibaba.druid.stat.JdbcDataSourceStat;
import com.alibaba.druid.stat.JdbcStatContext;
import com.alibaba.druid.stat.JdbcStatManager;
import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;

/**
 * 用于配置Web和Druid数据源之间的管理关联监控统计
 */
public class NewStatFilter extends StatFilter {

	private final static Log LOG = LogFactory.getLog(NewStatFilter.class);

	@Override
	public void statement_close(FilterChain chain, StatementProxy statement) throws SQLException {
		chain.statement_close(statement);

		JdbcDataSourceStat dataSourceStat = chain.getDataSource().getDataSourceStat();
		dataSourceStat.getStatementStat().incrementStatementCloseCounter();
		JdbcStatContext context = JdbcStatManager.getInstance().getStatContext();
		if (context != null) {
			context.setName(null);
			context.setFile(null);
			context.setSql(null);
		}
		// 获取与推送监控数据
		try {
			NewWebStatFilter.getMonitorData();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.debug("sql监控出现异常，不影响业务执行..............................");
		}
	}

	@Override
	public DruidPooledConnection dataSource_getConnection(FilterChain chain, DruidDataSource dataSource,
			long maxWaitMillis) throws SQLException {
		LOG.debug("sql监控现在开始..............................");
		DruidPooledConnection conn = chain.dataSource_connect(dataSource, maxWaitMillis);

		if (conn != null) {
			conn.setConnectedTimeNano();

			StatFilterContext.getInstance().pool_connection_open();
		}

		return conn;
	}

}
