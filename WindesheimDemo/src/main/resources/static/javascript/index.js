window.selectlistSelected = null;
window.routelistSelected = null;

var targetRouteArray = [];

var routeArray = [
    {
        orderID: 1,
        customerID: 1,
        isRetour: false,
        name: "William Campus",
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
        name: "Barend Drecht",
        addressObject: {
            streetname: "",
            housenumber: "",
            postalcode: "",
            city: "Barendrecht",
            geolocation: { lat: 51.853, lng: 4.4539 },
        },
    },
    {
        orderID: 3,
        customerID: 3,
        isRetour: false,
        name: "scania",
        addressObject: {
            streetname: "",
            housenumber: "",
            postalcode: "",
            city: "Zwolle",
            geolocation: { lat: 52.5255141, lng: 6.0800041 },
        },
    },
    {
        orderID: 4,
        customerID: 4,
        isRetour: true,
        name: "Zoetermeer",
        addressObject: {
            streetname: "campus",
            housenumber: 2,
            postalcode: "8017CA",
            city: "Zoetermeer",
            geolocation: { lat: 52.0621451, lng: 4.4165747 },
        },
    },
    {
        orderID: 5,
        customerID: 4,
        isRetour: true,
        name: "Hogeschool Windesheim",
        addressObject: {
            streetname: "campus",
            housenumber: 2,
            postalcode: "8017CA",
            city: "Zwolle",
            geolocation: { lat: 52.49953, lng: 6.07845 },
        },
    },
    {
        orderID: 6,
        customerID: 4,
        isRetour: true,
        name: "Hogeschool Windesheim",
        addressObject: {
            streetname: "campus",
            housenumber: 2,
            postalcode: "8017CA",
            city: "Zwolle",
            geolocation: { lat: 52.49953, lng: 6.07845 },
        },
    },
    {
        orderID: 7,
        customerID: 4,
        isRetour: true,
        name: "Hogeschool Windesheim",
        addressObject: {
            streetname: "campus",
            housenumber: 2,
            postalcode: "8017CA",
            city: "Zwolle",
            geolocation: { lat: 52.49953, lng: 6.07845 },
        },
    },
    {
        orderID: 8,
        customerID: 4,
        isRetour: true,
        name: "Hogeschool Windesheim",
        addressObject: {
            streetname: "campus",
            housenumber: 2,
            postalcode: "8017CA",
            city: "Zwolle",
            geolocation: { lat: 52.49953, lng: 6.07845 },
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
        zoom: 13,
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
        location: {
            lat: value.addressObject.geolocation.lat,
            lng: value.addressObject.geolocation.lng,
        },
    };
});

function setNewMap(input) {
    const data = JSON.parse(input);
    postbody = JSON.stringify(data);
    // postbody = data; //werkt ook check ff
    // for (var i = 0; i < data.length; i++) {
    //     postbody.push(
    //         JSON.stringify({
    //             id: data[i].id,
    //             value: data[i].value,
    //             geolocation: data[i].geolocation,
    //         })
    //     );
    // }
    console.log("postbody: " + postbody);

    console.log(setCreatedRouteOnMap(postbody));
}
