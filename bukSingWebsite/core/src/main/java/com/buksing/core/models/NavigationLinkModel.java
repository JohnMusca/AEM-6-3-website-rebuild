package com.buksing.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.settings.SlingSettingsService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

import com.buksing.core.models.NavigationLinkModelInterface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables=Resource.class)
public class NavigationLinkModel implements NavigationLinkModelInterface{

  private final Logger log = LoggerFactory.getLogger(this.getClass());

  @Inject
  private ResourceResolver resourceResolver;

  @Inject 
  @Named("jcr:title")
  private String navigationText;

  @Inject
  private String path;

  public String getNavigationText() {
    return navigationText;
  }

  public String getNavigationLink() {
    return "test";
    //return path;
  }

}
