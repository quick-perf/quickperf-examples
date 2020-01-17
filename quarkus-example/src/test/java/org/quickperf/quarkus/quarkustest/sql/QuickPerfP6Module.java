package org.quickperf.quarkus.quarkustest.sql;

import com.p6spy.engine.event.JdbcEventListener;
import com.p6spy.engine.logging.P6LogOptions;
import com.p6spy.engine.spy.P6Factory;
import com.p6spy.engine.spy.P6LoadableOptions;
import com.p6spy.engine.spy.option.P6OptionsRepository;

public class QuickPerfP6Module implements P6Factory {
    @Override
    public JdbcEventListener getJdbcEventListener() {
        return QuickPerfP6JdbcEventListener.INSTANCE;
    }

    @Override
    public P6LoadableOptions getOptions(P6OptionsRepository optionsRepository) {
        return new P6LogOptions(optionsRepository);
    }
}
