// $Id$
/*
 * ====================================================================
 * Copyright (c) 2002-2004, Christophe Labouisse All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package net.ggtools.grand.filters;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

import net.ggtools.grand.exceptions.GrandException;
import net.ggtools.grand.graph.Graph;
import net.ggtools.grand.graph.Node;
import net.ggtools.grand.log.LoggerManager;

import org.apache.commons.logging.Log;

/**
 * A filter to remove one or more node from a graph.
 * 
 * @author Christophe Labouisse
 */
public class NodeRemoverFilter extends AbstractGraphFilter {
    private static final Log log = LoggerManager.getLog(NodeRemoverFilter.class);

    private final HashSet nodesToRemove;

    /**
     * Creates a new node remover filter.
     * @param nodesToRemove a collection of node names to remove.
     */
    public NodeRemoverFilter(final Collection nodesToRemove) {
        super("Node remover");
        this.nodesToRemove = new HashSet(nodesToRemove);
    }

    /*
     * (non-Javadoc)
     * @see net.ggtools.grand.filters.AbstractGraphFilter#getFilteredNodes()
     */
    protected Collection getFilteredNodes() throws GrandException {
        final Graph graph = getProducersGraph();
        final LinkedHashSet result = new LinkedHashSet();

        for (final Iterator iter = graph.getNodes(); iter.hasNext();) {
            final Node node = (Node) iter.next();
            
            if (!nodesToRemove.contains(node.getName())) {
                result.add(node);
            }
        }

        if (log.isDebugEnabled()) {
            log.debug("getFilteredNodes() - end - return value = " + result);
        }
        return result;
    }

}