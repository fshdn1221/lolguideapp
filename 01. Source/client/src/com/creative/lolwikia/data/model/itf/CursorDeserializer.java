package com.creative.lolwikia.data.model.itf;

import android.database.Cursor;

public interface CursorDeserializer<T> {

    void deserialize(Cursor cs, T out);
}
