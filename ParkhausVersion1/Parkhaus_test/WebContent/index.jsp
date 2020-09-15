
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<header>
 <h1 style="text-align:center;">Parkhaus Simulation</h1>

 
 
 <script src='https://ccmjs.github.io/mkaul-components/parkhaus/versions/ccm.parkhaus-9.1.7.js'></script>
 
</header>
<body style="margin-left: 30px;">
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
 	extra_charts='["chart","familiechart","belegtProzentChart"]'
 	
 	vehicle_types='["PKW", "PKW","PKW","PKW","PKW","PKW", "PKW","PKW","PKW","PKW","PKW","SUV", "SUV","Pickup","Pickup", "Motorrad","Motorrad","Motorrad", "Trike", "Quad"]'
 	client_categories='["Behinderung","Frau","Frau","Frau","Frau","Frau","Frau","Frau","Familie","Any","Any","Any","Any","Any","Any","Any","Any","Any","Any","Any"]' 
 	price_factor= '{
    "Familie": 0.8,
    "Behinderung": 0.5}'
    
  
 	
 >
 </ccm-parkhaus-9-1-7>
  <p style="text-align:center;">By Samira, Dennis, Marcel</p>
</body>
</html>