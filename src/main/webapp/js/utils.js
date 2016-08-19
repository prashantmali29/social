/*//UTILITY

//to display image immediately after choose, used in change_profile_pic and add_illustration
function readURL(input) {
    for (var i=0;i< input.files.length;i++) {
    var reader = new FileReader();
    reader.onload = function (e) {
        $('.imgClass')
        .attr('src', e.target.result)
        .width(250)
        .height(200);
    };

    reader.readAsDataURL(input.files[i]);
    }
}

//jquery for bootstrap tooltip
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();
});

// Wait for window load
$(window).load(function() {
    // Animate loader off screen
    $(".se-pre-con").fadeOut("slow");
});*/