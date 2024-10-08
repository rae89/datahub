package com.linkedin.gms.factory.common;

import com.linkedin.metadata.utils.elasticsearch.IndexConvention;
import com.linkedin.metadata.utils.elasticsearch.IndexConventionImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Creates a {@link IndexConvention} to generate search index names.
 *
 * <p>This allows you to easily add prefixes to the index names.
 */
@Configuration
public class IndexConventionFactory {
  public static final String INDEX_CONVENTION_BEAN = "searchIndexConvention";

  @Value("${elasticsearch.index.prefix:}")
  private String indexPrefix;

  @Bean(name = INDEX_CONVENTION_BEAN)
  protected IndexConvention createInstance(
      @Value("${elasticsearch.idHashAlgo}") final String isHashAlgo) {
    return new IndexConventionImpl(indexPrefix, isHashAlgo);
  }
}
