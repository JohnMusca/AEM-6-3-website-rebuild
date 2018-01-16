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

@Model(adaptables=Resource.class)
public class NavigationLinkModel implements NavigationLinkModelInterface{

  @Inject
  private ResourceResolver resourceResolver;

  private String navigationText;

  private String navigationLink;

  @PostConstruct
  protected void init() {
    if(resourceResolver != null) {
      
      this.setNavigationText(resourceResolver.getName());
      this.setNavigationLink(resourceResolver.getPath());
    }
  }

  private void setNavigationText(String title) {
    this.navigationText = title;
  }

  private void setNavigationLink(String link) {
    this.navigationLink = link;
  }

  public String getNavigationText() {
    return navigationText;
  }

  public String getNavigationLink() {
    return navigationLink;
  }

}
