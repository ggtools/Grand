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
package net.ggtools.grand.log;

import org.apache.commons.logging.Log;

/**
 * @author Christophe Labouisse
 */
public class LoggerManager {

    private static LoggerFactory currentFactory;

    private final static LoggerFactory defaultFactory = new LoggerFactory() {
        public Log getLog(Class clazz) {
            return new AntLog();
        }

        public Log getLog(String name) {
            return new AntLog();
        }
    };

    public static Log getLog(Class clazz) {
        if (currentFactory != null) {
            return currentFactory.getLog(clazz);
        }
        else {
            return defaultFactory.getLog(clazz);
        }
    }

    public static Log getLog(String name) {
        if (currentFactory != null) {
            return currentFactory.getLog(name);
        }
        else {
            return defaultFactory.getLog(name);
        }
    }

    public static void setFactory(LoggerFactory factory) {
        currentFactory = factory;
    }

    /**
     * No instanciation allowed.
     */
    private LoggerManager() {
    }
}