(function (document, $) {
    $(document).on("foundation-contentloaded", function (e) {
      $(".limited-multifield-items").each(function () {
        const limit = parseInt(
          $(this)
            .attr("class")
            .match(/limit-.*? /)[0]
            .replace("limit-", "")
            .replace(" ", "")
        );
  
        const multifieldSize = $(".limited-multifield-items > coral-multifield-item").length;
        const button = $(".limited-multifield-items > [coral-multifield-add]");
        multifieldSize < limit ?  button.show() : button.hide();
      });
  
      $(document).on("change", "coral-multifield", function (e) {
        const multifields = document.querySelectorAll(
          ".limited-multifield-items"
        );
        multifields.forEach((item) => {
          const items = item.querySelectorAll("coral-multifield-item");
          const arr = Array.from(item.classList);
          const arrLimit = arr.filter((name) => name.includes("limit-"));
          const btn = item.querySelector(".limited-multifield-items > [coral-multifield-add]");
  
          if (arrLimit.length > 0) {
            const limit = arrLimit[0].replace("limit-", "");
            setTimeout(() => {
              if (items.length == limit) {
                btn.style.display = "none";
              } else if (items.length < parseInt(limit)) {
                btn.style.display = "block";
              }
            }, 100);
          }
        });
      });
    });
  })(document, Granite.$);