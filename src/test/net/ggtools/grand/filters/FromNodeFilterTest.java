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

package net.ggtools.grand.filters;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

import net.ggtools.grand.Graph;
import net.ggtools.grand.GraphFilter;
import net.ggtools.grand.GraphProducer;
import net.ggtools.grand.Log;
import net.ggtools.grand.Node;
import net.ggtools.grand.ant.AntProject;

import org.apache.tools.ant.BuildFileTest;

/**
 * 
 * 
 * @author Christophe Labouisse
 */
public class FromNodeFilterTest extends BuildFileTest {
    private static final String TEMP_FILE_PROP = "temp.file";

    private GraphProducer producer;

    private static final HashSet NODES_AFTER_FILTERING = new HashSet(Arrays
            .asList(new String[]{"build", "init", "build.core", "build.examples", "build.xml",
                    "jaxp", "jaxpCheck", "build.javamail", "javamail", "javamailCheck",
                    "build.jms", "jms", "jmsCheck", "jndi", "jndiCheck", "build.jmx", "jmx",
                    "jmxCheck"}));

    /**
     * Constructor for IsolatedNodeFilterTest.
     * @param name
     */
    public FromNodeFilterTest(String name) {
        super(name);
    }

    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        configureProject("src/etc/testcases/log4j-build.xml");
        project.setBasedir("src/etc/testcases");
        producer = new AntProject(project);
    }

    /*
     * @see TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        String tempFile = project.getProperty(TEMP_FILE_PROP);

        if (tempFile != null) {
            File f = new File(tempFile);
            f.delete();
        }
    }

    /**
     * Process log4j 1.2.8 build.xml and from the "build" node and check
     * if we get what we want.
     *
     */
    public void testConnectedStartNode() throws Exception {
        GraphFilter filter = new FromNodeFilter("build");
        filter.setProducer(producer);
        Graph graph = filter.getGraph();

        int numNodes = 0;
        for (Iterator iter = graph.getNodes(); iter.hasNext(); ) {
            numNodes++;
            String nodeName = ((Node) iter.next()).getName();

            assertTrue("Node " + nodeName + " should have been filtered out",
                    NODES_AFTER_FILTERING.contains(nodeName));
        }

        assertEquals("Filtered graph does not have the right node count", NODES_AFTER_FILTERING
                .size(), numNodes);
        
        assertNull("Start node 'usage' should have be filtered out",graph.getStartNode());
    }
    
    /**
     * Process a modified version oflog4j 1.2.8 build.xml featuring the "build"
     * target as default. Check if the project start node has not been filtered out.
     *
     */
    public void testNotFilteredStartNode() throws Exception {
        GraphFilter filter = new FromNodeFilter("build");
        filter.setProducer(producer);
        project.setDefault("build");
        Graph graph = filter.getGraph();

        int numNodes = 0;
        for (Iterator iter = graph.getNodes(); iter.hasNext(); ) {
            numNodes++;
            String nodeName = ((Node) iter.next()).getName();

            assertTrue("Node " + nodeName + " should have been filtered out",
                    NODES_AFTER_FILTERING.contains(nodeName));
        }

        assertEquals("Filtered graph does not have the right node count", NODES_AFTER_FILTERING
                .size(), numNodes);
        
        assertNotNull("Start node 'build' should not have be filtered out",graph.getStartNode());
    }

}