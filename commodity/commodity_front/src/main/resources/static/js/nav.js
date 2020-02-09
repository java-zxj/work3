var isLogin=false;

$(function () {
    var v_navHtml = "<nav class=\"navbar navbar-inverse\">\n" +
        "    <div class=\"container-fluid\">\n" +
        "        <!-- Brand and toggle get grouped for better mobile display -->\n" +
        "        <div class=\"navbar-header\">\n" +
        "           <ul> <li><a class=\"navbar-brand\" href='/'>飞狐电商前台666</a></li></ul>\n" +
        "        </div>\n" +
        "\n" +
        "        <!-- Collect the nav links, forms, and other content for toggling -->\n" +
        "        <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">" +
        "            <ul class=\"nav navbar-nav navbar-right\" id='nav_ul'>" +
        "                <li id=\"loginInfo\"><a href=\"/login.html\">登录</a></li>" +
        "                <li><a href=\"/reg.html\">注册</a></li>" +
        "                <li><a href=\"/cart.html\">购物车</a></li>" +
        "            </ul>\n" +
        "        </div><!-- /.navbar-collapse -->\n" +
        "    </div><!-- /.container-fluid -->\n" +
        "</nav>";

    $("#navDiv").html(v_navHtml);


    $.ajaxSetup({
        beforeSend: function(xhr) {
            var token = window.localStorage.getItem("token");
            console.log("token:"+token);
            xhr.setRequestHeader("x-auth", token);
        }

    })

    $.ajax({
        url:"http://localhost:8081/user/getMember",
        async:false,
        success:function (result) {
            if (result.status == 200) {
                isLogin = true;
                $("#loginInfo").html("<a>欢迎"+result.data+"登录！！！</a><a href='#' onclick='logout();'>退出</a>")
            }
            /*if(isLogin){
                $.post(
                    "http://localhost:8006/pay/createNative",
                    function(res){
                        if(res.status==200){

                        }
                    }
                )
            }*/
        }

    })

})

//加入购物车的方法
function buy(bookId,count,flag) {
    //alert(bookId);
    $.post(
        "http://localhost:8081/carts/add",
        {"bookId":bookId,"count":count},
        function (data) {
            if(data.status==200){
                if(flag==1){
                    location.href="/cart.html"
                }else {
                    initCart()
                }
            }else{
                alert(data.msg);
            }
        }
    )
}

function logout() {
    $.post(
        "http://localhost:8017/api-cart/carts/loginOut",
        function (result) {
            if(result.status==200){
                window.localStorage.setItem("token","");
                location.href="index.html";
            }

        }
    )

}










