var activeBox = 0;

function resize() {
    $('.section').each(function (index) {
        if (index === activeBox) {
            console.log($(this).css('height') + ' box:' + index)

            var height = parseFloat($(this).css('height').replace("px", "")) + 200
            $('.config .box').css("height", height + "px")
            $('.config .box form').css("height", height + "px")
        }
    })

}



function validar() {
    var validado = true
    $('.section').each(function () {
        if ($(this).css('opacity') === '1') {
            $(this).find('.group').each(function () {
                $(this).find('.multiselect').each(function () {
                    console.log('achou')
                    var none = true
                    $(this).find('.selected').each(function () {
                        if ($(this).css('display') !== 'none')
                            none = false
                    })

                    if (none) {
                        validado = false
                        $(this).parent().find('.empty').show()
                    } else
                        $(this).parent().find('.empty').hide()
                })
            })

            $(this).find('input').each(function (index) {
                if (!$(this).hasClass('multisearch')) {


                    if (!$(this).val()) {
                        validado = false
                        $(this).parent().find('.empty').show()
                    } else {
                        $(this).parent().find('.empty').hide()

                    }
                }
            })
            $(this).find('textarea').each(function (index) {
                if (!$(this).val()) {
                    validado = false
                    $(this).parent().find('.empty').show()
                } else {
                    $(this).parent().find('.empty').hide()

                }
            })
            $(this).find('select').each(function (index) {
                if (!$(this).val()) {
                    validado = false
                    $(this).parent().find('.empty').show()
                } else {
                    $(this).parent().find('.empty').hide()

                }
            })
        }
    })


    resize()
    console.log(validado)
    return validado

}

$(document).ready(function () {


    $(".group").append('<span class="empty"> <i class="fas fa-exclamation-circle"></i> Esse campo não pode ficar vazio</span>')
    $(".group").append('<span class="wrong"> <i class="fas fa-exclamation-circle"></i> Insira o dado corretamente</span>')
    $('.wrong').hide()
    $('.empty').hide()

    $('.section').each(function (index) {
        var margin = 500 * index
        $(this).css("margin-left", margin)

        if (index === 0) {
            $(this).css("opacity", '1')
            $(this).css("z-index", '2')

        }

    })


    $(window).resize(function () {
        resize()
    });
    var sections = $('.section').length

    $('span').each(function () {
        if ($(this).text() === 'Anterior') {
            $(this).hide()
            $('input.blue').hide()

        }
    })
    $('.modal-body .message span').click(function () {
        $('.modal-body').toggleClass('on')
    })

    $('.sign button').click(function () {
        $('.modal-body').addClass('on')
    })

    $('.sign-button').click(function () {
        $('.modal-body').removeClass('on')
    })

    $('span').click(function () {
        resize()
    })
    $('span').click(function () {
        var active = 0
        var aux = 0

        if ($(this).text() === 'Próximo') {
            aux = 1
            if (!validar())
                return
        } else if ($(this).text() === 'Anterior')
            aux = -1
        else
            return
        activeBox = activeBox + aux
        $('.section').each(function (index) {
            if ($(this).css("opacity") == 1) {
                $(this).css("opacity", 0)
                $(this).css("z-index", '1')
                const width = 500 * aux * -1
                $(this).css("margin-left", width + 'px')
                active = index
            }


        })

        $('.section').each(function (index) {

            if (index === active + aux) {
                $(this).css("opacity", 1)
                resize()
                $(this).css("margin-left", '0')
                $(this).css("z-index", '2')
                resize()

                $('span').each(function () {
                    if ($(this).text() === 'Próximo') {
                        if (active + aux === sections - 1) {
                            $(this).hide()
                            $('input.blue').show()
                        } else {
                            $(this).show()
                            $('input.blue').hide()
                        }
                    }

                    if ($(this).text() === 'Anterior') {
                        if (active + aux === 0)
                            $(this).hide()
                        else
                            $(this).show()


                    }
                })
            }




        })
        $('input.blue').click(function () {
            validar()

        })

    })
})
