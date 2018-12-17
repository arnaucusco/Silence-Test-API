# Silence Test API

Simple HTTP API which allows:
- Turn on/off a scooter
- Move the scooter GPS coordinate
- Get the scooter's trips information, distance in meters and time in minutes

## Getting Started

The application starts two scooters whith ids 1 and 2. Once the the jar application is running, do some of the following calls:

Turn the scooter on/off:

```
localhost:8080/turnOn?scooterId=1&turnOn=true
```

Change the scooter location:

```
localhost:8080/move?scooterId=1&latitude=41.3461265&longitude=1.6979398
````

Get scooter trips information:

```
localhost:8080/getTrips?scooterId=1
````