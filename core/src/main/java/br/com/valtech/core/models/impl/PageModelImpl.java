package br.com.valtech.core.models.impl;

import br.com.valtech.core.models.PageModel;
import lombok.Getter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { PageModel.class }, resourceType = {
        PageModelImpl.RESOURCE_TYPE }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Getter
public class PageModelImpl implements PageModel {

    protected static final String RESOURCE_TYPE = "valtech/components/page";

    protected static final String HOME_PATH = "/content/home/jcr:content";

    @SlingObject
    private ResourceResolver resourceResolver;

    @ValueMapValue
    private String startBodyScripts;

    @Override
    public String getStartBodyScripts() {
        Resource homePage = resourceResolver.getResource(HOME_PATH);
        if (homePage != null) {
            return (String) homePage.getValueMap().get("startBodyScripts");
        }
        return "";
    }

}
