package com.odde.bbuddy.common;

public class FailedPostActions implements PostActions {
    @Override
    public PostActions success(Runnable afterSuccess) {
        return this;
    }

    @Override
    public PostActions failed(Runnable afterFailed) {
        afterFailed.run();
        return this;
    }
}
