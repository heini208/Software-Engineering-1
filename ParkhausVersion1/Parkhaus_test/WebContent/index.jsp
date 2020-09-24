
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
 	Max="105"
 	
 	open_from= "0"
  	open_to = "24"
  	delay = "100"
  	simulation_speed =  "10"
  	license_max = "200"
 	
    extra_buttons='["sum","avg","tavg","count","nextday"]' 
 	extra_charts='["chart","ClientCountChart","belegtProzentChart"]'
 	
 	vehicle_types='["PKW", "PKW","PKW","PKW","PKW","PKW", "PKW","PKW","PKW","PKW","PKW","SUV", "SUV","Pickup","Pickup", "Motorrad","Motorrad","Motorrad", "Trike", "Quad"]'
 	client_categories='["Behinderung","Frau","Frau","Frau","Frau","Frau","Frau","Frau","Familie","Any","Any","Any","Any","Any","Any","Any","Any","Any","Any","Any"]' 
 	price_factor= '{
    "Familie": 0.8,
    "Behinderung": 0.5}'
    
     images='{
     "car": "https://i.ibb.co/ZLwY21h/car.png",
     "parking_garage": "https://i.ibb.co/2sqCQYh/Parkhaus-Sign.png",
    "empty": "https://i.ibb.co/WksVmPV/Parkplatz.png"
    }'
  
 	
 >
 </ccm-parkhaus-9-1-7>
  <p style="text-align:center;">By Samira, Dennis, Marcel</p>
</body>
</html>