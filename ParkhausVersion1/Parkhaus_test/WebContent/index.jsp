
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<header>
 <h1 style="text-align:center;">Parkhaus Simulation</h1>

 
 
 <script src='https://ccmjs.github.io/mkaul-components/parkhaus/versions/ccm.parkhaus-9.1.7.js'></script>
 
</header>
<body style="margin-left: 30px;background-color:white;">
 <h1>Tomcat Parkhaus 9.1.7</h1>
 <ccm-parkhaus-9-1-7 
 	
 	server_url="http://localhost:8080/Parkhaus_test/DemoServlet"
 	Max="100"
 	
 	open_from= "0"
  	open_to = "24"
  	delay = "100"
  	simulation_speed =  "10"
  	license_max = "100"
    
 	
    extra_buttons='["sum","avg","tavg","count"]' 
 	extra_charts='["chart","ClientCountChart","belegtProzentChart"]'
 	
 	vehicle_types='["PKW", "PKW","PKW","PKW","PKW","PKW", "PKW","PKW","PKW","PKW","PKW","SUV", "SUV","Pickup","Pickup", "Motorrad","Motorrad","Motorrad", "Trike", "Quad"]'
 	client_categories='["Behinderung","Frau","Frau","Frau","Frau","Frau","Frau","Frau","Familie","Any","Any","Any","Any","Any","Any","Any","Any","Any","Any","Any"]' 
 	price_factor= '{
    "Familie": 0.8,
    "Behinderung": 0.5}'
    
     images='{
     "car": "https://creazilla-store.fra1.digitaloceanspaces.com/cliparts/68966/retro-car-icon-clipart-md.png",
     "parking_garage": "https://banner2.cleanpng.com/20180421/qze/kisspng-disabled-parking-permit-car-park-sign-disability-car-parking-5adbcef567ba58.5581114815243548054249.jpg",
    "empty": "https://cdn.iconscout.com/icon/free/png-512/road-327-449812.png"
    }'
  
 	
 >
 </ccm-parkhaus-9-1-7>
  <p style="text-align:center;">By Samira, Dennis, Marcel</p>
</body>
</html>