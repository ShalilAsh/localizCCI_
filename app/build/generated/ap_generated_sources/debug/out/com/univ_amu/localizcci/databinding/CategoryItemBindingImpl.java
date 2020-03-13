package com.univ_amu.localizcci.databinding;
import com.univ_amu.localizcci.R;
import com.univ_amu.localizcci.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class CategoryItemBindingImpl extends CategoryItemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mViewHolderOnClickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public CategoryItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private CategoryItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[2]
            , (android.widget.ImageView) bindings[1]
            );
        this.categoryDescription.setTag(null);
        this.categoryName.setTag(null);
        this.imgcat.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
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
            setViewHolder((com.univ_amu.localizcci.ui.CategoryListAdapter.ViewHolder) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewHolder(@Nullable com.univ_amu.localizcci.ui.CategoryListAdapter.ViewHolder ViewHolder) {
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
        java.lang.String viewHolderCategoryDescription = null;
        com.univ_amu.localizcci.data.Category viewHolderCategory = null;
        int viewHolderCategoryImgid = 0;
        android.view.View.OnClickListener viewHolderOnClickAndroidViewViewOnClickListener = null;
        com.univ_amu.localizcci.ui.CategoryListAdapter.ViewHolder viewHolder = mViewHolder;
        java.lang.String viewHolderCategoryName = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (viewHolder != null) {
                    // read viewHolder.category
                    viewHolderCategory = viewHolder.category;
                    // read viewHolder::onClick
                    viewHolderOnClickAndroidViewViewOnClickListener = (((mViewHolderOnClickAndroidViewViewOnClickListener == null) ? (mViewHolderOnClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mViewHolderOnClickAndroidViewViewOnClickListener).setValue(viewHolder));
                }


                if (viewHolderCategory != null) {
                    // read viewHolder.category.description
                    viewHolderCategoryDescription = viewHolderCategory.description;
                    // read viewHolder.category.imgid
                    viewHolderCategoryImgid = viewHolderCategory.imgid;
                    // read viewHolder.category.name
                    viewHolderCategoryName = viewHolderCategory.name;
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.categoryDescription, viewHolderCategoryDescription);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.categoryName, viewHolderCategoryName);
            androidx.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.imgcat, androidx.databinding.adapters.Converters.convertColorToDrawable(viewHolderCategoryImgid));
            this.mboundView0.setOnClickListener(viewHolderOnClickAndroidViewViewOnClickListener);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.univ_amu.localizcci.ui.CategoryListAdapter.ViewHolder value;
        public OnClickListenerImpl setValue(com.univ_amu.localizcci.ui.CategoryListAdapter.ViewHolder value) {
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