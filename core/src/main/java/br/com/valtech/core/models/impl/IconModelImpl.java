package br.com.valtech.core.models.impl;

import br.com.valtech.core.models.IconModel;
import lombok.Getter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adaptables = Resource.class,
        adapters = IconModel.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Getter
public class IconModelImpl implements IconModel {

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String iconReference;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String linkURL;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String linkURLDataContext;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String text;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String iconReferenceDarkTheme;

}
