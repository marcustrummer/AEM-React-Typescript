(function (document, $) { 
    $(document).on("foundation-contentloaded", function (e) {
      checkboxShowHideHandler($(".cq-dialog-checkbox-showhide", e.target));
    });
    $(document).on("change", ".cq-dialog-checkbox-showhide", function (e) {
      checkboxShowHideHandler($(this));
    });
    function checkboxShowHideHandler(el) {
      el.each(function (i, element) {
        if ($(element).is("coral-checkbox")) {
          Coral.commons.ready(element, function (component) {
            showHide(component, element);
            component.on("change", function () {
              showHide(component, element);
            });
          });
        } else {
          let component = $(element).data("checkbox");
          if (component) {
            showHide(component, element);
          }
        }
      });
    }
  
    function clearField(elements) {
      if (elements?.length > 0) {
        elements.forEach((element) => element.click());
      }
    }
    function clearCheckbox(node, element) {
      node.style.display = "none";
      if (!element.required) {
        let inputs = node.querySelectorAll("input");
        let buttonsClear = node.querySelectorAll(".cq-FileUpload-clear");
        let buttonsRemove = node.querySelectorAll("._coral-Multifield-remove");
        inputs.forEach((input) => (input.value = ""));
        clearField(buttonsClear);
        clearField(buttonsRemove);
      }
    }
    function showHide(component, element) {
      let node = element.parentNode.querySelector(".parent-field");
      let nodeAux = element.parentNode.parentNode.querySelector(".parent-field"); // need when use a description in field
      if (!element.checked) {
        if (node !== null) {
          clearCheckbox(node, element);
        } else if (nodeAux !== null) {
          clearCheckbox(nodeAux, element);
        }
      }
  
      element.addEventListener("click", function (e) {
        if (!element.checked) {
          if (node !== null) {
            node.style.display = "block";
          } else if (nodeAux !== null) {
            nodeAux.style.display = "block";
          }
        }
      });
    }
  })(document, Granite.$);
  