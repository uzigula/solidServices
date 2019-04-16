package com.mck.samples.webapp.infrastructure;


public class RequestIdGenerator implements IAmIdGenerator<Long> {
    private static volatile RequestIdGenerator INSTANCE;
    private final long _seed;
    private long _counter;

    private RequestIdGenerator(int seed) {
        if (seed<=0 )
            this._seed = (long)(Math.random() * 999 + 1) * 1000000;
        else
            this._seed = seed * 1000000;

        this._counter = 0;
    }

    public static RequestIdGenerator getInstance(int seed) {
        if(null == INSTANCE){
            synchronized (RequestIdGenerator.class) {
                if(null == INSTANCE){
                    INSTANCE = new RequestIdGenerator(seed);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public synchronized Long getId() {
        _counter++;
        return (_seed + _counter);
    }
}
