package com.lightbend.lagom.recipes.corsscala.api

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.{ Service, ServiceCall }


trait CorsscalaService extends Service {

  def hello(id: String): ServiceCall[NotUsed, String]

  override final def descriptor = {
    import Service._
    named("corsscala")
      .withCalls(
        pathCall("/api/hello/:id", hello _)
      )
      .withAutoAcl(true)
  }
}

