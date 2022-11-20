$(document).ready(function () {
    $('a[href=catalogue]').on('click', function (event) {
        event.preventDefault();
        console.log($('body').children().length);

        if ($('body').children().length<6) {
            $.ajax({
                url: "http://localhost:8080/services/rest/work",
                success: function (resultObject) {
                    var message = resultObject[0].title+"("+resultObject[0].release+")".concat("</br>");
                    message = message.concat(resultObject[1].title+"("+resultObject[1].release+")").concat("</br>");
                    message = message.concat(resultObject[2].title+"("+resultObject[2].release+")");
                    $("a[href= catalogue]").after('<br>'+message);
                }
            });
        }
    });
});