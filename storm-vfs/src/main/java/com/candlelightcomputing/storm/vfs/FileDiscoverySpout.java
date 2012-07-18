package com.candlelightcomputing.storm.vfs;

import backtype.storm.coordination.BatchOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseTransactionalSpout;
import backtype.storm.transactional.ITransactionalSpout;
import backtype.storm.transactional.TransactionAttempt;
import backtype.storm.tuple.Fields;
import java.math.BigInteger;
import java.util.Map;
import org.apache.commons.vfs2.*;

/**
 * Polls for new files on disk
 *
 * @author Steve
 */
public class FileDiscoverySpout extends BaseTransactionalSpout<String> {

    private String source;
    private FileStreamSelector selector;

    private FileDiscoverySpout() {
    }

    public static FileDiscoverySpout create(String sourceURI)
            throws FileSystemException {
        return create(sourceURI, null);
    }

    public static FileDiscoverySpout create(String sourceURI, FileStreamSelector selector) throws FileSystemException {
        FileDiscoverySpout spout = new FileDiscoverySpout();
        spout.source = sourceURI;
        spout.selector = selector;
        return spout;
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer ofd) {
        ofd.declare(new Fields("attempt", "uri"));
    }

    @Override
    public Coordinator<String> getCoordinator(Map map, TopologyContext tc) {
        return new DiscoveryCoordinator();
    }

    @Override
    public Emitter<String> getEmitter(Map map, TopologyContext tc) {
        return new DiscoveryEmitter();
    }

    private class DiscoveryCoordinator implements ITransactionalSpout.Coordinator<String> {

        private FileSystemManager fsm;
        private FileObject source;

        private DiscoveryCoordinator(String sourceURI) throws FileSystemException {
            fsm = VFS.getManager();
            source = fsm.resolveFile(sourceURI);
        }

        @Override
        public boolean isReady() {
        }

        @Override
        public void close() {
        }

        @Override
        public String initializeTransaction(BigInteger bi, String x) {
        }
    }

    private class DiscoveryEmitter implements ITransactionalSpout.Emitter {

        @Override
        public void emitBatch(TransactionAttempt ta, Object x, BatchOutputCollector boc) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void cleanupBefore(BigInteger bi) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void close() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
