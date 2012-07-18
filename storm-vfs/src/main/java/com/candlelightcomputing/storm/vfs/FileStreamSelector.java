package com.candlelightcomputing.storm.vfs;

import java.io.Serializable;
import java.util.Set;

/**
 * User-specified selector optionally used to direct file notifications to 
 * specific streams.  Without use of a selector, file notifications are emitted
 * to the default output.
 * 
 * @author Steve
 */
public interface FileStreamSelector extends Serializable {
    
    /**
     * Returns the collection of stream id the selector may decide to publish
     * a file to
     * 
     * @return 
     */
    Set<String> getStreamIds();
    
    /**
     * Provides the stream id(s) to publish the file.  If no streams should
     * receive this file, returns null;
     * 
     * @param file
     * @return array of streamIds or null
     */
    String[] selectStream (String file);
    
    /**
     * Selector decides if this file should be be traversed for child files
     * 
     * @param file
     * @return 
     */
    boolean traverseFile (String file);
    
    /**
     * Notifies the selector when a file has completed processing.  This may be 
     * used to manage selector state in some way (delete the file or move file 
     * to an archive directory, persistently store the result of this file 
     * parsing to prevent further parsing, etc).
     * 
     * @param file 
     */
    void complete (String file);
}
