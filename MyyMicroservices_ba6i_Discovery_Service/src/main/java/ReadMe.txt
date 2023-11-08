While creating this project add 
eureka server dependency

Run this project with
ba6ii_Employee_Service
ba6ii_Address_Service
ba6iii_Address_Service
together 
this three are client service of
this Discovery Service

When these client services starts,
they know where eureka usually runs.
it's 8761.
So they use the default localhost:8761/eureka
to connect and register themselves with eureka

But if we run our Discovery service on 
different port rather than using 8761
then we need to let these client services 
know where eureka is running. 
For e.g localhost:8088
If we don't do, it will by default try to
look for eureka in 8761 port number and
that will result exception and 
registration failure.