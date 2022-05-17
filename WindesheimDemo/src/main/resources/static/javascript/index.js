// const places = [{
//         title: "Hogeschool Windesheim",
//         location: { lat: 52.49953, lng: 6.07845 }
//     },
//     {
//         title: "Engelse werk",
//         location: { lat: 52.4970232, lng: 6.06394 }
//     },
//     {
//         title: "Scania",
//         location: { lat: 52.5255141, lng: 6.0800041 }
//     },
//     {
//         title: "McDonalds Noord",
//         location: { lat: 52.5224281, lng: 6.1145818 }
//     },
//     {
//         title: "Hogeschool Windesheim",
//         location: { lat: 52.49953, lng: 6.07845 }
//     }
// ]

function initializePlaces(locations) {
    windows.places = [];
    window.places = locations;
}



function createMarkersPerPlace(map) {
    for (let { title, location }
        of window.places) {
        let position = new google.maps.LatLng(location);
        new google.maps.Marker({ position, map, title });
    }
}

// draws polylines between window.places
// see: https://developers.google.com/maps/documentation/javascript/examples/polyline-simple
function createLinesBetweenPlaces(map) {

    let path = window.places.map(place => place.location)
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
    const zwolle = new google.maps.LatLng(52.49953, 6.07845);

    // hier define je map.
    const map = new google.maps.Map(document.getElementById("map"), {
        center: zwolle,
        zoom: 12,
    });
    const coordInfoWindow = new google.maps.InfoWindow();

    coordInfoWindow.setContent(createInfoWindowContent(zwolle, map.getZoom()));
    coordInfoWindow.setPosition(zwolle);
    coordInfoWindow.open(map);
    map.addListener("zoom_changed", () => {
        coordInfoWindow.setContent(createInfoWindowContent(zwolle, map.getZoom()));
        coordInfoWindow.open(map);
    });
    // hier exit de functie en map als variable is weg, het heeft geen return
    // window.initMap is voor de googlemaps library de "start" functie, je void main(String[] args) :) 

    window.map = map;

}

const TILE_SIZE = 256;

function createInfoWindowContent(latLng, zoom) {
    const scale = 1 << zoom;
    const worldCoordinate = project(latLng);
    const pixelCoordinate = new google.maps.Point(
        Math.floor(worldCoordinate.x * scale),
        Math.floor(worldCoordinate.y * scale)
    );
    const tileCoordinate = new google.maps.Point(
        Math.floor((worldCoordinate.x * scale) / TILE_SIZE),
        Math.floor((worldCoordinate.y * scale) / TILE_SIZE)
    );
    return [
        "Hogeschool Windesheim",
        "Coordinaten: " + latLng,
        "Zoomniveau: " + zoom,
        "World Coordinaten: " + worldCoordinate,
        "Pixel Coordinaten: " + pixelCoordinate,
        "Tile Coordinaten: " + tileCoordinate,
    ].join("<br>");
}

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
    error.removeAttribute('hidden');
}

function submit(event) {
    event.preventDefault();
    fetch('http://localhost:8080/greeting', {
            method: 'POST',
            body: JSON.stringify( // dit ga je straks vullen met je form input fields (geolocs in geolocs uit)
                {
                    title: 'foo',
                    body: 'bar',
                    userId: 1
                }
            ),
            headers: {
                'Content-type': 'application/json; charset=UTF-8'
            }
        })
        .then(res => res.json())
        .then(json => {
            // console.log(json);
            window.places = json; //toekomst: window.places setten to NULL en daarna pas waarden geven.
            createMarkersPerPlace(window.map);
            createLinesBetweenPlaces(window.map);
        })
}

window.addEventListener('DOMContentLoaded', (event) => {
    const form = document.getElementById('myform'); // deze id zoekt het form op dus die moet wel bestaan
    // const error = document.getElementById('error');
    // const destination = document.getElementById('destination');
    // const thanks = document.getElementById('thanks');

    // destination.oninvalid = invalid; 
    form.onsubmit = submit;
});