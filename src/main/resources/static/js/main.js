$(document).ready(function () {
    var acc = document.getElementsByClassName("accordion");

    var i;

    for (i = 0; i < acc.length; i++) {
        acc[i].addEventListener("click", function () {
            this.classList.toggle("active");
            var panel = this.nextElementSibling;
            if (panel.style.maxHeight) {
                panel.style.maxHeight = null;
            } else {
                panel.style.maxHeight = panel.scrollHeight + "px";
            }
        });
    }
});

$("form#data").submit(function(e) {
    e.preventDefault();
    var formData = new FormData(this);

    $.post($(this).attr("action"), formData, function(data) {
        alert(data);
    });
});

function readUrl(input) {

    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            var imgData = e.target.result;
            var imgName = input.files[0].name;
            input.setAttribute("data-title", imgName);
            console.log(e.target.result);
        };
        reader.readAsDataURL(input.files[0]);
    }
}