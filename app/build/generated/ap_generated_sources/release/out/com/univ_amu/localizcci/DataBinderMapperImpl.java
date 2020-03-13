package com.univ_amu.localizcci;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.univ_amu.localizcci.databinding.ActivityMainBindingImpl;
import com.univ_amu.localizcci.databinding.CategoryItemBindingImpl;
import com.univ_amu.localizcci.databinding.FragmentCategoryBindingImpl;
import com.univ_amu.localizcci.databinding.FragmentCategoryListBindingImpl;
import com.univ_amu.localizcci.databinding.FragmentSpotBindingImpl;
import com.univ_amu.localizcci.databinding.FragmentSpotListBindingImpl;
import com.univ_amu.localizcci.databinding.SpotItemBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_CATEGORYITEM = 2;

  private static final int LAYOUT_FRAGMENTCATEGORY = 3;

  private static final int LAYOUT_FRAGMENTCATEGORYLIST = 4;

  private static final int LAYOUT_FRAGMENTSPOT = 5;

  private static final int LAYOUT_FRAGMENTSPOTLIST = 6;

  private static final int LAYOUT_SPOTITEM = 7;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(7);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.univ_amu.localizcci.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.univ_amu.localizcci.R.layout.category_item, LAYOUT_CATEGORYITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.univ_amu.localizcci.R.layout.fragment_category, LAYOUT_FRAGMENTCATEGORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.univ_amu.localizcci.R.layout.fragment_category_list, LAYOUT_FRAGMENTCATEGORYLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.univ_amu.localizcci.R.layout.fragment_spot, LAYOUT_FRAGMENTSPOT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.univ_amu.localizcci.R.layout.fragment_spot_list, LAYOUT_FRAGMENTSPOTLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.univ_amu.localizcci.R.layout.spot_item, LAYOUT_SPOTITEM);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_CATEGORYITEM: {
          if ("layout/category_item_0".equals(tag)) {
            return new CategoryItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for category_item is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCATEGORY: {
          if ("layout/fragment_category_0".equals(tag)) {
            return new FragmentCategoryBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_category is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCATEGORYLIST: {
          if ("layout/fragment_category_list_0".equals(tag)) {
            return new FragmentCategoryListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_category_list is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSPOT: {
          if ("layout/fragment_spot_0".equals(tag)) {
            return new FragmentSpotBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_spot is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSPOTLIST: {
          if ("layout/fragment_spot_list_0".equals(tag)) {
            return new FragmentSpotListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_spot_list is invalid. Received: " + tag);
        }
        case  LAYOUT_SPOTITEM: {
          if ("layout/spot_item_0".equals(tag)) {
            return new SpotItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for spot_item is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(5);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "viewHolder");
      sKeys.put(2, "spot");
      sKeys.put(3, "category");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(7);

    static {
      sKeys.put("layout/activity_main_0", com.univ_amu.localizcci.R.layout.activity_main);
      sKeys.put("layout/category_item_0", com.univ_amu.localizcci.R.layout.category_item);
      sKeys.put("layout/fragment_category_0", com.univ_amu.localizcci.R.layout.fragment_category);
      sKeys.put("layout/fragment_category_list_0", com.univ_amu.localizcci.R.layout.fragment_category_list);
      sKeys.put("layout/fragment_spot_0", com.univ_amu.localizcci.R.layout.fragment_spot);
      sKeys.put("layout/fragment_spot_list_0", com.univ_amu.localizcci.R.layout.fragment_spot_list);
      sKeys.put("layout/spot_item_0", com.univ_amu.localizcci.R.layout.spot_item);
    }
  }
}
