package com.candlelightcomputing.storm.vfs;

import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseTransactionalSpout;
import backtype.storm.tuple.Fields;
import java.util.Map;
import org.apache.commons.vfs2.*;

/**
 * Polls for new files on disk
 *
 * @author Steve
 */
public class FileDiscoverySpout extends BaseTransactionalSpout<String> {

    private FileObject source;
    private FileStreamSelector selector;

    private FileDiscoverySpout() {
    }

    public static FileDiscoverySpout create(String sourceURI)
            throws FileSystemException {
        return create(sourceURI, null);
    }

    public static FileDiscoverySpout create(String sourceURI, FileStreamSelector selector) throws FileSystemException {
        FileDiscoverySpout spout = new FileDiscoverySpout();
        spout.source = VFS.getManager().resolveFile(sourceURI);
        spout.selector = selector;
        return spout;
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer ofd) {
        ofd.declare(new Fields("attempt", "uri"));
    }

    @Override
    public Coordinator<String> getCoordinator(Map map, TopologyContext tc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Emitter<String> getEmitter(Map map, TopologyContext tc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
