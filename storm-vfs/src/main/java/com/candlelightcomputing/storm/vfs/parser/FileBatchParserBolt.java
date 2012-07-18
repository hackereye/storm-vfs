package com.candlelightcomputing.storm.vfs.parser;

import backtype.storm.coordination.BatchOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseTransactionalBolt;
import backtype.storm.transactional.TransactionAttempt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import com.candlelightcomputing.storm.vfs.parser.FileTupleParser;
import java.util.Map;

/**
 *
 * @author Steve
 */
public class FileBatchParserBolt extends BaseTransactionalBolt {
    
    private FileTupleParser parser;
    private int batchSize;
    
    public FileBatchParserBolt (FileTupleParser parser) {
        this(parser, 1000);
    }
    
    private FileBatchParserBolt (FileTupleParser parser, int batchSize) {
        this.parser = parser;
        this.batchSize = batchSize;
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer ofd) {
        ofd.declare(new Fields("attempt", "data"));
    }

    @Override
    public void prepare(Map map, TopologyContext tc, BatchOutputCollector boc, TransactionAttempt t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void execute(Tuple tuple) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void finishBatch() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
}
