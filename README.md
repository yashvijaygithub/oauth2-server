# oauth2-server
<b>Springboot oauth2 server with Postgresql and BCryptPasswordEncoder.<b>

The application is started on the Tomcat port 8080.

http://localhost:8080/oauth/token

Now, add the Request Headers as follows −
Authorization − Basic Auth with your Client Id and Client secret.
Content Type − application/x-www-form-urlencoded

Now, add the Request Parameters as follows −

grant_type = password<br>
username = your username<br>
password = your password<br>

Now, hit the API and get the access_token

http://localhost:8080/products <br>
Authorization - Bearer <access_token>

Use grant_type = client_credentials <br>
To access all the api's once logged-in successfully

Enjoy :)
