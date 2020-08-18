var habilities = [
"Javascript", "React", "Node.js", "Java (Android)", "Java", "AWS Elastic Beanstalk", "AWS", "Totvs", "ExpressJS", "Bdd", "AdonisJS", "Delphi", "Spring Boot", "BigData", "DJango", "Data Mining", "C#", "Python", "EJB", "Haskell", "Backbone.js", "Programação orientada a Objeto", "Governança de TI", "Testes Funcionais", "Ajax", "C", "Scala", "PostgreSQL", "Design Responsivo", "Polymer", "Testes automatizados", "WebGL", "Media Services", "Bower", "Perl", "Ember.js", "Hibernate", "Fortran", "Dart", "Unity",
];

habilities.sort()

function multisearch(habilities) {

    habilities.forEach(function (item, id) {
        $(".dropdown-menu").append(
            '<div class="dropdown-item" id="drop' + id + '">' + item + '</div>'
        )
        $(".multiselect").prepend(
            '<span id="span' + id + '" class="selected">' + item + '  <i class="fas fa-times"></i></span>'
        )
    })
    $('.selected').hide()
    $('.multisearch').on('input', function () {
        var str = $(this).val().toLowerCase()
        var none = true
        $(".dropdown-item").each(function (index) {

            if ($(this).text().toLowerCase().includes(str)) {
                $(this).show()
                none = false
            } else
                $(this).hide()
        })

        if (none)
            $('.dropdown-menu span').show()
        else
            $('.dropdown-menu span').hide()
        
    });
}

$(document).ready(function () {
    $(".multisearch").attr("readonly", false);

    $('.dropdown-item').click(function () {
        const str = $(this).attr('id').substring(4)
        $(this).addClass("disabled")
        $("#span" + str).show()
    })
    $('.multiselect .selected i').click(function () {
        const str = $(this).parent().attr('id').substring(4)

        $("#drop" + str).removeClass("disabled")
        $(this).parent().hide();
    })
    $('.multisearch').click(function () {
        $(this).focus();
        $(this).attr("readonly", false);

    })

});

multisearch(habilities)
