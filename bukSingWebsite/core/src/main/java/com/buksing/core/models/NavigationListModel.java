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

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Model(adaptables=Resource.class)
public class NavigationListModel {

  private List <NavigationLinkModel> links;

  @Inject
  public ResourceResolver resourceResolver;

  private String parentPath = "/content/bukSingWebsite/en"; 

  @PostConstruct
  protected void init() {
    Resource parentPage = resourceResolver.getResource(parentPath);

    links = new ArrayList<NavigationLinkModel>();

    populateLinks(this.parentPath, resourceResolver, links);
  }

  protected List <NavigationLinkModel> populateLinks(String parentPath, ResourceResolver resourceResolver,
                                                     List <NavigationLinkModel> links) {
    
    PageManager parentPageManager = resourceResolver.adaptTo(PageManager.class);

    Page parentPage = parentPageManager.getContainingPage(parentPath);

    Iterator<Page> children = parentPage.listChildren();

    //foreach child page, create a new navigationlink model and put it in our array.
    while( children.hasNext() ) {
      NavigationLinkModel link = children.next().adaptTo(NavigationLinkModel.class);
      links.add(link);
    }

    //for each top level page, populate the list of NavigationLinkModel objects for us and return them.
    return links; 
  }

}
