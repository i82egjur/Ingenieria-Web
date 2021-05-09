<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import= "java.io.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Remoraid</title>
        
<!-- 

Sentra Template

https://templatemo.com/tm-518-sentra

-->
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">
		<link href=<%= application.getContextPath()+("/css/bootstrap.min.css") %> type="text/css" rel="stylesheet"/>
		<link href=<%= application.getContextPath()+("/css/bootstrap-theme.min.css") %> type="text/css" rel="stylesheet"/>
		<link href=<%= application.getContextPath()+("/css/fontAwesome.css") %> type="text/css" rel="stylesheet"/>
		<link href=<%= application.getContextPath()+("/css/light-box.css") %> type="text/css" rel="stylesheet"/>
		<link href=<%= application.getContextPath()+("/css/owl-carousel.css") %> type="text/css" rel="stylesheet"/>
		<link href=<%= application.getContextPath()+("/css/templatemo-style.css") %> type="text/css" rel="stylesheet"/>
		
		
		
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/fontAwesome.css">
        <link rel="stylesheet" href="css/light-box.css">
        <link rel="stylesheet" href="css/owl-carousel.css">
        <link rel="stylesheet" href="css/templatemo-style.css">   
        <link rel="shortcut icon" type="image/png" href=<%= application.getContextPath()+("/img/remoraid_logo.png") %>/>

        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">
		<link href=<%= application.getContextPath()+("/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js") %> type="text/css" rel="stylesheet"/>

      
    </head>

<body>



        <header class="nav-down responsive-nav hidden-lg hidden-md">
            <button type="button" id="nav-toggle" class="navbar-toggle" data-toggle="collapse" data-target="#main-nav">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <!--/.navbar-header-->
        </header>

        <div class="sidebar-navigation hidde-sm hidden-xs">
            <div class="logo">
                <a href=<%= application.getContextPath()+("/Vista/login.jsp") %>>Remor<em>aid</em></a> 
            </div>


            <div id="loginBloque">
                   <img id="foto" src=<%= application.getContextPath()+("/img/remoraid_logo.png") %>>
                   
                    <a class="acceder"  style="font-size: 24px; display:inline-block;" href=<%= application.getContextPath()+("/Vista/login.jsp") %>>INICIAR SESIÓN</a> >
            
                    <a class="acceder"  style="font-size: 24px; display:inline-block;" href="<%= application.getContextPath()+("/Vista/registrarUsuario.jsp") %> ">REGISTRARSE</a> 

            </div>

            <ul class="social-icons">
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                <li><a href="#"><i class="fa fa-rss"></i></a></li>
                <li><a href="#"><i class="fa fa-behance"></i></a></li>
            </ul>
        </div>

        <div class="slider">
            <div class="Modern-Slider content-section" id="top">
                <!-- Item -->
                <div class="item item-1">
                    <div class="img-fill">
                    <div class="image"></div>
                    <div class="info">
                        <div>
                          <h1>Te ayudamos a buscar acompañantes</h1>
                          <p>Como saber de todo es imposible, nosotros te ayudamos<br>
                          a suplir las posibles y sabemos que pocas carencias que puedes tener</p>
                      
                        </div>
                        </div>
                    </div>
                </div>
                <!-- // Item -->
                <!-- Item -->
                <div class="item item-2">
                    <div class="img-fill">
                        <div class="image"></div>
                        <div class="info">
                        <div>
                          <h1>Comparte proyectos y busca ayuda</h1>
                          <p>Comparte tus proyectos como el tiburón que <br> eres y encuentra remoras que te ayuden
					
                          
                        
                        </div>
                        </div>
                    </div>
                </div>
                <!-- // Item -->
                <!-- Item -->
                <div class="item item-3">
                    <div class="img-fill">
                        <div class="image"></div>
                        <div class="info">
                        <div>
                          <h1>Da igual cuales sean tus intereses y tus skills</h1>
                          <p>No importa quien seas, ni los estudios que tengas, ni el ámbito profesional<br>
                          en que quieras desarrollarte, en REMORAID te ayudamos con tu propósito</p>
                          
                        
                        </div>
                        </div>
                    </div>
                </div>
                <!-- // Item -->
            </div>
        </div>



     
     <section class="footer">
            <p>Copyright &copy; 2019 Company Name 
            
            . Design: TemplateMo</p>
        </section>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.2.min.js"><\/script>')</script>

    <script src="js/vendor/bootstrap.min.js"></script>
    
    <script src="js/plugins.js"></script>
    <script src="js/main.js"></script>

    <script>
        // Hide Header on on scroll down
        var didScroll;
        var lastScrollTop = 0;
        var delta = 5;
        var navbarHeight = $('header').outerHeight();

        $(window).scroll(function(event){
            didScroll = true;
        });

        setInterval(function() {
            if (didScroll) {
                hasScrolled();
                didScroll = false;
            }
        }, 250);

        function hasScrolled() {
            var st = $(this).scrollTop();
            
            // Make sure they scroll more than delta
            if(Math.abs(lastScrollTop - st) <= delta)
                return;
            
            // If they scrolled down and are past the navbar, add class .nav-up.
            // This is necessary so you never see what is "behind" the navbar.
            if (st > lastScrollTop && st > navbarHeight){
                // Scroll Down
                $('header').removeClass('nav-down').addClass('nav-up');
            } else {
                // Scroll Up
                if(st + $(window).height() < $(document).height()) {
                    $('header').removeClass('nav-up').addClass('nav-down');
                }
            }
            
            lastScrollTop = st;
        }
    </script>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" type="text/javascript"></script>

</body>
</html>