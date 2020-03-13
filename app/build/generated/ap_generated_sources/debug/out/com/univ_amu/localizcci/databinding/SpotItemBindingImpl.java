package com.univ_amu.localizcci.databinding;
import com.univ_amu.localizcci.R;
import com.univ_amu.localizcci.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class SpotItemBindingImpl extends SpotItemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imgspot, 2);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView1;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mViewHolderOnClickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public SpotItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private SpotItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[2]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.TextView) bindings[1];
        this.mboundView1.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewHolder == variableId) {
            setViewHolder((com.univ_amu.localizcci.ui.SpotListAdapter.ViewHolder) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewHolder(@Nullable com.univ_amu.localizcci.ui.SpotListAdapter.ViewHolder ViewHolder) {
        this.mViewHolder = ViewHolder;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.viewHolder);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String viewHolderSpotName = null;
        android.view.View.OnClickListener viewHolderOnClickAndroidViewViewOnClickListener = null;
        com.univ_amu.localizcci.ui.SpotListAdapter.ViewHolder viewHolder = mViewHolder;
        com.univ_amu.localizcci.data.Spot viewHolderSpot = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (viewHolder != null) {
                    // read viewHolder::onClick
                    viewHolderOnClickAndroidViewViewOnClickListener = (((mViewHolderOnClickAndroidViewViewOnClickListener == null) ? (mViewHolderOnClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mViewHolderOnClickAndroidViewViewOnClickListener).setValue(viewHolder));
                    // read viewHolder.spot
                    viewHolderSpot = viewHolder.spot;
                }


                if (viewHolderSpot != null) {
                    // read viewHolder.spot.name
                    viewHolderSpotName = viewHolderSpot.name;
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(viewHolderOnClickAndroidViewViewOnClickListener);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, viewHolderSpotName);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.univ_amu.localizcci.ui.SpotListAdapter.ViewHolder value;
        public OnClickListenerImpl setValue(com.univ_amu.localizcci.ui.SpotListAdapter.ViewHolder value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onClick(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewHolder
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}