package org.slf4j.impl;

import cool.happycoding.code.log.trace.HappyMDCAdapter;
import org.slf4j.spi.MDCAdapter;

/**
 * This implementation is bound to {@link HappyMDCAdapter}.
 *
 * @author Ceki G&uuml;lc&uuml;
 */
@SuppressWarnings("all")
public class StaticMDCBinder {

    /**
     * The unique instance of this class.
     */
    public static final StaticMDCBinder SINGLETON = new StaticMDCBinder();

    private StaticMDCBinder() {
    }

    /**
     * Currently this method always returns an instance of
     * {@link StaticMDCBinder}.
     */
    public MDCAdapter getMDCA() {
        return new HappyMDCAdapter();
    }

    public String getMDCAdapterClassStr() {
        return HappyMDCAdapter.class.getName();
    }
}

