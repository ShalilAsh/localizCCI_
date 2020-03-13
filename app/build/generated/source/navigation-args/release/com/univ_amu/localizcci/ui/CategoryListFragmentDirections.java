package com.univ_amu.localizcci.ui;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.univ_amu.localizcci.R;

public class CategoryListFragmentDirections {
  private CategoryListFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionCategoryListToSpotList() {
    return new ActionOnlyNavDirections(R.id.action_categoryList_to_spotList);
  }
}
