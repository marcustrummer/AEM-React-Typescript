(function ($, $document) {
    "use strict";
 
    $.validator.register("foundation.validation.validator", {
        selector: "coral-multifield",
        validate: function(el) {
            const totalPanels = el["0"].items.getAll().length;
            let min, max;
            if ($(el).data("min-item")){
                min = $(el).data("min-item");
                if(totalPanels < min) {
                    return `Mínimo de ${min} itens não atingido`;
                }
            }
            if ($(el).data("max-item")){
                max = $(el).data("max-item");
                if(totalPanels > max) {
                    return `Máximo de ${max} itens atingidos`;
                }
            }
        }});
})($, $(document));