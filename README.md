# Akka Http Circe

[![Build Status](https://travis-ci.org/fcomb/akka-http-circe.svg?branch=develop)](https://travis-ci.org/fcomb/akka-http-circe)
[![License](https://img.shields.io/:license-Apache-green.svg)](http://www.apache.org/licenses/LICENSE-2.0)

Akka Http marshallers for [Circe](https://github.com/travisbrown/circe).

## Dependencies

* scala 2.11/2.12
* circe 0.8.0-RC1
* akka-http 10.0.6

## Add to project

### Add resolvers to your `build.sbt`

```scala
resolvers += Resolver.bintrayRepo("fcomb", "maven")
```

### Add dependencies to your `build.sbt`

Version is a string consisting of versions of akka-http and circe: `${akkaHttp}_${circe}`.

```scala
libraryDependencies += "io.fcomb" %% "akka-http-circe" % "10.0.6_0.8.0-RC1" // latest version
```

## Release

| akka-http-circe Release | Target akka-http version | Target circe version |
|-------|---------------------|---------------------|
|10.0.6_0.8.0-RC1|10.0.6|0.8.0-RC1|
|10.0.5_0.7.1|10.0.5|0.7.1|
|10.0.5_0.7.0|10.0.5|0.7.0|
|10.0.4_0.7.0|10.0.4|0.7.0|
|10.0.3_0.7.0|10.0.3|0.7.0|
|10.0.2_0.7.0|10.0.2|0.7.0|
|10.0.1_0.7.0|10.0.1|0.7.0|
|10.0.0_0.6.1|10.0.0|0.6.1|
|10.0.0_0.6.0|10.0.0|0.6.0|

## Usage

```scala
import io.fcomb.akka.http.CirceSupport._

entity(as[SomeRequest]) { req => /* ... */ }
complete((StatusCodes.OK, SomeResponse(/* ... */)))
```
