package net;

/**
 * Created by bigwen on 2015/12/9.
 */
public interface HttpFinish {
    void onSuccess(String text);
    void onError(Exception e);
}
