// $Id$
/* ====================================================================
 * Copyright (c) 2002-2003, Christophe Labouisse
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above
 *    copyright notice, this list of conditions and the following
 *    disclaimer in the documentation and/or other materials provided
 *    with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.ggtools.grand.graph;

import net.ggtools.grand.graph.visit.LinkVisitor;

/**
 *
 *
 * @author Christophe Labouisse
 */
public class LinkImpl extends AttributeManager implements Link {
    /**
     * Field startNode.
     */
    private final Node startNode;

    /**
     * Field endNode.
     */
    private final Node endNode;

    /**
     * Field graph.
     */
    private final Graph graph;

    /**
     * Field name.
     */
    private final String name;

    /**
     * Creates a new Link.
     *
     * @param name link's name, may be <code>null</code>.
     * @param graph owning graph.
     * @param startNode start node of the link
     * @param endNode link's end node.
     */
    public LinkImpl(final String name, final Graph graph, final Node startNode,
            final Node endNode) {
        this.name = name;
        this.graph = graph;
        this.startNode = startNode;
        this.endNode = endNode;
    }

    /**
     * Method toString.
     * @return String
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return ((name == null) ? "" : name)
                + " (" + startNode + " -> " + endNode + ")";
    }

    /**
     * Method getStartNode.
     * @return Node
     * @see net.ggtools.grand.graph.Link#getStartNode()
     */
    public final Node getStartNode() {
        return startNode;
    }

    /**
     * Method getEndNode.
     * @return Node
     * @see net.ggtools.grand.graph.Link#getEndNode()
     */
    public final Node getEndNode() {
        return endNode;
    }

    /**
     * Method getGraph.
     * @return Graph
     * @see net.ggtools.grand.graph.GraphObject#getGraph()
     */
    public final Graph getGraph() {
        return graph;
    }

    /**
     * Method getName.
     * @return String
     * @see net.ggtools.grand.graph.GraphObject#getName()
     */
    public final String getName() {
        return name;
    }

    /**
     * Method accept.
     * @param visitor LinkVisitor
     * @see net.ggtools.grand.graph.Link#accept(net.ggtools.grand.graph.visit.LinkVisitor)
     */
    public void accept(final LinkVisitor visitor) {
        visitor.visitLink(this);
    }

}
