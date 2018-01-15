 
package com.buksing.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.settings.SlingSettingsService;

import com.buksing.core.models.NavigationLinkModel;

import java.util.List;

@Model(adaptables=Resource.class)
public class NavigationListModel {

  protected void init() {

  }

}
