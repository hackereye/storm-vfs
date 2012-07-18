package com.candlelightcomputing.storm.vfs.parser;

import java.util.Iterator;

/**
 *
 * @author Steve
 */
public abstract class FileTupleParser implements  Iterator<ParsedData> {
   
    
   /**
    * Called by {@link FileBatchParserBolt} prior to iterating over results. 
    * The parser should prepare to provide {@link ParsedData} from the file 
    * after it returns from this call.
    * 
    * @param uri 
    */
   abstract void prepare (String uri);
   
   @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
   
}
