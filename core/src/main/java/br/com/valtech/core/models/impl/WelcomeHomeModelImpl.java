package br.com.valtech.core.models.impl;

import br.com.valtech.core.models.ButtonModel;
import br.com.valtech.core.models.WelcomeHomeModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;

import lombok.Getter;

@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = { WelcomeHomeModel.class, ComponentExporter.class},
        resourceType = WelcomeHomeModelImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(
        name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
        extensions = ExporterConstants.SLING_MODEL_EXTENSION)
@Getter
public class WelcomeHomeModelImpl implements WelcomeHomeModel {

    static final String RESOURCE_TYPE = "valtech/components/welcomehome";

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String description;

    @ValueMapValue
    private String imgReference;
    
    @ValueMapValue
    private String imgAlt;

    @ChildResource
    private ButtonModel buttonCTA;

    @ValueMapValue
    private Boolean swapColumns;

    @Override
    public String getExportedType() {
        return WelcomeHomeModelImpl.RESOURCE_TYPE;
    }

}
