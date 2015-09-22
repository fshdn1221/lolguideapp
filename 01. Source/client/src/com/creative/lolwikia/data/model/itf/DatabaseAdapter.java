package com.creative.lolwikia.data.model.itf;

import android.content.ContentValues;

/**
 * Adapter to convert an object type T to {@link ContentValues}
 * @author FSHDN
 * @since Sep 22, 2015
 * @param <T> type of object to be converted
 */
public interface DatabaseAdapter<T> {

    String getTableName();

    void toContentValues(ContentValues target, T t);

    String getWhereClauses();

    String[] getWhereArgs(T t);

}
