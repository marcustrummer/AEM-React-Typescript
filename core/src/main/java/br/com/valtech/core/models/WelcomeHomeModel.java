package br.com.valtech.core.models;

import com.adobe.cq.export.json.ComponentExporter;

public interface WelcomeHomeModel extends ComponentExporter {
    
    String getTitle();

    String getDescription();

    ButtonModel getButtonCTA();

    String getImgReference();

    String getImgAlt();

    Boolean getSwapColumns();
}
