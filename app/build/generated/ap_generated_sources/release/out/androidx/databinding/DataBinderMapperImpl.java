package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.univ_amu.localizcci.DataBinderMapperImpl());
  }
}
