
package com.hakim.hakimtools.util;

import java.util.List;
import java.util.concurrent.Callable;

/**
 *
 * @author Hakim
 */
public class ComparerTask implements Callable<Boolean> {

    private final List<String> list;
    private final String name;

    public ComparerTask(String name,List<String> list) {
        this.name = name;
        this.list = list;
    }

    @Override
    public Boolean call() throws Exception {
        return list.contains(name);
    }
}
