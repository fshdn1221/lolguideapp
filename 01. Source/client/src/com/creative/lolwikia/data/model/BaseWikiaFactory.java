package com.creative.lolwikia.data.model;

import java.util.List;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.creative.lolwikia.data.database.DBConst;
import com.creative.lolwikia.data.model.itf.DatabaseAdapter;

/**
 * Basic database adapter
 * @author FSHDN
 * @since Sep 22, 2015
 * @param <T>
 */
public abstract class BaseWikiaFactory<T extends BaseWikiaModel> implements
        DatabaseAdapter<T> {

    @Override
    public void toContentValues(ContentValues target, T t) {
        target.put(DBConst.BaseTable.COL_ID, t.getId());
        target.put(DBConst.BaseTable.COL_VERSION, t.getVersion());
    }

    /**
     * Insert a new record to database
     * @param database database to be inserted
     * @param values record's data
     * @param updateIfExist true to update record if it has existed, false otherwise
     * @return true if success, false otherwise
     */
    protected boolean insert(SQLiteDatabase database, ContentValues values,
            boolean updateIfExist) {
        long ret = -1;
        if (values != null) {
            if (updateIfExist) {
                ret = database.replace(getTableName(), null, values);
            } else {
                ret = database.insert(getTableName(), null, values);
            }
        }
        return ret != -1;
    }

    /**
     * Insert a new record to database
     * @param database database to be inserted
     * @param model record's data
     * @param updateIfExist true to update record if it has existed, false otherwise
     * @return true if success, false otherwise
     */
    public boolean insert(SQLiteDatabase database, T model,
            boolean updateIfExist) {
        if (database == null)
            throw new NullPointerException("Cannot insert to a null database");
        if (model != null) {
            ContentValues values = new ContentValues();
            this.toContentValues(values, model);
            return insert(database, values, updateIfExist);
        }
        return false;
    }

    /**
     * Insert a list of records to database
     * @param database database to be inserted
     * @param models records's data
     * @param updateIfExist true to update record if it has existed, false otherwise
     * @return true if success, false otherwise
     */
    public boolean insert(SQLiteDatabase database, List<T> models,
            boolean updateIfExist) {
        if (database == null)
            throw new NullPointerException("Cannot insert to a null database");
        if (models != null && models.size() > 0) {
            boolean ret = true;
            ContentValues values = new ContentValues();
            if (updateIfExist) {
                for (T t : models) {
                    this.toContentValues(values, t);
                    ret &= (database.replace(getTableName(), null, values) != -1);
                    values.clear();
                }
            } else {
                for (T t : models) {
                    this.toContentValues(values, t);
                    ret &= (database.insert(getTableName(), null, values) != -1);
                    values.clear();
                }
            }
            return ret;
        }
        return false;
    }

    /**
     * Update a record to database
     * @param database database to be updated
     * @param model newly data record
     * @return true if updated, false otherwise
     */
    public boolean update(SQLiteDatabase database, T model) {
        if (database == null)
            throw new NullPointerException("Cannot update to a null database");
        if (model != null) {
            ContentValues values = new ContentValues();
            this.toContentValues(values, model);
            return database.update(getTableName(), values, getWhereClauses(), getWhereArgs(model)) > 0;
        }
        return false;
    }

    /**
     * Update a list of records to database
     * @param database database to be updated
     * @param models newly data records
     * @return true if all of records updated, false otherwise
     */
    public boolean update(SQLiteDatabase database, List<T> models) {
        if (database == null)
            throw new NullPointerException("Cannot update to a null database");
        if (models != null && models.size() > 0) {
            boolean ret = true;
            String whereClause = this.getWhereClauses();
            ContentValues values = new ContentValues();
            for (T t: models) {
                this.toContentValues(values, t);
                String[] whereArgs = this.getWhereArgs(t);
                ret &= (database.update(getTableName(), values, whereClause, whereArgs) > 0);
            }
            return ret;
        }
        return false;
    }
}
