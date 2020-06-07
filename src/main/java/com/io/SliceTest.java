package com.io;

public class SliceTest  {
    final int[] hb;                  // Non-null only for heap buffers
    boolean isReadOnly;

    public SliceTest(int[] hb) {
        this.hb = hb;
    }

    public SliceTest put(int a){
        hb[0] = a;
        return this;
    }

    //快照
    public SliceTest slice(){
        return new SliceTest(hb);
    }

}
