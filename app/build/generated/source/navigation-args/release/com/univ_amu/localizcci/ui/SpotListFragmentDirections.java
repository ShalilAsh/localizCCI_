package com.univ_amu.localizcci.ui;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.univ_amu.localizcci.R;

public class SpotListFragmentDirections {
  private SpotListFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSpotListToSpot() {
    return new ActionOnlyNavDirections(R.id.action_spotList_to_spot);
  }
}
