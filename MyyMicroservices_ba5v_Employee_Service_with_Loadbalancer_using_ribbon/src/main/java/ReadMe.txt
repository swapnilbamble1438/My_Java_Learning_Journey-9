
Note: For Trying this, try running this project and 
      the project(ba5ii_Address_Service) 
      and (ba5vi_Address_Service) together
      
Try employee details,
sometime it will make call to 8082 port(ba5ii_Address_Service)
and sometime it will make call to 8083 port(ba5vi_Address_Service)
to get the address of service.
so basically it will not always call one server to get 
the address it will randomly call the server.
so here all load is not going to only one server.
so this is called loadbalancing.
      
      
      