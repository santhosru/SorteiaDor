$(document).ready(function () {
        $("#btnSortear").click(enviar);

        function enviar () {
            let quantityN = parseInt($("#quantity").val());
            let minN = parseInt($("#minNumber").val());
            let maxN = parseInt($("#maxNumber").val());
            let checkedBox = $("#chk-order-by")[0].checked;
            let checkedBox2 = $("#chk-repeat-result")[0].checked;

            if (!checkedBox2 && quantityN > maxN) {
                alert("Falha na comunicação com o servidor");
            } else {
                $.ajax({
                       type: "POST",
                       url: "/paginaResultado",
                       data: { quantityNumbers: quantityN,
                       minNumber: minN,
                       maxNumber: maxN,
                       checkBox: checkedBox,
                       checkBox2: checkedBox2,
                       },
                        success: function (data) {
                             $("html").html(data);
                             $("#btnSortear").click(enviar);
                             history.pushState(null, null, "/paginaResultado");
                        },
                        error: function (data) {
                                alert("Falha na comunicação com o servidor");
                        }
                });
            }
        };
    });