# Akka Http Circe

[![Build Status](https://travis-ci.org/fcomb/akka-http-circe.svg?branch=develop)](https://travis-ci.org/fcomb/akka-http-circe)
[![License](https://img.shields.io/:license-Apache-green.svg)](http://www.apache.org/licenses/LICENSE-2.0)

Akka Http marshallers for [Circe](https://github.com/travisbrown/circe).

## Dependencies

* scala 2.11/2.12
* circe 0.6.0
* akka-http 10.0.0-RC2

## Add to project

### Add resolvers to your `build.sbt`

```scala
resolvers += Resolver.bintrayRepo("fcomb", "maven")
```

### Add dependencies to your `build.sbt`

```scala
libraryDependencies += "io.fcomb" %% "akka-http-circe" % "1.0-RC2"
```

## Usage

```scala
import io.fcomb.akka.http.CirceSupport._

entity(as[SomeRequest]) { req => /* ... */ }
complete((StatusCodes.OK, SomeResponse(/* ... */)))
```
