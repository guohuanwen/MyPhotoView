package tool;

import android.content.Context;

import com.bcgtgjyb.myphotoapp.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.request.target.ViewTarget;

/**
 * Created by bigwen on 2015/12/14.
 */
public class MyGlideMoudle implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        ViewTarget.setTagId(R.id.glide_tag_id);

    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
