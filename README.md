# Car rental demo

This is a demo project for car rental.

Click here http://jvblog.nat100.top to visit online web demo.

# Solution design:

1) Customers are distinguished by phone number, and one customer can only book one car.
2) If booking information is conformed, the car will be locked for two hours.
3) Customers need to come to our store to provide more neccessory information and pay the bill before they driving their
   booked car away.
4) If the car is not comfirm within tow hours, it will be unlocked and be free to book for other customers.

# API spec

I design three APIs to book cars for customers, the APIs are list as follows:

1) GET http://jvblog.nat100.top/car/model
   > Customers can get a model list through this API.
2) GET http://localhost:9098/car?model={model}
   > With this API, customers can get a car list of specified model that are available to book. By the way, A model-name is required.
3) POST http://localhost:9098/car/booking
   > Customers can book a car through this API. The content-type must be a json.
   >
   The required data is as follows:
   >
   >{id: "1", carModel: "Toyota Camry ", name: "name", phone: "15659887744", address: "wall street"}
   >
   > explain:
   >
   >     id: carId
   >
   >     name:renter name
   >
   >     phone: renter phone

   
    
