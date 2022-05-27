window.selectlistSelected = null;
window.routelistSelected = null;

var targetRouteArray = [];

var routeArray = [
    {
        orderID: 1,
        customerID: 1,
        isRetour: false,
        name: "Windesheim",
        addressObject: {
            streetname: "campus",
            housenumber: 2,
            postalcode: "8017CA",
            city: "Zwolle",
            geolocation: { lat: 52.49953, lng: 6.07845 },
        },
    },
    {
        orderID: 2,
        customerID: 2,
        isRetour: false,
        name: "Marktplaatsman",
        addressObject: {
            streetname: "Bredestraat-Zuid",
            housenumber: "20",
            postalcode: "",
            city: "Herveld",
            geolocation: { lat: 52.089117, lng: 5.5409255 },
        },
    },
    {
        orderID: 3,
        customerID: 3,
        isRetour: false,
        name: "Klantnaam",
        addressObject: {
            streetname: "Stadhouderlaan",
            housenumber: "64",
            postalcode: "8016KB",
            city: "Zwolle",
            geolocation: { lat: 52.4843565, lng: 6.0936322 },
        },
    },
    {
        orderID: 4,
        customerID: 4,
        isRetour: true,
        name: "AH Distributie",
        addressObject: {
            streetname: "Galvaniweg",
            housenumber: 1,
            postalcode: "8013RG",
            city: "Zwolle",
            geolocation: { lat: 52.4948973, lng: 6.1340705 },
        },
    },
    {
        orderID: 5,
        customerID: 5,
        isRetour: true,
        name: "Huidverzorging Heino",
        addressObject: {
            streetname: "Dorpsstraat",
            housenumber: 55,
            postalcode: "8141AJ",
            city: "Heino",
            geolocation: { lat: 52.4379612, lng: 6.2314988 },
        },
    },
    {
        orderID: 6,
        customerID: 6,
        isRetour: true,
        name: "Oma Smink",
        addressObject: {
            streetname: "Sinte Brandaenstraat",
            housenumber: 10,
            postalcode: "3814 WZ",
            city: "Amersfoort",
            geolocation: { lat: 52.1710681, lng: 5.413297 },
        },
    },
    {
        orderID: 7,
        customerID: 7,
        isRetour: true,
        name: "Leon Bennen",
        addressObject: {
            streetname: "Burgemeester G.W. Stroïnkweg",
            housenumber: 67,
            postalcode: "8343XK",
            city: "Steenwijk",
            geolocation: { lat: 52.6009259, lng: 6.170882 },
        },
    },
    {
        orderID: 8,
        customerID: 8,
        isRetour: true,
        name: "Paleispark Kroondomein Het Loo",
        addressObject: {
            streetname: "",
            housenumber: "",
            postalcode: "7313AA",
            city: "Apeldoorn",
            geolocation: { lat: 52.2250347, lng: 5.9517327 },
        },
    },
    {
        orderID: 9,
        customerID: 9,
        isRetour: true,
        name: "Heitink Transport",
        addressObject: {
            streetname: "Kamperstraatweg",
            housenumber: "25",
            postalcode: "8278AB",
            city: "Kamperveen",
            geolocation: { lat: 52.4907005, lng: 5.9332327 },
        },
    },
    {
        orderID: 10,
        customerID: 10,
        isRetour: true,
        name: "Martijn Linde",
        addressObject: {
            streetname: "Willem Egbertsstraat",
            housenumber: "56",
            postalcode: "8061ED",
            city: "Hasselt",
            geolocation: { lat: 52.2250347, lng: 5.9517327 },
        },
    },
];

window.routeArray = routeArray;

function createMarkersPerPlace(map) {
    for (let { title, location } of window.places) {
        let position = new google.maps.LatLng(location);
        new google.maps.Marker({ position, map, title });
    }
}

// draws polylines between window.places
// see: https://developers.google.com/maps/documentation/javascript/examples/polyline-simple
function createLinesBetweenPlaces(map) {
    let path = window.places.map((place) => place.location);
    const transportPath = new google.maps.Polyline({
        path,
        geodesic: true,
        strokeColor: "#FF0000",
        strokeOpacity: 1.0,
        strokeWeight: 2,
    });

    transportPath.setMap(map);
}

function initMap() {
    const zwolle = new google.maps.LatLng(
        52.514622453500046,
        6.094557495652405
    );

    // hier define je map.
    const map = new google.maps.Map(document.getElementById("map"), {
        center: zwolle,
        zoom: 11,
    });
    const coordInfoWindow = new google.maps.InfoWindow();
    coordInfoWindow.setPosition(zwolle);
    // hier exit de functie en map als variable is weg, het heeft geen return
    // window.initMap is voor de googlemaps library de "start" functie, je void main(String[] args) :)

    window.map = map;
}

const TILE_SIZE = 256;

// The mapping between latitude, longitude and pixels is defined by the web
// mercator projection.
function project(latLng) {
    let siny = Math.sin((latLng.lat() * Math.PI) / 180);

    // Truncating to 0.9999 effectively limits latitude to 89.189. This is
    // about a third of a tile past the edge of the world tile.
    siny = Math.min(Math.max(siny, -0.9999), 0.9999);
    return new google.maps.Point(
        TILE_SIZE * (0.5 + latLng.lng() / 360),
        TILE_SIZE * (0.5 - Math.log((1 + siny) / (1 - siny)) / (4 * Math.PI))
    );
}

window.initMap = initMap;

function invalid(event) {
    error.removeAttribute("hidden");
}

function setRouteOnMap() {
    fetch("http://localhost:8080/greeting", {
        method: "POST",
        body: JSON.stringify(
            // dit ga je straks vullen met je form input fields (geolocs in geolocs uit)
            {
                title: "foo",
                body: "bar",
                userId: 1,
            }
        ),
        headers: {
            "Content-type": "application/json; charset=UTF-8",
        },
    })
        .then((res) => res.json())
        .then((json) => {
            console.log(json);
            window.places = json;
            createMarkersPerPlace(window.map);
            createLinesBetweenPlaces(window.map);
        });
}

function setCreatedRouteOnMap(postbody) {
    fetch("http://localhost:8080/response", {
        method: "POST",
        body: postbody,
        headers: {
            "Content-type": "application/json; charset=UTF-8",
        },
    })
        .then((res) => res.json())
        .then((json) => {
            console.log("data te versturen" + json);
            initMap();
            window.places = json;
            createMarkersPerPlace(window.map);
            createLinesBetweenPlaces(window.map);
        });
}

const listData = window.routeArray.map((value) => {
    return {
        id: value.orderID,
        value:
            "ORDER:" +
            value.orderID +
            ", CUSTOMER: " +
            value.customerID +
            ", ISRETOUR: " +
            value.isRetour +
            ", ADDRESS: " +
            value.addressObject.streetname +
            " " +
            value.addressObject.housenumber +
            " " +
            value.addressObject.postalcode +
            " " +
            value.addressObject.city,
        routename:
            "CUSTOMER " + value.customerID + "FROM " + value.addressObject.city,
        location: {
            lat: value.addressObject.geolocation.lat,
            lng: value.addressObject.geolocation.lng,
        },
    };
});

function setNewMap(input) {
    const data = JSON.parse(input);
    postbody = JSON.stringify(data);
    console.log("postbody: " + postbody);

    console.log(setCreatedRouteOnMap(postbody));
}
