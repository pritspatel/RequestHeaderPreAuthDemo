#Request Header PreAuth Filter Demo

### Description
This project demonstrate how to use ```RequestHeaderAuthenticationFilter``` from spring security. This is helpful
when in big organization where SSO is used and some external common system does authentication and redirects
user with some request headers back to their application. In such scenario you will have user information in
request headers and based on that you would like to do authorization for your application. 


### Prerequisite

You need to install chrome plugin ```Modify Headers``` which will allow you to insert headers to your
application url as if it was sent by your other application which does the authentication for eg. site minder


### How to Test this app

1. Run the app in tomcat(Can be deployed in any servlet container).
2. Setup request header name-value in chrome's Modify Header plugin
3. Access http://localhost:8090/api/hello