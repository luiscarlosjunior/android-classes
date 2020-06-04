Google Maps Android API Demos
===================================

These are demos for the [Maps SDK for Android](https://developers.google.com/maps/documentation/android-api/)
and [Maps SDK for Android V3 BETA](https://developers.google.com/maps/documentation/android-sdk/v3-client-migration) libraries
in the Java programming language.

They demonstrate most of the features available in the API.

This app was written with a minSdk of 16 and the androidx appcompat library, but it can be easily 
adapted to use native functionality instead (for example replacing `SupportMapFragment` with 
`MapFragment`).

The Maps SDK for Android samples can be found under the `gms` gradle product flavor, while the Maps
SDK V3 BETA samples can be found under the `v3` gradle product flavor.

Pre-requisites
--------------

- Android SDK v29
- Latest Android Build Tools
- Android Support Repository
- Google Repository
- Google Play services

Getting Started
---------------

This sample use the Gradle build system.

First download the samples by cloning this repository or downloading an archived
snapshot. (See the options at the top of the page.)

In Android Studio, use "Open an existing Android Studio project".
Next select the `ApiDemos/java/` directory that you downloaded from this repository.
If prompted for a gradle configuration accept the default settings. 

Alternatively use the `gradlew build` command to build the project directly.

This demo app requires that you add your own Google Maps API key:

1. [Get a Maps API key](https://developers.google.com/maps/documentation/android-sdk/get-api-key)
1. Create a file in the `ApiDemos/java` directory called `secure.properties` (this file should *NOT* be under version control to protect your API key)
1. Add a single line to `ApiDemos/java/secure.properties` that looks like `MAPS_API_KEY=YOUR_API_KEY`, where `YOUR_API_KEY` is the API key you obtained in the first step
1. Build and run

Support
-------

- Stack Overflow: https://stackoverflow.com/questions/tagged/android+google-maps

If you have discovered an issue with the Google Maps Android API v2, please see
the resources here: https://developers.google.com/maps/documentation/android-api/support

If you've found an error in these samples, please file an issue:
https://github.com/googlemaps/android-samples/issues

Patches are encouraged, and may be submitted according to the instructions in
CONTRIBUTING.md.

![Analytics](https://ga-beacon.appspot.com/UA-12846745-20/android-samples-apidemos/readme?pixel)

License
-------

Please refer to the [LICENSE](https://github.com/googlemaps/android-samples/blob/master/LICENSE) at the root of this repo.
