/* global jQuery, Coral */
(function ($, Coral) {
  "use strict";

  var registry = $(window).adaptTo("foundation-registry");

  registry.register("foundation.validation.validator", {
    selector: "[data-validation=data-context]",
    validate: function (element) {
      let el = $(element);
      let value = el.val();

      let normalizedValue = value
        .normalize("NFD")
        .replace(/[\u0300-\u036f\s`´'!@#$%^&*()\=+[{\]};~:'",<.>/?\\|]/g, "");
      if (normalizedValue !== value) {
        return "Please remove accents and blank spaces from the input.";
      }
    },
  });
})(jQuery, Coral);
