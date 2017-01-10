/*
 * Copyright 2016 fcomb. <https://github.com/fcomb/akka-http-circe>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.fcomb.akka.http

import akka.http.scaladsl.marshalling.{Marshaller, ToEntityMarshaller}
import akka.http.scaladsl.model.{ContentTypes, MediaTypes}
import akka.http.scaladsl.unmarshalling.{FromEntityUnmarshaller, Unmarshaller}
import akka.util.ByteString
import cats.syntax.either._
import io.circe.jawn._
import io.circe.syntax._
import io.circe.{Decoder, Encoder, Printer}
import java.lang.String

trait CirceSupport {
  private final val compactPrinter: Printer = Printer(
    preserveOrder = false,
    dropNullKeys = true,
    indent = ""
  )

  final implicit def jsonUnmarshaller[T: Decoder]: FromEntityUnmarshaller[T] =
    Unmarshaller.byteArrayUnmarshaller
      .forContentTypes(ContentTypes.`application/json`)
      .mapWithCharset {
        case (bytes, charset) =>
          if (bytes.length == 0) throw Unmarshaller.NoContentException
          else decode(new String(bytes, charset.nioCharset.name)).valueOr(throw _)
      }

  final implicit def jsonMarshaller[T: Encoder](
      implicit printer: Printer = compactPrinter): ToEntityMarshaller[T] =
    Marshaller
      .byteStringMarshaller(MediaTypes.`application/json`)
      .compose(obj => ByteString(printer.prettyByteBuffer(obj.asJson)))
}

object CirceSupport extends CirceSupport
