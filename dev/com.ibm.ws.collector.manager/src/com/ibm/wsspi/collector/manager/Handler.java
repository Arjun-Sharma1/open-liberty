/*
 * IBM Confidential
 *
 * OCO Source Materials
 *
 * Copyright IBM Corp. 2015
 *
 * The source code for this program is not published or otherwise divested 
 * of its trade secrets, irrespective of what has been deposited with the 
 * U.S. Copyright Office.
 */
package com.ibm.wsspi.collector.manager;

/**
 * Handler interface, a handler managed by the collector manager framework should implement this interface.
 */
public interface Handler {

    /**
     * Returns the name of the handler. This should be unique across handlers.
     * Handler name will be used by the collector manager to identify a handler provider.
     * It will also be used by the buffer manager to keep track of the events read by a handler.
     * 
     * @return The name of the handler
     */
    String getHandlerName();

    /**
     * Collector manager calls this method on bound handlers to allow them to perform any initialization
     * before receiving data.
     * <br>
     * Note: A handler should perform all its subscriptions in this method.
     * 
     * @param collectorManager Reference to collector manager instance.
     */
    void init(CollectorManager collectorManager);

    /**
     * Handler will retrieve events for a source from this buffer.
     * Collector manager will use this method to assign a buffer instance to the handler.
     * 
     * @param sourceId Source identifier.
     * @param bufferMgr Buffer manager instance for the source.
     */
    void setBufferManager(String sourceId, BufferManager bufferMgr);

    /**
     * Collector manager will use this method to indicate this source/buffer should no longer be used.
     * 
     * @param sourcdId Source identifier.
     * @param bufferMgr Buffer manager instance for the source.
     */
    void unsetBufferManager(String sourceId, BufferManager bufferMgr);
}
