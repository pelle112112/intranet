# Dokumentation
Dette er min egen dokumentation af Java Webstack.

## Start af et nyt webprojekt

1. Opret nyt projekt i IntelliJ
2. Vælg JavaEE Projekt skabelon 
3. Java + Maven 
4. Servlet Dependencies

![](img/webstart.png)

## Arkitektur

Vi anvender en slags MVC-pattern.
![img.png](img/mvc.png)

- M(odel) - Entiteter og hjælpe- metoder og klasser
- V(iew) - JSP og Frontend (CSS, Bootstrap mm)
- C(ontrol) - Servlets

HUSK! Ingen kommunikation mellem model og view. Gå altid igennem controller.

## Opret Git repo

git init <br/>
git add . <br/>
git commit -m "first commit" <br/>
git remote add origin https://github.com/pelle112112/intranet.git <br/>
git push -u origin main


## Scopes (virkefelter)
- request scope: (gemme objekter): ```` request.setAttribute(Key, value)````
- session scope: (gemme objekter): ```` session.setAttribute(Key, value)````
- application scope

## Sende form parametre fra en JSP-side til en servlet
I servletten: ````request.getParameter(key)```` <br/>
I jsp: lav en form og sæt name = "parameter"
````html
<form action = "login" method="post">
    Login: <input type="text" name="login">/><br/>
    Password: <input type="password" name="password"/><br/>
    <button type="submit" >Log ind</button>
</form>
````

## Forward til websider
````
request.getRequestDispatcher("index.jsp").forward(request, response);
````


## JSTL
Husk at sætte JSTL dependency i POM-fil.
````html
<dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>jstl</artifactId>
        <version>1.2</version>
</dependency>
````
Indsæt følgende i topppen af jsp siden:
````html
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
````
- if
- forEach

## Expression Language 