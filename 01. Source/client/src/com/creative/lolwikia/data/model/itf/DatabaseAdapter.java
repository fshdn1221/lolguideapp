package com.creative.lolwikia.data.model.itf;

import android.content.ContentValues;

/**
 * Adapter to convert an object type T to {@link ContentValues}
 * 
 * @author FSHDN
 * @since Sep 22, 2015
 * @param <T>
 *            type of object to be converted
 */
public interface DatabaseAdapter<T> {

    /**
     * @return table name
     */
    String getTableName();

    /**
     * Convert an object to a {@link ContentValues}
     * 
     * @param target
     *            contentvalues to fill data, shouldnt be null
     * @param t
     *            input
     */
    void toContentValues(ContentValues target, T t);

    /**
     * the optional WHERE clause to apply when updating. Passing null will
     * update all rows.
     * 
     * @return
     */
    String getWhereClauses();

    /**
     * You may include ?s in the where clause, which will be replaced by the
     * values from whereArgs. The values will be bound as Strings.
     * 
     * @param t
     * @return
     */
    String[] getWhereArgs(T t);

}
