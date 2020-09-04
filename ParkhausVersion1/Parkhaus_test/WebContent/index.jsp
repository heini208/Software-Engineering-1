
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
 <title>Tomcat Parkhaus</title>
 
 <script src='https://ccmjs.github.io/mkaul-components/parkhaus/versions/ccm.parkhaus-9.1.7.js'></script>
 
</head>
<body>
 <h1>Tomcat Parkhaus 9.1.7</h1>
 <ccm-parkhaus-9-1-7 
 	key='{"price_factor":{"Behinderung":"0","Familie":"0"}}'
 	server_url="http://localhost:8080/Parkhaus_test/DemoServlet"
 	Max="100"
 	
 	open_from= "0"
  	open_to = "24"
  	delay = "100"
  	simulation_speed =  "10"
  
    
 	
    extra_buttons='["sum","avg","tavg","count"]' 
 	extra_charts='["chart"]'
 	
 	client_categories='["Behinderung","Frau","Familie","Normal","Normal","Normal","Normal","Normal","Normal","Normal","Normal","Normal","Normal","Normal","Normal","Normal","Normal","Normal","Normal","Normal"]' 
 	price_factor= '{
    "Familie": 0.8,
    "Behinderung": 0.5}'
    
  
 	
 >
 </ccm-parkhaus-9-1-7>
</body>
</html>
