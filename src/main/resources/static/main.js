var map;
var markers = [];
var myPosition;

function initMap() {

    var uluru = {lat: -25.363, lng: 131.044};

    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 16,
        center: uluru
    });
    myPosition = new google.maps.Marker({
        map: map
    });

    if (navigator.geolocation) {
        navigator.geolocation.watchPosition(showPosition);
    } else {
        console.log("No gps");
    }
}

function onChangeCallBack(){


    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition);
    } else {
        console.log("GPS not supported");
    }

}

function showPosition(location) {

    console.log(location);

    var myCoord = new google.maps.LatLng(location.coords.latitude,
        location.coords.longitude)
    myPosition.setPosition(myCoord);
    map.panTo(myCoord);


    $.ajax({
        url: createGetRequest(location)
    }).then(function (data) {
        console.log(data);
        clearMarkers();
        addAllMarkers(data);
    });

}

function createGetRequest(position) {
    var url = "http://localhost:8080/places?latitude=" + position.coords.latitude + "&longitude=" + position.coords.longitude;

    if (document.getElementById('roadRepairs').checked) {
        url += "&eventType=ROAD_REPAIRS";
    }
    if (document.getElementById('publicTransportFailure').checked) {
        url += "&eventType=PUBLIC_TRANSPORT_FAILURE";
    }

    if (document.getElementById('trafficJams').checked) {
        url += "&eventType=JAM";
    }

    return url;
}

function addAllMarkers(data) {
    for (var i = 0; i < data.length; i++) {

        markers[i] = new google.maps.Marker({
            position: new google.maps.LatLng({
                lat: data[i].position.latitude,
                lng: data[i].position.longitude,
            }),
            map: map,
            icon: ChooseColor(data[i])
        });


    }
}

function ChooseColor(data) {
    switch (data.eventType) {
        case 'ROAD_REPAIRS':
            return 'http://maps.google.com/mapfiles/ms/icons/blue-dot.png';
        case 'PUBLIC_TRANSPORT_FAILURE':
            return 'http://maps.google.com/mapfiles/ms/icons/green-dot.png';
    }
}

function setMapOnAll(map) {
    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(map);
    }
}

function clearMarkers() {
    setMapOnAll(null);
    markers = [];
}

function addToDescription(data) {
    $("#desc").empty();
    for (var i = 0; i < data.length; i++) {

        var paragraph = document.createElement("P");
        var t = document.createTextNode(data[i].eventDescription);
        paragraph.appendChild(t);
        document.getElementById("desc").appendChild(paragraph);
    }

}