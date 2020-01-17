package org.quickperf.quarkus.quarkustest.sql;

import com.p6spy.engine.common.Loggable;
import com.p6spy.engine.common.StatementInformation;
import com.p6spy.engine.event.SimpleJdbcEventListener;
import com.p6spy.engine.logging.Category;
import net.ttddyy.dsproxy.ExecutionInfo;
import net.ttddyy.dsproxy.QueryInfo;
import net.ttddyy.dsproxy.StatementType;
import org.quickperf.sql.SqlRecorder;
import org.quickperf.sql.SqlRecorderRegistry;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Inspired by https://github.com/p6spy/p6spy/blob/master/src/main/java/com/p6spy/engine/logging/LoggingEventListener.java
 */
public class QuickPerfP6JdbcEventListener extends SimpleJdbcEventListener {
    public static final QuickPerfP6JdbcEventListener INSTANCE = new QuickPerfP6JdbcEventListener();
    private final int listenerIdentifier = ThreadLocalRandom.current().nextInt();

    private QuickPerfP6JdbcEventListener(){
    }

    @Override
    public void onAfterAnyExecute(StatementInformation statementInformation, long timeElapsedNanos, SQLException e) {
        logElapsed(statementInformation, timeElapsedNanos, Category.STATEMENT, e);
    }

    @Override
    public void onAfterExecuteBatch(StatementInformation statementInformation, long timeElapsedNanos, int[] updateCounts, SQLException e) {
        logElapsed(statementInformation, timeElapsedNanos, Category.BATCH, e);
    }

    protected void logElapsed(Loggable loggable, long timeElapsedNanos, Category category, SQLException e) {
        try {
            Collection<SqlRecorder> sqlRecorders = SqlRecorderRegistry.INSTANCE.getSqlRecorders();
            ExecutionInfo executionInfo = mapToExecutionInfo(loggable, category, timeElapsedNanos, e);
            List<QueryInfo> queries = mapToQueryInfoList(loggable);

            for (SqlRecorder sqlRecorder : sqlRecorders) {
                sqlRecorder.addQueryExecution(executionInfo, queries, listenerIdentifier);
            }
        }
        catch(Throwable t){
            //TODO this allows debugging it, maybe remove it ?
            t.printStackTrace();
        }
    }

    private List<QueryInfo> mapToQueryInfoList(Loggable loggable) {
        List<QueryInfo> queries = new ArrayList<>();
        QueryInfo queryInfo = new QueryInfo();
        queryInfo.setQuery(loggable.getSql());
        queries.add(queryInfo);
        return queries;
    }

    private ExecutionInfo mapToExecutionInfo(Loggable loggable, Category category, long timeElapsedNanos, SQLException e) {
        ExecutionInfo info = new ExecutionInfo();
        if(category == Category.BATCH){
            info.setBatch(true);
        }
        info.setElapsedTime(timeElapsedNanos);
        if(e != null){
            info.setSuccess(false);
            info.setThrowable(e);
        }
        else {
            info.setSuccess(true);
        }
        info.setConnectionId(String.valueOf(loggable.getConnectionInformation().getConnectionId()));
        info.setStatementType(StatementType.STATEMENT);// PREPARED, CALLABLE
        return info;
    }

}
