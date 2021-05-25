package edu.rogachova.data;

public class UniqueKey
{
    private static Integer collKey;

    public UniqueKey(){
        collKey = 1;
    }

    public static Integer getCollKey()
    {
        return collKey;
    }

    public static void setCollKey(Integer collKey)
    {
        UniqueKey.collKey = UniqueKey.collKey*2 +collKey - 1;
    }
}
