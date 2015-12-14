package db;

import java.util.List;

/**
 * Created by bigwen on 2015/12/9.
 */
public interface DBLoadFinish {
    void onSuccess(List ... lists);
    void onError(Exception e);
}
