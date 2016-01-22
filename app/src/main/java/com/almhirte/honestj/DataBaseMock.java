package com.almhirte.honestj;

import java.util.ArrayList;

/**
 * Created by shenkel on 20.01.2016.
 */
public class DataBaseMock
{
    ArrayList<String> db = new ArrayList<String>();
    int index = 0;

    public DataBaseMock()
    {
        db.add("{\"id\":\"1\", \"description\":\"40 years old car\"}");
        db.add("{\"id\":\"2\", \"description\":\"3 years old car\"}");
        db.add("{\"id\":\"3\", \"description\":\"Red car\"}");
    }

    public String loadNextRecord()
    {
        String record = db.get(index);
        index ++;
        return record;
    }

    public boolean hasNext()
    {
        if(index < db.size())
            return true;
        return false;
    }

    public String getFirstRecord()
    {
        resetIndex();
        return db.get(index);
    }

    private void resetIndex()
    {
        index = 0;
    }
}
