package com.buksing.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.settings.SlingSettingsService;

import com.buksing.core.models.NavigationLinkModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

@Model(adaptables=Resource.class)
public class NavigationListModel {

  private List <NavigationLinkModel> links;

  @Inject
  public ResourceResolver resourceResolver;
  

  private String parentPath = "/content/bukSingWebsite/en"; 

  @PostConstruct
  protected void init() {
    links = new ArrayList<NavigationLinkModel>();

    populateLinks(this.parentPath, resourceResolver);
  }

  protected List <NavigationLinkModel> populateLinks(String parentPath, ResourceResolver resourceResolver) {
     
    Resource res = resourceResolver.getResource(parentPath);
   
    //for each top level page, populate the list of NavigationLinkModel objects for us and return them.

    return links; 
  }

}
