<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
 <title>Tomcat Parkhaus</title>
 <script src="https://ccmjs.github.io/mkaul-components/parkhaus/versions/ccm.parkhaus-7.0.0.js"></script>
 
</head>
<body>
 <h1>Tomcat Parkhaus 7.0.0</h1>
 <ccm-parkhaus-7-0-0 
 	server_url="http://localhost:8080/Parkhaus_Server_Test/DemoServlet"
 	Max="10"
 	simulation.max="3"
 	
    extra_buttons='["sum","avg","tavg","count"]' 
 	extra_charts='["chart"]'
 >
 </ccm-parkhaus-7-0-0>
</body>
</html>
