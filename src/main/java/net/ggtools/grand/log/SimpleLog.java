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
 * Simple log class logging to stdout.
 *
 * @author Christophe Labouisse
 */
class SimpleLog implements Log {
    /**
     * Field LEVEL_NONE.
     * (value is {@value #LEVEL_NONE})
     */
    protected static final int LEVEL_NONE = 0;
    /**
     * Field LEVEL_FATAL.
     * (value is {@value #LEVEL_FATAL})
     */
    protected static final int LEVEL_FATAL = 1;
    /**
     * Field LEVEL_ERROR.
     * (value is {@value #LEVEL_ERROR})
     */
    protected static final int LEVEL_ERROR = 2;
    /**
     * Field LEVEL_WARN.
     * (value is {@value #LEVEL_WARN})
     */
    protected static final int LEVEL_WARN = 3;
    /**
     * Field LEVEL_INFO.
     * (value is {@value #LEVEL_INFO})
     */
    protected static final int LEVEL_INFO = 4;
    /**
     * Field LEVEL_DEBUG.
     * (value is {@value #LEVEL_DEBUG})
     */
    protected static final int LEVEL_DEBUG = 5;
    /**
     * Field LEVEL_TRACE.
     * (value is {@value #LEVEL_TRACE})
     */
    protected static final int LEVEL_TRACE = 6;
    /**
     * Field LEVEL_ALL.
     * (value is {@value #LEVEL_ALL})
     */
    protected static final int LEVEL_ALL = 7;

    /**
     * Field LEVEL_NAMES.
     */
    protected static final String[] LEVEL_NAMES = {"NONE", "FATAL",
        "ERROR", "WARN", "INFO", "DEBUG", "TRACE", "ALL"};

    /**
     * Field logLevel.
     */
    private static final int LOG_LEVEL = LEVEL_WARN;

    /**
     * Package only instantiation.
     */
    SimpleLog() {
    }

    /**
     * Method debug.
     * @param message Object
     * @see org.apache.commons.logging.Log#debug(java.lang.Object)
     */
    public void debug(final Object message) {
        log(message, LEVEL_DEBUG);
    }

    /**
     * Method debug.
     * @param message Object
     * @param t Throwable
     * @see org.apache.commons.logging.Log#debug(java.lang.Object, java.lang.Throwable)
     */
    public void debug(final Object message, final Throwable t) {
        log(message, t, LEVEL_DEBUG);
    }

    /**
     * Method error.
     * @param message Object
     * @see org.apache.commons.logging.Log#error(java.lang.Object)
     */
    public void error(final Object message) {
        log(message, LEVEL_ERROR);
    }

    /**
     * Method error.
     * @param message Object
     * @param t Throwable
     * @see org.apache.commons.logging.Log#error(java.lang.Object, java.lang.Throwable)
     */
    public void error(final Object message, final Throwable t) {
        log(message, t, LEVEL_ERROR);
    }

    /**
     * Method fatal.
     * @param message Object
     * @see org.apache.commons.logging.Log#fatal(java.lang.Object)
     */
    public void fatal(final Object message) {
        log(message, LEVEL_FATAL);
    }

    /**
     * Method fatal.
     * @param message Object
     * @param t Throwable
     * @see org.apache.commons.logging.Log#fatal(java.lang.Object, java.lang.Throwable)
     */
    public void fatal(final Object message, final Throwable t) {
        log(message, t, LEVEL_FATAL);
    }

    /**
     * Method info.
     * @param message Object
     * @see org.apache.commons.logging.Log#info(java.lang.Object)
     */
    public void info(final Object message) {
        log(message, LEVEL_INFO);
    }

    /**
     * Method info.
     * @param message Object
     * @param t Throwable
     * @see org.apache.commons.logging.Log#info(java.lang.Object, java.lang.Throwable)
     */
    public void info(final Object message, final Throwable t) {
        log(message, t, LEVEL_INFO);
    }

    /**
     * Method isDebugEnabled.
     * @return boolean
     * @see org.apache.commons.logging.Log#isDebugEnabled()
     */
    public boolean isDebugEnabled() {
        return LOG_LEVEL >= LEVEL_DEBUG;
    }

    /**
     * Method isErrorEnabled.
     * @return boolean
     * @see org.apache.commons.logging.Log#isErrorEnabled()
     */
    public boolean isErrorEnabled() {
        return LOG_LEVEL >= LEVEL_ERROR;
    }

    /**
     * Method isFatalEnabled.
     * @return boolean
     * @see org.apache.commons.logging.Log#isFatalEnabled()
     */
    public boolean isFatalEnabled() {
        return LOG_LEVEL >= LEVEL_FATAL;
    }

    /**
     * Method isInfoEnabled.
     * @return boolean
     * @see org.apache.commons.logging.Log#isInfoEnabled()
     */
    public boolean isInfoEnabled() {
        return LOG_LEVEL >= LEVEL_INFO;
    }

    /**
     * Method isTraceEnabled.
     * @return boolean
     * @see org.apache.commons.logging.Log#isTraceEnabled()
     */
    public boolean isTraceEnabled() {
        return LOG_LEVEL >= LEVEL_TRACE;
    }

    /**
     * Method isWarnEnabled.
     * @return boolean
     * @see org.apache.commons.logging.Log#isWarnEnabled()
     */
    public boolean isWarnEnabled() {
        return LOG_LEVEL >= LEVEL_WARN;
    }

    /**
     * Method trace.
     * @param message Object
     * @see org.apache.commons.logging.Log#trace(java.lang.Object)
     */
    public void trace(final Object message) {
        log(message, LEVEL_TRACE);
    }

    /**
     * Method trace.
     * @param message Object
     * @param t Throwable
     * @see org.apache.commons.logging.Log#trace(java.lang.Object, java.lang.Throwable)
     */
    public void trace(final Object message, final Throwable t) {
        log(message, t, LEVEL_TRACE);
    }

    /**
     * Method warn.
     * @param message Object
     * @see org.apache.commons.logging.Log#warn(java.lang.Object)
     */
    public void warn(final Object message) {
        log(message, LEVEL_WARN);
    }

    /**
     * Method warn.
     * @param message Object
     * @param t Throwable
     * @see org.apache.commons.logging.Log#warn(java.lang.Object, java.lang.Throwable)
     */
    public void warn(final Object message, final Throwable t) {
        log(message, t, LEVEL_WARN);
    }

    /**
     * Method log.
     * @param message Object
     * @param level int
     */
    protected void log(final Object message, final int level) {
        log(message, null, level);
    }

    /**
     * Method log.
     * @param message Object
     * @param t Throwable
     * @param level int
     */
    protected void log(final Object message, final Throwable t,
            final int level) {
        if (level <= LOG_LEVEL) {
            System.out.println("[" + LEVEL_NAMES[level] + "] " + message);
            if (t != null) {
                t.printStackTrace(System.out);
            }
        }
    }

}
