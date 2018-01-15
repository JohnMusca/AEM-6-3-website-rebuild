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

@Model(adaptables=Resource.class)
public class NavigationLinkModel {

  @Inject
  private ResourceResolver resourceResolver;

  @Inject 
  private String pagePath;

  private String navigationText;

  private String navigationLink;

  @PostConstruct
  protected void init() {
    if(resourceResolver != null) {
      
      PageManager pageManager = resourceResolver.adaptTo(PageManager.class);

      Page page = pageManager.getPage(pagePath);

      this.setNavigationText(page.getName());
      this.setNavigationLink(page.getPath());
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
