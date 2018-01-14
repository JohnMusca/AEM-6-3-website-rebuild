package com.buksing.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.settings.SlingSettingsService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.wcm.api.Page
import org.apache.sling.api.SlingHttpServletRequest;

@Model(adaptables = Resource.class)
public class NavigationModel {

    public java.util.List<link> links;

    @Inject
    private ResourceResolver resourceResolver;

    @Inject
    @Named("staticList")
    private Resource linksResource;

    protected void init() {
    }

    

}
